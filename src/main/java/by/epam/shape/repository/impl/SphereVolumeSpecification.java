package by.epam.shape.repository.impl;

import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;
import by.epam.shape.repository.SphereSpecification;
import by.epam.shape.service.impl.SphereServiceImpl;

public class SphereVolumeSpecification implements SphereSpecification {
    private final int volumeLowerBound;
    private final int volumeUpperBound;
    private SphereServiceImpl service = new SphereServiceImpl();

    public SphereVolumeSpecification(int volumeLowerBound, int volumeUpperBound) {
        this.volumeLowerBound = volumeLowerBound;
        this.volumeUpperBound = volumeUpperBound;
    }

    @Override
    public boolean specify(Sphere sphere) {
        boolean specSphere = false;
        if(sphere==null){
            return false;
        }
        try {
            double volume = service.volume(sphere);
            specSphere = volume>=volumeLowerBound && volume<=volumeUpperBound;
        } catch (SphereException e) {
            e.printStackTrace();
        }
        return specSphere;
    }
}
