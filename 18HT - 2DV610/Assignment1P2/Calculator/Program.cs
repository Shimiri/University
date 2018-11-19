namespace Calculator
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Run(new View(new ConsoleWrapper()));
        }

        public static void Run(View view)
        {
            view.DisplayMenu();
            view.GetInput();
        }

        public static void SelectOperation(Calculator calc, string userInput)
        {
            if (userInput == "1")
            {
                calc.AddNums(1, 1);
            }
        }
    }
}
