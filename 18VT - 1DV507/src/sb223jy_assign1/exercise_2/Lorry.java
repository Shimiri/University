package sb223jy_assign1.exercise_2;

public class Lorry implements Vehicle {
    private int numOfPassengers;
    private Passenger[] passengers;

    public final int MAX_PASSENGERS = 2;

    public Lorry() {
        passengers = new Passenger[MAX_PASSENGERS];
        numOfPassengers = 0;
    }

    public Lorry(int n ) {
        passengers = new Passenger[MAX_PASSENGERS];
        numOfPassengers = 0;
        for (int i = 0; i < n; i++)
            addPassengers();
    }

    @Override
    public int getPrice() {
        return 300;
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
        return 8;
    }

    public void addPassengers() {
        if (hasRoom()) {
            passengers[numOfPassengers++] = new Passenger();
        } else
            System.out.println("Lorry full.");
    }

    private boolean hasRoom() {
        return numOfPassengers < MAX_PASSENGERS;
    }
}
