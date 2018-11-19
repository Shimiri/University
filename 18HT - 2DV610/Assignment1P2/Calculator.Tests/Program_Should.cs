using Moq;
using Xunit;

namespace Calculator.Tests
{
    public class Program_Should
    {
        private readonly Mock<View> _mockView;

        public Program_Should()
        {
            _mockView = new Mock<View>(new ConsoleWrapper());
        }

        [Fact]
        private void Main_ShouldDisplayMenuAndPromptUserForInput()
        {
            //Setup mock
            _mockView.Setup(view => view.DisplayMenu());
            _mockView.Setup(view => view.GetInput());
            
            //Exercise and dependency injection
            Program.Run(_mockView.Object);
            
            //Verify
            _mockView.VerifyAll();
        }
    }
}