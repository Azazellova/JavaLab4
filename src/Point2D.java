import java.util.Objects;

public class Point2D extends Point {

    public Point2D(double x, double y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Point2D{" + x + ", " + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point2D)) {
            return false;
        }
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.x, x) == 0 &&
                Double.compare(point2D.y, y) == 0;
    }
}