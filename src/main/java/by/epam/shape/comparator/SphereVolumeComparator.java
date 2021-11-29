package by.epam.shape.comparator;

import by.epam.shape.entity.Sphere;
import by.epam.shape.exception.SphereException;
import by.epam.shape.service.impl.SphereServiceImpl;

import java.util.Comparator;

public class SphereVolumeComparator implements Comparator<Sphere> {
    private SphereServiceImpl service = new SphereServiceImpl();
    private double volume1;
    private double volume2;
    @Override
    public int compare(Sphere o1, Sphere o2) {
        try {
            volume1 = service.volume(o1);
            volume2 = service.volume(o2);
        } catch (SphereException e) {
            e.printStackTrace();
        }
        return Double.compare(volume1,volume2);
    }
}
