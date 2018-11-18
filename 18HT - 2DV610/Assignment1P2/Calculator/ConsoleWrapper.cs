using System;

namespace Calculator
{
    public class ConsoleWrapper : IConsole
    {
        public string ReadLine()
        {
            throw new NotImplementedException();
        }

        public void Write(string text)
        {
            throw new NotImplementedException();
        }

        public void WriteLine(string text)
        {
            Console.WriteLine(text);
        }
    }
}