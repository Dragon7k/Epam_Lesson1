package by.epam.shape.comparator;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Sphere;

import java.util.Comparator;

public class SphereCenterZComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere o1, Sphere o2) {
        return Double.compare(o1.getCenter().getZ(), o2.getCenter().getZ());
    }
}
