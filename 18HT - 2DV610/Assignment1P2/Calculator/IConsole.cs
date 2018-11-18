using System;

namespace Calculator
{
    public interface IConsole
    {
        void WriteLine(String text);
        void Write(String text);
        String ReadLine();
    }
}