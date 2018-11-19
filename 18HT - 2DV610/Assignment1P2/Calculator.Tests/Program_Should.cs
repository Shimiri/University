using System;
using Moq;
using Xunit;

namespace Calculator.Tests
{
    public class Program_Should
    {
        private readonly Mock<View> _mockView;
        private readonly Mock<Calculator> _mockCalc;

        public Program_Should()
        {
            _mockView = new Mock<View>(new ConsoleWrapper());
            _mockCalc = new Mock<Calculator>();
        }

        [Fact]
        private void Run_ShouldDisplayMenuAndPromptUserForInput()
        {
            //Setup mock
            _mockView.Setup(view => view.DisplayMenu());
            _mockView.Setup(view => view.GetInput());
            
            //Exercise and dependency injection
            Program.Run(_mockView.Object);
            
            //Verify
            _mockView.VerifyAll();
        }

        [Theory]
        [InlineData("1")]
        private void SelectOperation_ShouldSelectOperationBasedOnInput(string userInput)
        {
            //Mock setup
            _mockCalc.Setup(calc => calc.AddNums(1, 1));

            //Exercise and dependency injection
            Program.SelectOperation(_mockCalc.Object, userInput);
               
            //Verify
            if (userInput == "1")
            {
                _mockCalc.Verify(calc => calc.AddNums(1, 1));
            }
        }
    }
}