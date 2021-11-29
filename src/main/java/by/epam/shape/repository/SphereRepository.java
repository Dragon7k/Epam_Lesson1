package by.epam.shape.repository;

import by.epam.shape.entity.Sphere;

import java.util.Comparator;
import java.util.List;

public interface SphereRepository {
    boolean add(Sphere sphere);

    List<Sphere> getAllSphere();

    boolean addAll(List<Sphere> sphereList);

    boolean remove(Sphere sphere);

    boolean removeAll(List<Sphere> sphereList);

    Sphere get(int index);

    Sphere set(int index, Sphere ball);

    List<Sphere> query(SphereSpecification sphereSpecification);

    List<Sphere> sort(Comparator<? super Sphere> comparator);
}
