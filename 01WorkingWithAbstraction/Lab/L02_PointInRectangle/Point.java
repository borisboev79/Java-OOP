package OOP.WorkingWithAbstraction_Lab.L02_PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean greaterOrEqual(Point other) {
        return this.getX() >= other.getX() && this.getY() >= other.getY();
    }

    public boolean lessOrEqual(Point other) {
        return this.getX() <= other.getX() && this.getY() <= other.getY();
    }
}
