using Data;
using NUnit.Framework;
using System.Linq;
using System;
using System.Collections.Generic;
using System.Text;		


namespace Tests
{
    [TestFixture]
    public class SQLDataTests
    {
        [Test]
        public void ShouldReturnRowsSimilarToSearchQuery()
        {
            var db = new SQLData();
            var res = db.GetTitlesByColumn("Name", "Bad");
            Assert.That(res.Any());
        }
    }
}
