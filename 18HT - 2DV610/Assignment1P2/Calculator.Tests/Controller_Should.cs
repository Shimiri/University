using System;
using Moq;
using Xunit;

namespace Calculator.Tests
{
    public class Controller_Should
    {
        private readonly Mock<View> _mockView;
        private readonly Mock<Calculator> _mockCalc;

        public Controller_Should()
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
            
            //Dependency injection
            var sut = new Controller(_mockCalc.Object, _mockView.Object);
            
            //Exercise
            sut.Run();
            
            //Verify
            _mockView.VerifyAll();
        }

        [Theory]
        [InlineData("1")]
        private void SelectOperation_ShouldSelectOperationBasedOnInput(string userInput)
        {
            //Mock setup
            _mockCalc.Setup(calc => calc.AddNums(1, 1));

            //Dependency injection
            var sut = new Controller(_mockCalc.Object, _mockView.Object);
            
            //Exercise
            sut.SelectOperation(userInput);
               
            //Verify
            if (userInput == "1")
            {
                _mockCalc.Verify(calc => calc.AddNums(1, 1));
            }
        }
    }
}