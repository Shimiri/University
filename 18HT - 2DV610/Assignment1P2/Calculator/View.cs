using System;

namespace Calculator
{
    public class View
    {
        private IConsole Console { get; }

        private const String _operationsMenu = "1. Add\n2. Subtract\n3. Multiply\n4.Divide";
        private const String _promptText = "Select an operation to perform: ";

        public View(IConsole c)
        {
            Console = c;
        }

        public void DisplayMenu()
        {   
            Console.WriteLine(_operationsMenu);
        }

        public String GetInput()
        {
            Console.Write(_promptText);
            return Console.ReadLine();
        }
    }
}