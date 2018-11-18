using System;

namespace Calculator
{
    public class View
    {
        private IConsole Console { get; }

        private const String operationsMenu = "1. Add\n2. Subtract\n3. Multiply\n4.Divide";

        public View(IConsole c)
        {
            Console = c;
        }

        public void DisplayMenu()
        {   
            Console.WriteLine(operationsMenu);
        }
    }
}