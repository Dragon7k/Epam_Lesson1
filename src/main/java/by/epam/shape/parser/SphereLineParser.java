package by.epam.shape.parser;

import by.epam.shape.exception.SphereException;
import java.util.List;

@FunctionalInterface
public interface SphereLineParser {
    List<Double> sphereLineParser(String lines) throws SphereException;
}
