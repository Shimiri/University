using Model;
using MySql.Data.MySqlClient;
using MySqlX.XDevAPI;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Scripts
{
    public class DataUploader
    {
        private readonly string _connectionXString = "server=localhost;port=33060;user=root;password=password;";
        private readonly string _connectionString = "server=localhost;port=3306;user=root;password=password;";
        private Session _session;
        private Schema _netflixDatabase;
        public DataUploader()
        {

        }

        public void ConnectToDatabase()
        {
            _session = MySQLX.GetSession(_connectionXString);
            _netflixDatabase = _session.GetSchema("netflix_db");
        }

        public void AddPeople(IEnumerable<Person> people)
        {
            var peopleTable = _netflixDatabase.GetTable("people");
            _session.StartTransaction();
            try
            {
                people
                    .ToList()
                    .ForEach(person =>
                    {
                        if (!string.IsNullOrWhiteSpace(person.Name))
                        {
                            peopleTable.Insert("Name", "Role")
                                .Values($"'{person.Name}'", $"'{person.Role.ToString()}'")
                                .Execute();
                            Console.WriteLine($"Inserted: {person.Name}");
                        }
                    });
                _session.Commit();
            }
            catch (MySqlException ex)
            {
                _session.Rollback();
                Console.WriteLine(ex);
            }
        }

        public void AddGenres(IEnumerable<Genre> genres)
        {
            var genreTable = _netflixDatabase.GetTable("genres");
            _session.StartTransaction();
            try
            {
                genres
                    .ToList()
                    .ForEach(genre =>
                    {
                        if (!string.IsNullOrWhiteSpace(genre.Name))
                        {
                            genreTable.Insert("Name")
                                .Values($"'{genre.Name}'")
                                .Execute();
                            Console.WriteLine($"Inserted: {genre.Name}");
                        }
                    });
                _session.Commit();
            }
            catch (MySqlException ex)
            {
                _session.Rollback();
                Console.WriteLine(ex);
            }
        }

        public void AddCountries(IEnumerable<Country> countries)
        {
            var table = _netflixDatabase.GetTable("countries");
            _session.StartTransaction();
            try
            {
                countries
                    .ToList()
                    .ForEach(country =>
                    {
                        if (!string.IsNullOrWhiteSpace(country.Name))
                        {
                            table.Insert("Name")
                                .Values($"'{country.Name}'")
                                .Execute();
                            Console.WriteLine($"Inserted: {country.Name}");
                        }
                    });
                _session.Commit();
            }
            catch (MySqlException ex)
            {
                _session.Rollback();
                Console.WriteLine(ex);
            }
        }

        public void AddTitles(List<Title> titles)
        {
            var table = _netflixDatabase.GetTable("titles");
            _session.StartTransaction();
            foreach (Title title in titles)
            {
                try
                {
                    table
                        .Insert("Id", "Name", "`Release Year`", "Description", "`Date Added`", "`Age Rating`", "Rating", "Type")
                        .Values($"'{title.Id}'", $"'{title.Name}'", $"'{title.ReleaseYear}'", $"'{title.Description}'", $"'{title.DateAdded}'", $"'{title.AgeRating}'", $"'{title.Rating}'", $"'{title.Type}'")
                        .Execute();
                    Console.WriteLine($"Executed: {title.Name}");
                }
                catch (MySqlException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine(ex.Data);
                }
            }
            _session.Commit();
            Console.WriteLine("Finished Data Upload");
        }


        public void PopulateGenreTitleMapping(IDictionary<int, List<string>> map)
        {
            using var con = new MySqlConnection(_connectionString);
            con.Open();

            foreach (int key in map.Keys)
            {
                map.TryGetValue(key, out List<string> result);
                foreach (string genre in result)
                {
                    try
                    {
                        var g = genre;
                        if (g.Contains("\'"))
                        {
                            var i = g.IndexOf("\'");
                            g = g.Insert(i, "\\");
                        }
                        var stm = $"SELECT Id FROM netflix_db.genres WHERE Name = \'{g}\';";
                        var cmd = new MySqlCommand(stm, con);
                        Console.WriteLine(stm);
                        var res = cmd.ExecuteScalar().ToString();
                        stm = $"INSERT INTO netflix_db.`title-genres` (TitleId, GenreId) VALUES ('{key}', '{res}');";
                        cmd = new MySqlCommand(stm, con);
                        cmd.ExecuteNonQuery();
                        Console.WriteLine($"Executed: {genre}");
                    }
                    catch (MySqlException ex)
                    {
                        Console.WriteLine(ex.Message);
                        Console.WriteLine(ex.Data);
                    }
                    catch (NullReferenceException ex)
                    {
                        Console.WriteLine(ex.Message);
                        Console.WriteLine(ex.Data);
                    }
                }
            }
        }

        public void PopulatePeopleTitleMapping(IDictionary<int, List<string>> map)
        {
            using var con = new MySqlConnection(_connectionString);
            con.Open();

            foreach (int key in map.Keys)
            {

                map.TryGetValue(key, out List<string> result);
                foreach (string person in result)
                {
                    if (string.IsNullOrWhiteSpace(person))
                        continue;
                    try
                    {
                        var stm = $"SELECT Id FROM netflix_db.people WHERE Name = '{person}';";
                        Console.WriteLine(stm);
                        var cmd = new MySqlCommand(stm, con);
                        var res = cmd.ExecuteScalar().ToString();
                        stm = $"INSERT INTO netflix_db.`title-people` (TitleId, PersonId) VALUES ({key}, {res});";
                        cmd = new MySqlCommand(stm, con);
                        cmd.ExecuteNonQuery();
                        Console.WriteLine($"Executed: {person}");

                    }
                    catch (MySqlException ex)
                    {
                        Console.WriteLine(ex.Message);
                        Console.WriteLine(ex.Data);
                    }
                    catch (NullReferenceException ex)
                    {
                        Console.WriteLine(ex.Message);
                        Console.WriteLine(ex.Data);
                    }
                }
            }
        }

        public void PopulateCountryTitleMapping(IDictionary<int, List<string>> map)
        {
            using var con = new MySqlConnection(_connectionString);
            con.Open();

            foreach (int key in map.Keys)
            {
                try
                {
                    map.TryGetValue(key, out List<string> result);
                    foreach (string country in result)
                    {
                        if (string.IsNullOrWhiteSpace(country))
                            continue;

                        var stm = $"INSERT INTO netflix_db.`title-countries` (TitleId, CountryName) VALUES ('{key}', '{country}');";
                        Console.WriteLine(stm);
                        var cmd = new MySqlCommand(stm, con);
                        cmd.ExecuteNonQuery();
                        Console.WriteLine($"Executed: {country}");
                    }
                }
                catch (MySqlException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine(ex.Data);
                }
                catch (NullReferenceException ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine(ex.Data);
                }
            }
        }
    }
}

