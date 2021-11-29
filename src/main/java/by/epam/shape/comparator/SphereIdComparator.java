package by.epam.shape.comparator;

import by.epam.shape.entity.Sphere;

import java.util.Comparator;

public class SphereIdComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere o1, Sphere o2) {
        return Integer.compare(o1.getId(),o2.getId());
    }
}
