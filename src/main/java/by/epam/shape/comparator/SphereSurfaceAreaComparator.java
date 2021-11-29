package by.epam.shape.comparator;

import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;
import by.epam.shape.service.impl.SphereServiceImpl;

import java.util.Comparator;

public class SphereSurfaceAreaComparator implements Comparator<Sphere> {
    private SphereServiceImpl service = new SphereServiceImpl();
    private double surfaceArea1;
    private double surfaceArea2;
    @Override
    public int compare(Sphere o1, Sphere o2) {
        try {
            surfaceArea1 = service.surfaceArea(o1);
            surfaceArea2 = service.surfaceArea(o2);
        } catch (SphereException e) {
            e.printStackTrace();
        }
        return Double.compare(surfaceArea1,surfaceArea2);
    }
}
