package by.epam.shape.entity;

import by.epam.shape.observer.Observable;
import by.epam.shape.observer.Observer;
import by.epam.shape.observer.SphereEvent;
import by.epam.shape.observer.SphereObserver;
import by.epam.shape.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Sphere implements Observable {

    private int id;
    private double radius;
    private Point center;
    private Observer observer = new SphereObserver();
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
        notifyObserver();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObserver();
    }

    public int getId() {
        return id;
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

    @Override
    public void attach(Observer observer) {
        if(observer!=null){
            this.observer=observer;
        }
    }

    @Override
    public void detach() {
        this.observer=null;
    }

    @Override
    public void notifyObserver() {
        if(observer!=null){
            SphereEvent sphereEvent = new SphereEvent(this);
            this.observer.parametersChange(sphereEvent);
        }
    }
}
