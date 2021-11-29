package by.epam.shape.observer;

import by.epam.shape.entity.Sphere;
import by.epam.shape.entity.SphereParameters;
import by.epam.shape.entity.SphereWarehouse;
import by.epam.shape.exception.SphereException;
import by.epam.shape.factory.SphereFactory;
import by.epam.shape.service.impl.SphereServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SphereObserverTest {
    private final SphereWarehouse warehouse = SphereWarehouse.getInstance();
    private final SphereObserver observer = new SphereObserver();
    private final SphereFactory factory = SphereFactory.getInstance();
    private final SphereServiceImpl service = new SphereServiceImpl();
    private Sphere sphere;

    @BeforeEach
    public void setUp() throws SphereException {
        List<Double> numbers = List.of(1.0,1.0,1.0,10.0);
        sphere = factory.getSphere(numbers);
        sphere.attach(observer);
        double surfaceArea = service.surfaceArea(sphere);
        double volume = service.volume(sphere);
        SphereParameters parameters = new SphereParameters(surfaceArea,volume);
        warehouse.put(sphere.getId(), parameters);
    }

    @Test
    public void parametersChangeTest() throws SphereException {
        sphere.setRadius(13);
        double surfaceArea = service.surfaceArea(sphere);
        double volume = service.volume(sphere);
        warehouse.put(sphere.getId(),new SphereParameters(surfaceArea,volume));
        assertEquals(2123.7166338267 ,warehouse.get(sphere.getId()).get().getSurfaceArea());
    }
}
