package by.epam.shape.factory;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;
import by.epam.shape.factory.SphereFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereFactoryTest {
    @Test
    public void ifPointsCoordinatesAndRadiusAreCorrectReturnsSphere() throws SphereException {
        List<Double> numbers = new ArrayList<>();
        numbers.add(10.0);
        numbers.add(10.0);
        numbers.add(14.0);
        numbers.add(16.0);
        Sphere sphere = SphereFactory.getInstance().getSphere(numbers);
        assertEquals(sphere,new Sphere(16.0, new Point(10.0,10.0,14.0)));

    }

}
