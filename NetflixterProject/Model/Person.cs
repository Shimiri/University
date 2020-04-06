using System;
using System.Diagnostics.CodeAnalysis;

namespace Model
{
    public class Person : IEquatable<Person>
    {
        public string Name { get; set; }
        public Role Role { get; set; }
        public int Id { get; set; }

        public bool Equals([AllowNull] Person other)
        {
            if (other is null)
                return false;
            return string.Equals(Name, other.Name, System.StringComparison.InvariantCultureIgnoreCase);
        }

        public override bool Equals(object obj)
        {
            return Equals(obj as Person);
        }

        public override int GetHashCode()
        {
            return string.GetHashCode(Name, StringComparison.InvariantCultureIgnoreCase);
        }
    }
}
