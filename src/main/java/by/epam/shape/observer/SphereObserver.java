package by.epam.shape.observer;

import by.epam.shape.entity.Sphere;
import by.epam.shape.entity.SphereParameters;
import by.epam.shape.entity.SphereWarehouse;
import by.epam.shape.exception.SphereException;
import by.epam.shape.service.impl.SphereServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereObserver implements Observer{
    private static final Logger logger = LogManager.getLogger();
    private SphereServiceImpl service = new SphereServiceImpl();
    private double surfaceArea;
    private double volume;

    @Override
    public void parametersChange(SphereEvent event) {
        SphereWarehouse sphereWarehouse = SphereWarehouse.getInstance();
        Sphere sphere = event.getSource();

        try {
            surfaceArea = service.surfaceArea(sphere);
            volume = service.volume(sphere);
        } catch (SphereException e) {
            logger.error(e.getMessage());
        }

        SphereParameters sphereParameters = new SphereParameters(surfaceArea,volume);
        sphereWarehouse.put(sphere.getId(),sphereParameters);
        logger.info("Parameters were changed");
    }
}
