package sb223jy_lab3;

public class Point {
    private int xPos;
    private int yPos;

    public Point() {
        xPos = 0;
        yPos = 0;
    }

    public Point(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public String toString() {
        return "(" + xPos + "," + yPos + ")";
    }

    public boolean isEqualTo(Point p) {
        return xPos == p.getX() && yPos == p.getY();
    }

    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(p.xPos - xPos, 2) + Math.pow(p.yPos - yPos, 2));
    }

    public void move(int x, int y) {
        xPos += x;
        yPos += y;
    }

    public void moveToXY(int x, int y) {
        xPos = x;
        yPos = y;
    }
}
