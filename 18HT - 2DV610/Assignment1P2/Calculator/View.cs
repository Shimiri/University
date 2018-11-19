using System;

namespace Calculator
{
    public class View
    {
        private IConsole Console { get; }

        private const string _operationsMenu = "1. Add\n2. Subtract\n3. Multiply\n4.Divide";
        private const string _promptText = "Select an operation to perform: ";

        public View(IConsole c)
        {
            Console = c;
        }

        public virtual void DisplayMenu()
        {   
            Console.WriteLine(_operationsMenu);
        }

        public virtual string GetInput()
        {
            Console.Write(_promptText);
            return Console.ReadLine();
        }
    }
}