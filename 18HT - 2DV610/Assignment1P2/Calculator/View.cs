using System;

namespace Calculator
{
    public class View
    {
        public IConsole Writer { get; set; }

        private const String operationsMenu = "1. Add\n2. Subtract\n3. Multiply\n4.Divide";

        public View()
        {
            
        }

        public void DisplayMenu()
        {   
            Writer.WriteLine(operationsMenu);
        }
    }
}