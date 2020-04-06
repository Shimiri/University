using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace Model
{
    public class Country : IEquatable<Country>
    {
        public string Name { get; set; }
        public int Titles { get; set; }
        public bool Equals([AllowNull] Country other)
        {
            if (other is null)
                return false;
            return string.Equals(Name, other.Name, System.StringComparison.InvariantCultureIgnoreCase);
        }

        public override bool Equals(object obj)
        {
            return Equals(obj as Country);
        }

        public override int GetHashCode()
        {
            return string.GetHashCode(Name, StringComparison.InvariantCultureIgnoreCase);
        }
    }
}
