package by.epam.shape.repository.impl;

import by.epam.shape.entity.Sphere;
import by.epam.shape.repository.SphereSpecification;

public class SphereIdSpecification implements SphereSpecification {

    private final int idLowerBound;
    private final int idUpperBound;

    public SphereIdSpecification(int idLowerBound, int idUpperBound) {
        this.idLowerBound = idLowerBound;
        this.idUpperBound = idUpperBound;
    }

    @Override
    public boolean specify(Sphere sphere) {
        if(sphere!=null){
            return sphere.getId()>=idLowerBound&&sphere.getId()<=idUpperBound;
        }else{
            return false;
        }
    }
}
