using Model;
using System;
using System.Collections.Generic;
using System.Text;

namespace Data
{
    public interface IDataAccess
    {
        public int GetTitleIdByColumn(string column, string item);
        public IEnumerable<Country> GetCountriesByTitleId(int id);
        public IEnumerable<Title> GetTitlesInListView();
        public IEnumerable<Genre> GetAllGenres();
        public IDictionary<string, long> GetTitleCountGroupByCountry();
        public IDictionary<string, long> GetTitleCountGroupByGenre();
    }
}
