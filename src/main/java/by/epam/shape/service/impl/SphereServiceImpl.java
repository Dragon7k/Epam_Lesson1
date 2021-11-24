package by.epam.shape.service.impl;

import by.epam.shape.entity.Sphere;
import by.epam.shape.service.SphereService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereServiceImpl implements SphereService {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public double surfaceArea(Sphere sphere) {

        return 4*Math.PI*Math.pow(sphere.getRadius(),2);
    }

    @Override
    public double volume(Sphere sphere) {
        return 4*Math.PI*Math.pow(sphere.getRadius(),3)/3;
    }

    @Override
    public boolean isSphere(Sphere sphere) {
        return (sphere != null ? sphere.getRadius() : 0) > 0;
    }

    @Override
    public double volumeRatio(Sphere sphere, double axis) {
        double sphereSegmentVolume1 = Math.PI*Math.pow((sphere.getRadius()-Math.abs(axis)),2)*(sphere.getRadius()-(sphere.getRadius()-Math.abs(axis))/3);

        return sphereSegmentVolume1/(volume(sphere));
    }
}
