package by.epam.shape.service;

import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;
import by.epam.shape.factory.SphereFactory;
import by.epam.shape.service.impl.SphereServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SphereServiceImplTest {
    private static final SphereFactory sphereFactory = SphereFactory.getInstance();
    private static final SphereServiceImpl sphereServiceImpl = new SphereServiceImpl();

    @Test
    public void ifSphereReturnsTrue() throws SphereException {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.0);
        doubleList.add(10.0);
        doubleList.add(16.0);
        doubleList.add(16.0);
        Sphere sphere = sphereFactory.getSphere(doubleList);
        assertTrue(sphereServiceImpl.isSphere(sphere));
    }
    @Test
    public void ifSphereSurfaceAreaReturnsValidValue() throws SphereException {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.0);
        doubleList.add(10.0);
        doubleList.add(10.0);
        doubleList.add(10.0);
        Sphere sphere = sphereFactory.getSphere(doubleList);
        assertEquals(0,Double.compare(sphereServiceImpl.surfaceArea(sphere),1256.6370614359173));
    }
    @Test
    public void ifSphereVolumeReturnsValidValue() throws SphereException {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.0);
        doubleList.add(10.0);
        doubleList.add(10.0);
        doubleList.add(10.0);
        Sphere sphere = sphereFactory.getSphere(doubleList);
        assertEquals(0,Double.compare(sphereServiceImpl.volume(sphere),4188.790204786391));
    }
    @Test
    public void ifSphereVolumeRatioReturnsValidValue() throws SphereException {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.0);
        doubleList.add(10.0);
        doubleList.add(10.0);
        doubleList.add(10.0);
        Sphere sphere = sphereFactory.getSphere(doubleList);
        assertEquals(0,Double.compare(sphereServiceImpl.volumeRatio(sphere,4),0.2755102040816327));
    }
}
