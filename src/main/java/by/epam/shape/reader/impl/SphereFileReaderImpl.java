package by.epam.shape.reader.impl;

import by.epam.shape.exception.SphereException;
import by.epam.shape.reader.SphereFileReader;
import by.epam.shape.validator.impl.SphereValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SphereFileReaderImpl implements SphereFileReader {
    private static final Logger logger = LogManager.getLogger();
    private final SphereValidationImpl sphereValidation = new SphereValidationImpl();

    @Override
    public List<String> readValidSphereLines(String filepath) throws SphereException {
        List<String> result = null;
        try {
            result = Files.lines(Paths.get(getClass().getClassLoader().getResource(filepath).toURI()))
                    .filter(sphereValidation::isValidFileLines)
                    .collect(Collectors.toList());
            logger.info("result of readLinesFromFile is {}", result);
        } catch (IOException e) {
            logger.error("IOException in read from file method with path {}:", e.getMessage());
            throw new SphereException("IOException in read from file method with path " + filepath);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

}
