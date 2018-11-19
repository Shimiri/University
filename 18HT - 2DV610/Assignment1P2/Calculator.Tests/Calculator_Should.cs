using System;
using Xunit;
using Calculator;

namespace Calculator.Tests
{
    public class Calculator_Should
    {
        private readonly Calculator _sut;

        public Calculator_Should()
        {
            _sut = new Calculator();
        }

        [Theory]
        [InlineData(1, 3, 4)]
        [InlineData(-1, 1, 0)]
        [InlineData(10, 3, 13)]
        [InlineData(-10, -5, -15)]
        public void Add_ShouldAddTwoNumbers(int x, int y, int expected)
        {
            int actual = _sut.AddNums(x, y);
                
            Assert.Equal(actual, expected); 
        }
    }
}