package by.epam.shape.service.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;
import by.epam.shape.service.SphereService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereServiceImpl implements SphereService {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public double surfaceArea(Sphere sphere) throws SphereException {
        if(sphere==null){
            throw new SphereException("Sphere is null");
        }
        return 4*Math.PI*Math.pow(sphere.getRadius(),2);
    }

    @Override
    public double volume(Sphere sphere) throws SphereException {
        if(sphere==null){
            throw new SphereException("Sphere is null");
        }
        return 4*Math.PI*Math.pow(sphere.getRadius(),3)/3;
    }

    @Override
    public boolean isSphere(Sphere sphere) {
        return (sphere != null ? sphere.getRadius() : 0) > 0;
    }

    @Override
    public double volumeRatio(Sphere sphere, double coordinate) throws SphereException {
        if(sphere==null){
            throw new SphereException("Sphere is null");
        }
        Point center = sphere.getCenter();
        double radius = sphere.getRadius();
        if(coordinate<center.getX()+radius&&coordinate>center.getX()-radius
                ||coordinate<center.getY()+radius&&coordinate>center.getY()-radius
                ||coordinate<center.getZ()+radius&&coordinate>center.getZ()-radius){
            logger.log(Level.INFO,"the coordinate plane cuts the ball ");
            double sphereSegmentVolume1 = Math.PI*Math.pow((sphere.getRadius()-Math.abs(coordinate)),2)
                    *(sphere.getRadius()-(sphere.getRadius()-Math.abs(coordinate))/3);
            return sphereSegmentVolume1/(volume(sphere)-sphereSegmentVolume1);
        }else {
            throw new SphereException("the coordinate plane doesn't cuts the ball ");
        }

    }
}
