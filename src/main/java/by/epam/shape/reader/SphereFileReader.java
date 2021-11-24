package by.epam.shape.reader;

import by.epam.shape.exception.SphereException;
import by.epam.shape.validator.impl.SphereValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SphereFileReader {
    private static final Logger logger = LogManager.getLogger();
    private SphereValidationImpl sphereValidation = new SphereValidationImpl();

    public List<String> readValidSphereLines(String filepath) throws SphereException {
        if(!sphereValidation.isValidFile(filepath)){
            throw new SphereException("invalid filepath");
        }
        ArrayList<String> result;
        try {
            result = Files.lines(Paths.get(filepath))
                    .filter(sphereValidation::isValidFileLines)
                    .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("prochitano: "+result);
            logger.info("result of readLinesFromFile is {}", result);
        } catch (IOException e) {
            logger.error("IOException in read from file method with path {}:", e.getMessage());
            throw new SphereException("IOException in read from file method with path " + filepath);
        }
        return result;

    }

}
