package sb223jy_assign1.exercise_2;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("FieldCanBeLocal")
public class ConcreteFerry implements Ferry {
    private int numOfPassengers;
    private int revenue;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;

    private final int MAX_PASSENGERS = 200;
    private final int MAX_CAPACITY = 40;

    public ConcreteFerry() {
        vehicles = new ArrayList<>();
        passengers = new ArrayList<>();

        revenue = 0;
        numOfPassengers = 0;
    }

    @Override
    public int countPassengers() {
        return numOfPassengers;
    }

    @Override
    public int countVehicleSpace() {
        double vehicleSpace = 0;
        for (Vehicle v : vehicles) {
            vehicleSpace += v.getSpace();
        }
        return (int) Math.ceil(vehicleSpace);
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public int countMoney() {
        int amountOfMoney = 0;
        int passInVech = 0;
        for (Vehicle v : vehicles) {
            amountOfMoney += v.getPrice();
            amountOfMoney += v.getPricePassenger();
            passInVech += v.getNumOfPassengers();
        }
        amountOfMoney += (numOfPassengers - passInVech) * 20;
        return amountOfMoney;
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return new Iterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return next() == null;
            }

            @Override
            public Vehicle next() {
                if (i < vehicles.size() && vehicles.get(i) != null)
                   return vehicles.get(i++);
                else
                    return null;
            }
        };
    }

    @Override
    public void embark(Vehicle v) {
        if (hasSpaceFor(v)) {
            vehicles.add(v);
            for (Passenger p : v.getPassengers()) {
                if (p != null)
                    embark(p);
            }
        }
    }

    @Override
    public void embark(Passenger p) {
        if (hasRoomFor(p)) {
            passengers.add(p);
            numOfPassengers++;
        }
    }

    @Override
    public void disembark() {
        revenue += countMoney();
        numOfPassengers = 0;
        passengers.clear();
        vehicles.clear();
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        return ((v.getSpace() + countVehicleSpace()) < MAX_CAPACITY && !vehicles.contains(v));
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        return numOfPassengers < MAX_PASSENGERS && !passengers.contains(p);
    }

    public String toString() {
        return "Ferry:\n Passengers: " + numOfPassengers + "\n Vehicle space: " + countVehicleSpace() +
                "\n Money: " + (countMoney() + revenue);
    }
}
