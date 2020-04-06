package assignment2.exercise2;

import assignment2.exercise1.HashTable;

public class MyItinerary implements A2Itinerary<A2Direction> {
    private A2Direction[] directions;
    private int[] intersections;
    private Point currentPosition;
    private HashTable<Point> visitedPoints;

    private int currentWidth;
    private int currentHeight;
    private int[] fullWidth = new int[] { 0, 0};
    private int[] fullHeight = new int[] { 0, 0};

    public MyItinerary(A2Direction[] array) {
        directions = array;
        intersections = new int[array.length];
        currentPosition = new Point(0, 0);
        visitedPoints = new HashTable<>();
    }

    private void processDirections() {
        int intersectionsIndex = 0;
        int directionCount = 0;
        for (A2Direction direction : directions) {
            visitedPoints.insert(currentPosition);
            currentPosition = createPoint(direction);

            if (pointVisited(currentPosition)) {
                intersections[intersectionsIndex++] = directionCount;
            }

            computeXYProperties(direction);
            directionCount++;
        }
    }

    private Point createPoint(A2Direction direction) {
        int value = getDirectionValue(direction);
        Point p;
        if (direction == A2Direction.RIGHT || direction == A2Direction.LEFT)
            p = new Point(currentPosition.x + value, currentPosition.y);
        else
            p = new Point(currentPosition.x, currentPosition.y + value);
        return p;
    }

    private boolean pointVisited(Point currentPosition) {
        return visitedPoints.contains(currentPosition);
    }

    private void computeXYProperties(A2Direction direction) {
        if (direction == A2Direction.LEFT || direction == A2Direction.RIGHT)
            computeWidth(direction);
        else
            computeHeight(direction);
    }

    private void computeWidth(A2Direction direction) {
        int value = getDirectionValue(direction);
        currentWidth += value;
        if (currentWidth < fullWidth[0]) {
            fullWidth[0] = currentWidth;
        } else if (currentWidth > fullWidth[1]) {
            fullWidth[1] = currentWidth;
        }
    }

    private void computeHeight(A2Direction direction) {
        int value = getDirectionValue(direction);
        currentHeight += value;
        if (currentHeight < fullHeight[0]) {
            fullHeight[0] = currentHeight;
        } else if (currentHeight > fullHeight[1]) {
            fullHeight[1] = currentHeight;
        }
    }

    @Override
    public A2Direction[] rotateRight() {
        return new A2Direction[0];
    }

    @Override
    public int widthOfItinerary() {
        int width = fullWidth[0] - fullWidth[1];
        return Math.abs(width);
    }

    @Override
    public int heightOfItinerary() {
        int height = fullHeight[0] - fullHeight[1];
        return Math.abs(height);
    }

    @SuppressWarnings("ManualArrayCopy")
    @Override
    public int[] getIntersections() {
        processDirections();

        int numberOfIntersections = 0;
        while (intersections[numberOfIntersections] != 0)
            numberOfIntersections++;

        int[] intersections = new int[numberOfIntersections];
        for (int i = 0; i < numberOfIntersections; i++)
            intersections[i] = this.intersections[i];
        return intersections;
    }

    private int getDirectionValue(A2Direction direction) {
        if (direction == A2Direction.UP || direction == A2Direction.RIGHT)
            return 1;
        else
            return -1;
    }

    class Point {
        int x;
        int y;

        @Override
        public int hashCode() {
            return Integer.hashCode(x) + Integer.hashCode(y);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point) o;
                return p.x == x && p.y == y;
            }
            return false;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
