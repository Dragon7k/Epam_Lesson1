package by.epam.shape.reader;

import by.epam.shape.exception.SphereException;
import java.util.List;

@FunctionalInterface
public interface SphereFileReader {
    List<String> readValidSphereLines(String filepath) throws SphereException;
}
