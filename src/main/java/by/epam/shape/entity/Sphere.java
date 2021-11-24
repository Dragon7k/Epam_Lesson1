package by.epam.shape.entity;

import by.epam.shape.util.IdGenerator;

import java.util.Objects;

public class Sphere {
    private int id;
    private double radius;
    private Point center;

    public Sphere(double radius, Point center) {
        this.id= IdGenerator.generateId();
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        int result = center == null ? 0 : center.hashCode();
        result = 31 * result + (int) radius;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sphere{");
        sb.append("id=").append(id);
        sb.append(", radius=").append(radius);
        sb.append(", center=").append(center);
        sb.append('}');
        return sb.toString();
    }

}
