
public class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" + x + ", " + y + ", " + z + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point3D)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Point3D point3D = (Point3D) o;
        return Double.compare(point3D.z, z) == 0;
    }

}