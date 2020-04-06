using System;
using System.Collections.Generic;
using System.Text;
using MySql.Data.MySqlClient;

namespace Scripts
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var uploader = new DataUploader();
            uploader.ConnectToDatabase();

            var csvImporter = new NetflixCSVImporter();
            var data = csvImporter.ParseTitlePeopleMapping();

            uploader.PopulatePeopleTitleMapping(data);
        }
    }
}
