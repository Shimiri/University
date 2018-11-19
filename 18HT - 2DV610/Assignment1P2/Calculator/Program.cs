namespace Calculator
{
    public static class Program
    {
        public static void Main(string[] args)
        {
            var c = new Controller(new Calculator(), new View(new ConsoleWrapper()));
            c.Run();
        }
    }
}
