package Main.circles;

import java.io.Serializable;

public class Cylinder implements Serializable {
    private Circle base;

    private double height;
    public Cylinder(double baseRadius, double height) {
        this.base = new Circle(baseRadius);
        this.height = height;
    }
    public double surfaceArea(){
        return 2 * base.area() + lateralArea();
    }

    private double lateralArea() {
        return base.length() * height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cylinder){
            Cylinder other = (Cylinder)obj;
            return other.height == height && other.base.equals(base);
        }
        return false;
    }
}
