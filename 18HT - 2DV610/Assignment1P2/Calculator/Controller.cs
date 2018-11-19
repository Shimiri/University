namespace Calculator
{
    public class Controller
    {
        private readonly Calculator _calc;
        private readonly View _view;

        public Controller(Calculator calc, View view)
        {
            _calc = calc;
            _view = view;
        }

        public void Run()
        {
            _view.DisplayMenu();
            _view.GetInput();
        }

        public void SelectOperation(string userInput)
        {
            if (userInput == "1")
            {
                _calc.AddNums(1, 1);
            }
        }
    }
}