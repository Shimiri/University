package assignment2.exercise2;

import java.util.Arrays;

public class ExampleFillDirections {
    private A2Direction[] array;
	private A2Direction[] array2;
    private A2Itinerary<A2Direction> itinerary;

    public static void main(String[] args) {
		ExampleFillDirections example = new ExampleFillDirections();
		example.fill();
		example.createItinerary();
    }

    private void fill() {
		array = new A2Direction[10];
		array[0] = A2Direction.LEFT;
		array[1] = A2Direction.DOWN;
		array[2] = A2Direction.RIGHT;
		array[3] = A2Direction.DOWN;
		array[4] = A2Direction.LEFT;
		array[5] = A2Direction.UP;
		array[6] = A2Direction.LEFT;
		array[7] = A2Direction.UP;
		array[8] = A2Direction.RIGHT;
		array[9] = A2Direction.UP;

		array2 = new A2Direction[6];
		array2[0] = A2Direction.LEFT;
		array2[1] = A2Direction.DOWN;
		array2[2] = A2Direction.DOWN;
		array2[3] = A2Direction.RIGHT;
		array2[4] = A2Direction.UP;
		array2[5] = A2Direction.LEFT;
	}

    private void createItinerary() {
		itinerary = new MyItinerary(array);
		System.out.println("Intersections: " + Arrays.toString(itinerary.getIntersections()));
		System.out.println("Width: " + itinerary.widthOfItinerary());
		System.out.println("Height: " + itinerary.heightOfItinerary());

		itinerary = new MyItinerary(array2);
		System.out.println("Intersections: " + Arrays.toString(itinerary.getIntersections()));
		System.out.println("Width: " + itinerary.widthOfItinerary());
		System.out.println("Height: " + itinerary.heightOfItinerary());
	}
}
