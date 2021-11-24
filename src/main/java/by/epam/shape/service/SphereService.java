package by.epam.shape.service;

import by.epam.shape.entity.Sphere;

public interface SphereService {
    double surfaceArea(Sphere sphere);
    double volume(Sphere sphere);
    boolean isSphere(Sphere sphere);
    double volumeRatio(Sphere sphere, double axis);
}
