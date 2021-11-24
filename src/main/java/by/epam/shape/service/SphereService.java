package by.epam.shape.service;

import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;

public interface SphereService {
    double surfaceArea(Sphere sphere) throws SphereException;
    double volume(Sphere sphere) throws SphereException;
    boolean isSphere(Sphere sphere) throws SphereException;
    double volumeRatio(Sphere sphere, double axis) throws SphereException;
}
