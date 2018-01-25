package sb223jy_assign1.exercise_2;

public class Bicycle implements Vehicle{
    private Passenger[] passengers;
    private int numOfPassengers;

    public Bicycle() {
        passengers = new Passenger[1];
        passengers[0] = new Passenger();
        numOfPassengers = 1;
    }

    public int getPrice() {
        return 40;
    }

    public int getPricePassenger() {
        return 0;
    }

    @Override
    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public double getSpace() {
        return 0.2;
    }
}
