package by.epam.shape.repository.impl;

import by.epam.shape.entity.Sphere;
import by.epam.shape.repository.SphereRepository;
import by.epam.shape.repository.SphereSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SphereRepositoryImpl implements SphereRepository {
    private static final Logger logger = LogManager.getLogger();
    private static SphereRepositoryImpl instance;
    private List<Sphere> sphereList;

    public static SphereRepositoryImpl getInstance() {
        if (instance == null) {
            logger.info("creating singleton sphere repository");
            instance = new SphereRepositoryImpl();
        }
        return instance;
    }

    private SphereRepositoryImpl() {
        sphereList = new ArrayList<>();
    }

    @Override
    public boolean add(Sphere sphere) {
       return sphereList.add(sphere);
    }

    @Override
    public List<Sphere> getAllSphere() {
        return List.copyOf(sphereList);
    }

    @Override
    public boolean addAll(List<Sphere> sourceList) {
        return sphereList.addAll(sourceList);
    }

    @Override
    public boolean remove(Sphere sphere) {
        return sphereList.remove(sphere);
    }

    @Override
    public boolean removeAll(List<Sphere> sourceList) {
        return sphereList.removeAll(sourceList);
    }

    @Override
    public Sphere get(int index) {
        return sphereList.get(index);
    }

    @Override
    public Sphere set(int index, Sphere sphere) {
        return sphereList.set(index,sphere);
    }

    @Override
    public List<Sphere> query(SphereSpecification sphereSpecification) {
        return sphereList.stream().filter(sphereSpecification::specify).collect(Collectors.toList());
    }

    @Override
    public List<Sphere> sort(Comparator<? super Sphere> comparator) {
        return sphereList.stream().sorted(comparator).collect(Collectors.toList());
    }
}
