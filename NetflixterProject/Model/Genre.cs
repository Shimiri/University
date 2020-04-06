using System;
using System.Diagnostics.CodeAnalysis;

namespace Model
{
    public class Genre : IEquatable<Genre>
    {
        public string Name { get; set; }
        public int Id { get; set; }
        public int Titles { get; set; }

        public bool Equals([AllowNull] Genre other)
        {
            if (other is null)
                return false;
            return string.Equals(Name, other.Name, System.StringComparison.InvariantCultureIgnoreCase);
        }
        public override bool Equals(object obj)
        {
            return Equals(obj as Genre);
        }

        public override int GetHashCode()
        {
            return string.GetHashCode(Name, StringComparison.InvariantCultureIgnoreCase);
        }
    }
}
