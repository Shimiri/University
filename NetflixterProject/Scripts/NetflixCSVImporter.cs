using CsvHelper;
using Model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Scripts
{
    public class NetflixCSVImporter
    {
        private readonly StreamReader _reader;
        private readonly CsvReader _csv;
        private readonly string _pathToCSVFile = "C:/Users/Samuel/Github/Netflixter/Netflixter/Scripts/Resources/netflix_titles_nov_2019.csv";
        public NetflixCSVImporter()
        {
            _reader = new StreamReader(_pathToCSVFile);
            _csv = new CsvReader(_reader);
        }

        public IEnumerable<Person> ParsePeople()
        {
            using (_csv)
            {
                _csv.Read();
                _csv.ReadHeader();
                HashSet<Person> people = new HashSet<Person>();
                while (_csv.Read())
                {
                    _csv.GetField<string>("cast")
                        .Split(",")
                        .Select(actor => new Person() { Name = actor.Trim(), Role = Role.Actor })
                        .ToList()
                        .ForEach(person => people.Add(person));
                    _csv.GetField<string>("director")
                        .Split(",")
                        .Select(director => new Person() { Name = director.Trim(), Role = Role.Director })
                        .ToList()
                        .ForEach(director => people.Add(director));
                }
                return people;
            }
        }

        public IEnumerable<Genre> ParseGenres()
        {
            using (_csv)
            {
                _csv.Read();
                _csv.ReadHeader();
                HashSet<Genre> genres = new HashSet<Genre>();
                while (_csv.Read())
                {
                    _csv.GetField<string>("listed_in")
                        .Split(",")
                        .Select(genre => new Genre() { Name = genre.Trim() })
                        .ToList()
                        .ForEach(genre => genres.Add(genre));
                }
                return genres;
            }
        }
        public IEnumerable<Country> ParseCountries()
        {
            using (_csv)
            {
                _csv.Read();
                _csv.ReadHeader();
                HashSet<Country> countries = new HashSet<Country>();
                while (_csv.Read())
                {
                    _csv.GetField<string>("country")
                        .Split(",")
                        .Select(country => new Country() { Name = country.Trim() })
                        .ToList()
                        .ForEach(country => countries.Add(country));
                }
                return countries;
            }
        }

        public List<Title> ParseTitles()
        {
            using (_csv)
            {
                _csv.Read();
                _csv.ReadHeader();
                List<Title> titles = new List<Title>();
                while (_csv.Read())
                {
                    try
                    {
                        var id = _csv.GetField<int>("show_id");
                        var name = _csv.GetField<string>("title").Trim();
                        var dateAdded = _csv.GetField<string>("date_added").Trim();
                        var releaseYear = _csv.GetField<int>("release_year");
                        var duration = _csv.GetField<string>("duration").Trim();
                        var rating = _csv.GetField<string>("rating").Trim();
                        var type = _csv.GetField<string>("type").Trim();
                        var description = _csv.GetField<string>("description").Trim();

                        titles.Add(new Title()
                        {
                            Id = id,
                            Name = name,
                            DateAdded = dateAdded,
                            ReleaseYear = releaseYear,
                            AgeRating = rating,
                            Rating = 0,
                            Description = description,
                            Type = type
                        });
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex.Message);
                        Console.WriteLine(ex.Data);
                    }

                }
                Console.WriteLine("Finished Parsing csv file");
                return titles;
            }
        }

        public IDictionary<int, List<string>> ParseTitleGenreMapping()
        {
            IDictionary<int, List<string>> map = new Dictionary<int, List<string>>();
            using (_csv)
            {
                _csv.Read();
                _csv.ReadHeader();
                while (_csv.Read())
                {
                    int id = 0;
                    try
                    {
                        id = _csv.GetField<int>("show_id");
                        var genres = _csv.GetField<string>("listed_in")
                            .Split(",")
                            .Select(c => c.Trim())
                            .ToList();
                        map.Add(id, genres);
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex.Message);
                    }
                }
                return map;
            }
        }

        public IDictionary<int, List<string>> ParseTitlePeopleMapping()
        {
            IDictionary<int, List<string>> map = new Dictionary<int, List<string>>();
            using (_csv)
            {
                _csv.Read();
                _csv.ReadHeader();
                while (_csv.Read())
                {
                    int id = 0;
                    try
                    {
                        id = _csv.GetField<int>("show_id");
                        var cast = _csv.GetField<string>("cast")
                            .Split(",")
                            .Select(c => c.Trim())
                            .ToList();
                        var directors = _csv.GetField<string>("director")
                            .Split(",")
                            .Select(c => c.Trim())
                            .ToList();

                        map.Add(id, cast);
                        map.TryGetValue(id, out var list);
                        list.AddRange(directors);
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex.Message);
                    }
                }
                return map;
            }
        }

        public IDictionary<int, List<string>> ParseTitleCountryMapping()
        {
            IDictionary<int, List<string>> map = new Dictionary<int, List<string>>();
            using (_csv)
            {
                _csv.Read();
                _csv.ReadHeader();
                while (_csv.Read())
                {
                    int id = 0;
                    try
                    {
                        id = _csv.GetField<int>("show_id");
                        var countries = _csv.GetField<string>("country")
                            .Split(",")
                            .Select(c => c.Trim())
                            .ToList();

                        map.Add(id, countries);
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex.Message);
                    }
                }
                return map;
            }
        }
    }
}
