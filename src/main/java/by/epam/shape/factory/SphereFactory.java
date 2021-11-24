package by.epam.shape.factory;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SphereFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final SphereFactory instance = new SphereFactory();
    private static final int COUNT_OF_NUMBERS = 4;

    private SphereFactory() {

    }

    public Sphere getSphere(List<Double> listNumber) throws SphereException {
        if (listNumber.size() != COUNT_OF_NUMBERS) {
            throw new SphereException("Invalid count of numbers: " + listNumber);
        }
        Point point = new Point(listNumber.get(0),listNumber.get(1),listNumber.get(2));
        Sphere sphere = new Sphere(listNumber.get(3),point);
        logger.log(Level.INFO, "Sphere was created successfully");
        return sphere;
    }

    public static SphereFactory getInstance() {
        return instance;
    }

}
