package sb223jy_assign1.exercise_2;

public class Car implements Vehicle {
    private int numOfPassengers;
    private Passenger[] passengers;

    private final int MAX_PASSENGERS = 4;

    public Car() {
        passengers = new Passenger[MAX_PASSENGERS];
        numOfPassengers = 0;
    }

    public Car(int n) {
        passengers = new Passenger[MAX_PASSENGERS];
        numOfPassengers = 0;
        for (int i = 0; i < n; i++)
            addPassengers();
    }

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public int getPricePassenger() {
        return numOfPassengers * 15;
    }

    @Override
    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    @Override
    public Passenger[] getPassengers() {
        return passengers;
    }

    @Override
    public double getSpace() {
        return 1;
    }

    public void addPassengers() {
        if (hasRoom()) {
            passengers[numOfPassengers++] = new Passenger();
        } else
            System.out.println("Car full.");
    }

    private boolean hasRoom() {
        return numOfPassengers < MAX_PASSENGERS;
    }
}
