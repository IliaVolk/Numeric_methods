package Main.circles;

import java.io.Serializable;

public class Circle implements Serializable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double length() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Circle && ((Circle) obj).radius == radius;
    }
}
