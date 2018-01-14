package sb223jy_lab4;

public class RandomWalk {
    private int numOfDrunksWhoFellInWater;
    private int xCor;
    private int yCor;
    private int max;
    private int size;
    private int numOfSteps;

    public RandomWalk(int max, int size) {
        this.max = max;
        this.size = size;
        xCor = 0;
        yCor = 0;
    }

    public void reset() {
        xCor = 0;
        yCor = 0;
        numOfSteps = 0;
    }

    public String toString() {
        return "Steps taken so far: " + numOfSteps + "\nCurrent position: (" + xCor + "," + yCor + ")" + " " + numOfDrunksWhoFellInWater;
    }

    public void takeStep() {
        if (moreSteps()) {
            int n = (int) (Math.random() * 4);
            switch (n) {
                case 0:
                    yCor++;
                    break;
                case 1:
                    yCor--;
                    break;
                case 2:
                    xCor++;
                    break;
                case 3:
                    xCor--;
                    break;
            }
            numOfSteps++;
        }
    }

    public boolean moreSteps() {
        return numOfSteps < max;
    }

    public boolean inBounds() {
        return xCor < size && xCor > (size * (-1)) && yCor < size && yCor > (size * (-1));
    }

    public void walk() {
        while (moreSteps() && inBounds()) {
            takeStep();
        }
        if (!inBounds())
            numOfDrunksWhoFellInWater++;
    }

    public int getNumOfDrunksWhoFellInWater() {
        return numOfDrunksWhoFellInWater;
    }
}
