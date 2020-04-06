using System;
using System.Collections.Generic;
using System.Text;

namespace Model
{
    public class SearchFormData
    {
        public string SearchTerm { get; set; } = "";
        public bool MovieChecked { get; set; } = false;
        public bool ShowChecked { get; set; } = false;
        public int? ReleaseYear { get; set; } = null;
        public string Genre { get; set; } = "";
    }
}
