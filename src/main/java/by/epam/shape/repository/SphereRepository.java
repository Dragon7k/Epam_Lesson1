package by.epam.shape.repository;

import by.epam.shape.entity.Sphere;

import java.util.Comparator;
import java.util.List;

public interface SphereRepository {
    boolean addSphere(Sphere sphere);

    List<Sphere> getAllSphere();

    boolean addAllSpheres(List<Sphere> sphereList);

    boolean removeSphere(Sphere sphere);

    boolean removeAllSpheres(List<Sphere> sphereList);

    Sphere getSphere(int index);

    Sphere setSphere(int index, Sphere ball);

    List<Sphere> querySphere(SphereSpecification sphereSpecification);

    List<Sphere> sortSphere(Comparator<? super Sphere> comparator);
}
