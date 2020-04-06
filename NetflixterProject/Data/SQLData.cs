using Model;
using MySql.Data.MySqlClient;
using System.Collections.Generic;

namespace Data
{
    public class SQLData : IDataAccess
    {
        private readonly string _connectionString = "server=localhost;port=3306;user=root;password=password;";
        private MySqlConnection _sqlConnection;
        private void OpenConnection()
        {
            _sqlConnection = new MySqlConnection(_connectionString);
            _sqlConnection.Open();
        }

        private void CloseConnection()
        {
            _sqlConnection.Close();
            _sqlConnection.Dispose();
        }

        public IEnumerable<Title> GetTitlesInListView()
        {
            OpenConnection();

            var stm = $"USE netflix_db; " +
                    $"CREATE VIEW list_view AS " +
                        $"SELECT t1.Id AS TitleId, t1.Name, `Release Year`, Description, `Date Added`, `Age Rating`, Duration, Type, t3.Name AS Genre " +
                        $"FROM netflix_db.titles t1 " +
                        $"JOIN netflix_db.`title-genres` t2 " +
                        $"ON t1.Id = t2.TitleId " +
                        $"JOIN netflix_db.genres t3 " +
                        $"ON t2.GenreId = t3.Id; " +
                      $"SELECT * FROM list_view; " +
                      $"DROP VIEW list_view; ";

            var cmd = new MySqlCommand(stm, _sqlConnection);
            var reader = cmd.ExecuteReader();

            var set = new HashSet<Title>();
            while (reader.Read())
            {
                var row = new object[9];
                reader.GetValues(row);

                var title = LoadTitle(row);
                if (!set.Contains(title))
                    set.Add(title);
                set.TryGetValue(title, out var t);
                t.Genres.Add(LoadGenre(new object[] { row[8] }));
            }

            CloseConnection();

            return set;
        }

        private Genre LoadGenre(object[] row)
        {
            return new Genre()
            {
                Name = row[0] as string
            };
        }

        public int GetTitleIdByColumn(string column, string item)
        {
            OpenConnection();

            var stm = $"SELECT Id FROM netflix_db.titles WHERE `{column}` = '{item}';";
            var cmd = new MySqlCommand(stm, _sqlConnection);
            var res = cmd.ExecuteScalar()?.ToString() ?? "0";

            if (!int.TryParse(res, out int id))
                id = 0;

            CloseConnection();
            return id;
        }

        private Title LoadTitle(object[] data)
        {
            return new Title()
            {
                Id = (int)data[0],
                Name = data[1] as string,
                ReleaseYear = (int)data[2],
                Description = data[3] as string,
                DateAdded = data[4] as string,
                AgeRating = data[5] as string,
                Duration = data[6] as string,
                Type = data[7] as string
            };
        }

        public IEnumerable<Genre> GetAllGenres()
        {
            OpenConnection();

            var stm = "SELECT Name FROM netflix_db.genres;";
            var cmd = new MySqlCommand(stm, _sqlConnection);
            var reader = cmd.ExecuteReader();

            var list = new List<Genre>();
            while (reader.Read())
            {
                var row = new object[1];
                reader.GetValues(row);
                list.Add(LoadGenre(row));
            }

            CloseConnection();
            return list;
        }

        public IEnumerable<Country> GetCountriesByTitleId(int id)
        {
            OpenConnection();
            var stm = $"USE netflix_db; " +
                $"CREATE TABLE T AS " +
                $"SELECT CountryName " +
                $"FROM netflix_db.`title-countries` " +
                $"WHERE {id} = TitleId; " +
                $"SELECT t1.Name FROM netflix_db.countries t1 " +
                $"JOIN T t2 " +
                $"ON t1.Name = t2.CountryName; " +
                $"DROP TABLE T;";
            var cmd = new MySqlCommand(stm, _sqlConnection);
            var reader = cmd.ExecuteReader();

            var countries = new List<Country>();
            while (reader.Read())
            {
                var value = reader.GetValue(0) as string;
                countries.Add(new Country() { Name = value });
            }
            CloseConnection();
            return countries;
        }

        public IDictionary<string, long> GetTitleCountGroupByCountry()
        {
            OpenConnection();
            var stm = $"SELECT COUNT(TitleId), CountryName " +
                $"FROM netflix_db.`title-countries` " +
                $"GROUP BY CountryName " +
                $"ORDER BY COUNT(TitleId) DESC; ";
            var cmd = new MySqlCommand(stm, _sqlConnection);
            var reader = cmd.ExecuteReader();

            var dict = new Dictionary<string, long>();
            while(reader.Read())
            {
                dict.Add(reader.GetValue(1) as string, (long) reader.GetValue(0));
            }
            CloseConnection();
            return dict;
        }

        public IDictionary<string, long> GetTitleCountGroupByGenre()
        {
            OpenConnection();
            var stm = $"SELECT COUNT(TitleId), Name " +
                "FROM netflix_db.`title-genres` t1 " +
                  "JOIN netflix_db.genres t2 " +
                "ON t1.GenreId = t2.Id " +
                "GROUP BY GenreId " +
                "ORDER BY COUNT(TitleId) DESC; ";
            var cmd = new MySqlCommand(stm, _sqlConnection);
            var reader = cmd.ExecuteReader();

            var dict = new Dictionary<string, long>();
            while (reader.Read())
            {
                dict.Add(reader.GetValue(1) as string, (long) reader.GetValue(0));
            }
            CloseConnection();
            return dict;
        }
    }
}
