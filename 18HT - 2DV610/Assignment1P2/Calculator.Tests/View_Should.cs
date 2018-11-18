using System;
using Xunit;
using Moq;
using Calculator;

namespace Calculator.Tests
{
    public class View_Should
    {
        private readonly Mock<View> _mockView;
        private readonly Mock<Calculator> _mockCalc;
        private readonly Mock<IConsole> _mockConsole;

        public View_Should()
        {
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

            //Setup SUT and dependency injection
            View sut = new View(_mockConsole.Object);

            //Exercise
            sut.DisplayMenu();

            //Verification
            _mockConsole.VerifyAll();
        } 

        [Fact]
        private void GetInput_ShouldPromptUserForInput()
        {   
            //Setup mock
            String promptText = "Select an operation to perform: ";
            _mockConsole.Setup(c => c.Write(promptText));
            _mockConsole.Setup(c => c.ReadLine()).Returns("1");

            //Setup SUT and dependency injection
            View sut = new View(_mockConsole.Object);

            //Exercise
            sut.GetInput();

            //Verification 
            _mockConsole.VerifyAll();
        }
    }
}