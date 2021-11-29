package by.epam.shape.parser.impl;

import by.epam.shape.exception.SphereException;
import by.epam.shape.parser.SphereLineParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SphereLineParserImpl implements SphereLineParser {

    private static final Logger logger = LogManager.getLogger();
    private static final String REGEXP_DELIMITER_FOR_LINES = "\\s+";

    @Override
    public List<Double> sphereLineParser(String lines) throws SphereException {
        if(lines==null||lines.isEmpty()){
            throw new SphereException("Line is empty or null");
        }else{
            List<Double> centerAndRadius;
            try {
                centerAndRadius = Arrays.stream(lines.split(REGEXP_DELIMITER_FOR_LINES))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                throw new SphereException("Invalid line", e);
            }
            logger.log(Level.INFO, "Lines parsed successfully");
            return centerAndRadius;
        }
    }
}
