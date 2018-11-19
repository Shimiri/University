using System;
using System.Diagnostics.CodeAnalysis;

namespace Calculator
{
    public class ConsoleWrapper : IConsole
    {
        public virtual string ReadLine()
        {
            return Console.ReadLine();
        }

        public virtual void Write(string text)
        {
            Console.Write(text);
        }

        public virtual void WriteLine(string text)
        {
            Console.WriteLine(text);
        }
    }
}