package sb223jy_assign1.exercise_2;

public class Bus implements Vehicle {
    private int numOfPassengers;
    private Passenger[] passengers;

    public final int MAX_PASSENGERS = 20;

    public Bus() {
        passengers = new Passenger[MAX_PASSENGERS];
        numOfPassengers = 0;
    }

    public Bus(int n) {
        passengers = new Passenger[MAX_PASSENGERS];
        numOfPassengers = 0;
        for (int i = 0; i < n; i++)
            addPassengers();
    }

    @Override
    public int getPrice() {
        return 200;
    }

    @Override
    public int getPricePassenger() {
        return numOfPassengers * 10;
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
        return 4;
    }

    public void addPassengers() {
        if (hasRoom()) {
            passengers[numOfPassengers++] = new Passenger();
        } else
            System.out.println("Bus full.");
    }

    private boolean hasRoom() {
        return numOfPassengers < 20;
    }
}
