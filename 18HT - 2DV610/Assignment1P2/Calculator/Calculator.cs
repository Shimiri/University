using System;

namespace Calculator
{
    public class Calculator
    {
        public Calculator()
        {
            
        }

        public virtual int AddNums(int x, int y) 
        {
            return x + y;
        }

        public virtual int SubtractNums(int x, int y)
        {
            return x - y;
        }
    }
}