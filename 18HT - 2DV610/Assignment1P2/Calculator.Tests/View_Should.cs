using Xunit;
using Moq;

namespace Calculator.Tests
{
    public class View_Should
    {
        private readonly Mock<IConsole> _mockConsole;

        public View_Should()
        {
            _mockConsole = new Mock<IConsole>();
        }

        [Fact]
        private void DisplayMenu_ShouldDisplayTheOperationsMenuOnConsole()
        {
            //Setup mock
            const string operationsMenu = "1. Add\n2. Subtract\n3. Multiply\n4.Divide";
            _mockConsole.Setup(c => c.WriteLine(operationsMenu));

            //Setup SUT and dependency injection
            var sut = new View(_mockConsole.Object);

            //Exercise
            sut.DisplayMenu();

            //Verification
            _mockConsole.VerifyAll();
        } 

        [Fact]
        private void GetInput_ShouldPromptUserForInput()
        {   
            //Setup mock
            const string promptText = "Select an operation to perform: ";
            _mockConsole.Setup(c => c.Write(promptText));
            _mockConsole.Setup(c => c.ReadLine());

            //Setup SUT and dependency injection
            var sut = new View(_mockConsole.Object);

            //Exercise
            sut.GetInput();

            //Verification 
            _mockConsole.VerifyAll();
        }
    }
}