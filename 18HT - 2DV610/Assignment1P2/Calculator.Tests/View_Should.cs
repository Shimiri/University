using System;
using Xunit;
using Moq;
using Calculator;

namespace Calculator.Tests
{
    public class View_Should
    {
        private readonly View _sut;
        private readonly Mock<View> _mockView;
        private readonly Mock<Calculator> _mockCalc;
        private readonly Mock<IConsole> _mockConsole;

        public View_Should()
        {
            _sut = new View();
            _mockView = new Mock<View>();
            _mockCalc = new Mock<Calculator>();
            _mockConsole = new Mock<IConsole>();
        }

        [Fact]
        private void DisplayMenu_ShouldDisplayTheOperationsMenuOnConsole()
        {
            //Setup mock
            String operationsMenu = "1. Add\n2. Subtract\n3. Multiply\n4.Divide";
            _mockConsole.Setup(c => c.WriteLine(operationsMenu));

            //Dependency injection
            _sut.Writer = _mockConsole.Object;

            //Exercise
            _sut.DisplayMenu();

            //Verification
            _mockConsole.VerifyAll();
        } 
    }
}