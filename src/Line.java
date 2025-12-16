import java.util.Objects;

public class Line<T extends Point> {
    private T startPoint;
    private T endPoint;

    public Line() {
        this.startPoint = (T) new Point2D(0, 0);
        this.endPoint = (T) new Point2D(0, 0);
    }

    public Line(T startPoint, T endPoint) {
        setStartPoint(startPoint);
        setEndPoint(endPoint);
    }

    public Line(Line<T> line) {
        if (line == null) {
            throw new InvalidLineException("Линия не может быть null");
        }
        this.startPoint = line.startPoint;
        this.endPoint = line.endPoint;
    }

    // Generic методы с типовой переменной T
    public T getStartPoint() {
        return startPoint;
    }

    public T getEndPoint() {
        return endPoint;
    }

    public void setStartPoint(T startPoint) {
        if (startPoint == null) {
            throw new IllegalArgumentException("Начальная точка не может быть null");
        }
        this.startPoint = startPoint;
        validatePoints();
    }

    public void setEndPoint(T endPoint) {
        if (endPoint == null) {
            throw new IllegalArgumentException("Конечная точка не может быть null");
        }
        this.endPoint = endPoint;
        validatePoints();
    }

    private void validatePoints() {
        if (startPoint.equals(endPoint)) {
            throw new InvalidLineException("Начальная и конечная точки не могут совпадать");
        }
    }

    // Метод для сдвига начальной точки на 10 единиц по X
    public void shiftLineX() {
        T start = this.getStartPoint();
        T end = this.getEndPoint();
        start.setX(start.getX() + 10);
        end.setX(end.getX() + 10);
    }

    // Статический метод для сдвига начальной точки любой линии
    public static <U extends Point> void shiftLineStartX(Line<U> line) {
        if (line == null) {
            throw new IllegalArgumentException("Линия не может быть null");
        }
        U start = line.getStartPoint();
        U end = line.getEndPoint();
        start.setX(start.getX() + 10);
        end.setX(end.getX() + 10);
    }

    public double getDistance() {
        double deltaX = endPoint.getX() - startPoint.getX();
        double deltaY = endPoint.getY() - startPoint.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line<?> line = (Line<?>) o;
        return (startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint)) ||
                (startPoint.equals(line.endPoint) && endPoint.equals(line.startPoint));
    }

}

