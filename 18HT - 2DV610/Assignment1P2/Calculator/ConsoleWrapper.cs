using System;

namespace Calculator
{
    public class ConsoleWrapper : IConsole
    {
        public void WriteLine(string text)
        {
            Console.WriteLine(text);
        }
    }
}