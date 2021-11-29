package by.epam.shape.repository.impl;

import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;
import by.epam.shape.repository.SphereSpecification;
import by.epam.shape.service.impl.SphereServiceImpl;

public class SphereSurfaceAreaSpecification implements SphereSpecification {

    private final int surfaceAreaLowerBound;
    private final int surfaceAreaUpperBound;
    private SphereServiceImpl service = new SphereServiceImpl();

    public SphereSurfaceAreaSpecification(int surfaceAreaLowerBound, int surfaceAreaUpperBound) {
        this.surfaceAreaLowerBound = surfaceAreaLowerBound;
        this.surfaceAreaUpperBound = surfaceAreaUpperBound;
    }

    @Override
    public boolean specify(Sphere sphere) {
        boolean specSphere = false;
        if(sphere==null){
            return false;
        }
        try {
            double surface = service.surfaceArea(sphere);
            specSphere = surface>=surfaceAreaLowerBound && surface<=surfaceAreaUpperBound;
        } catch (SphereException e) {
            e.printStackTrace();
        }
        return specSphere;
    }
}
