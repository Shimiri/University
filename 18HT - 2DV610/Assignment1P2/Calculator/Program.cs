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
    }
}
