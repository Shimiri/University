using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;

namespace Model
{
    public class Title
    {
        public int Id { get; set; }
        public int ReleaseYear { get; set; }
        public float Rating { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string DateAdded { get; set; }
        public string AgeRating { get; set; }
        public string Type { get; set; }
        public string Duration { get; set; }
        public List<Genre> Genres { get; }

        public Title()
        {
            Genres = new List<Genre>();
        }

        public bool Equals([AllowNull] Title other)
        {
            if (other is null)
                return false;
            return Equals(Id, other.Id);
        }

        public override bool Equals(object obj)
        {
            return Equals(obj as Title);
        }

        public override int GetHashCode()
        {
            return Id.GetHashCode();
        }
    }
}
