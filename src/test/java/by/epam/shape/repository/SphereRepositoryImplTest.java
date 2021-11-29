package by.epam.shape.repository;


import by.epam.shape.comparator.*;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.Sphere;
import by.epam.shape.entity.SphereParameters;
import by.epam.shape.entity.SphereWarehouse;
import by.epam.shape.exception.SphereException;
import by.epam.shape.repository.impl.SphereIdSpecification;
import by.epam.shape.repository.impl.SphereRepositoryImpl;
import by.epam.shape.repository.impl.SphereSurfaceAreaSpecification;
import by.epam.shape.repository.impl.SphereVolumeSpecification;
import by.epam.shape.service.impl.SphereServiceImpl;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SphereRepositoryImplTest {
    SphereRepositoryImpl sphereRepository;
    List<Sphere> sphereList;
    SphereServiceImpl sphereService;
    SphereWarehouse sphereWarehouse;


    @BeforeEach
    void setUp() throws SphereException {
        sphereWarehouse = SphereWarehouse.getInstance();
        sphereRepository = SphereRepositoryImpl.getInstance();
        sphereService = new SphereServiceImpl();
        sphereList = List.of(new Sphere(5,new Point(0,0,0)),
                             new Sphere(7,new Point(2,-4,3)),
                             new Sphere(3,new Point(3,7,5)),
                             new Sphere(4,new Point(-9,10,10)),
                             new Sphere(8,new Point(4,2,-2)));
        sphereRepository.addAllSpheres(sphereList);
        for(Sphere sphere: sphereList){
            sphereWarehouse.put(sphere.getId(), new SphereParameters(sphereService.surfaceArea(sphere),sphereService.volume(sphere)));
        }
    }

    @Test
    void querySphereById(){
        int from=1;
        int to=3;
        List<Sphere> expected = List.of(
                new Sphere(7,new Point(2,-4,3)),
                new Sphere(3,new Point(3,7,5)),
                new Sphere(4,new Point(-9,10,10)));
        List<Sphere> actual = sphereRepository.querySphere(new SphereIdSpecification(from,to));
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    void querySphereBySurfaceArea(){
        int from=700;
        int to=1200;
        List<Sphere> expected = Collections.singletonList(new Sphere(8,new Point(3,7,5)));

        List<Sphere> actual = sphereRepository.querySphere(new SphereSurfaceAreaSpecification(from,to));
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    void querySphereByVolume(){
        int from=500;
        int to=1500;
        List<Sphere> expected = List.of(
                new Sphere(5,new Point(0,0,0)),
                new Sphere(7,new Point(2,-4,3)));
        List<Sphere> actual = sphereRepository.querySphere(new SphereVolumeSpecification(from,to));
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void sortPointX() {
        List<Sphere> expected = new ArrayList<>();
        expected.add(sphereRepository.getSphere(3));
        expected.add(sphereRepository.getSphere(0));
        expected.add(sphereRepository.getSphere(1));
        expected.add(sphereRepository.getSphere(2));
        expected.add(sphereRepository.getSphere(4));
        List<Sphere> actual = sphereRepository.sortSphere(new SphereCenterXComparator());
        assertThat(actual).containsExactlyElementsOf(expected);
    }
    @Test
    public void sortPointY() {
        List<Sphere> expected = new ArrayList<>();
        expected.add(sphereRepository.getSphere(1));
        expected.add(sphereRepository.getSphere(0));
        expected.add(sphereRepository.getSphere(4));
        expected.add(sphereRepository.getSphere(2));
        expected.add(sphereRepository.getSphere(3));
        List<Sphere> actual = sphereRepository.sortSphere(new SphereCenterYComparator());
        assertThat(actual).containsExactlyElementsOf(expected);
    }
    @Test
    public void sortPointZ() {
        List<Sphere> expected = new ArrayList<>();
        expected.add(sphereRepository.getSphere(4));
        expected.add(sphereRepository.getSphere(0));
        expected.add(sphereRepository.getSphere(1));
        expected.add(sphereRepository.getSphere(2));
        expected.add(sphereRepository.getSphere(3));
        List<Sphere> actual = sphereRepository.sortSphere(new SphereCenterZComparator());
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void sortRadius() {
        List<Sphere> expected = new ArrayList<>();
        expected.add(sphereRepository.getSphere(2));
        expected.add(sphereRepository.getSphere(3));
        expected.add(sphereRepository.getSphere(0));
        expected.add(sphereRepository.getSphere(1));
        expected.add(sphereRepository.getSphere(4));
        List<Sphere> actual = sphereRepository.sortSphere(new SphereRadiusComparator());
        assertThat(actual).containsExactlyElementsOf(expected);
    }
    @Test
    public void sortBySurfaceArea() {
        List<Sphere> expected = new ArrayList<>();
        expected.add(sphereRepository.getSphere(2));
        expected.add(sphereRepository.getSphere(3));
        expected.add(sphereRepository.getSphere(0));
        expected.add(sphereRepository.getSphere(1));
        expected.add(sphereRepository.getSphere(4));
        List<Sphere> actual = sphereRepository.sortSphere(new SphereSurfaceAreaComparator());
        assertThat(actual).containsExactlyElementsOf(expected);
    }
    @Test
    public void sortByVolume() {
        List<Sphere> expected = new ArrayList<>();
        expected.add(sphereRepository.getSphere(2));
        expected.add(sphereRepository.getSphere(3));
        expected.add(sphereRepository.getSphere(0));
        expected.add(sphereRepository.getSphere(1));
        expected.add(sphereRepository.getSphere(4));
        List<Sphere> actual = sphereRepository.sortSphere(new SphereVolumeComparator());
        assertThat(actual).containsExactlyElementsOf(expected);
    }

}