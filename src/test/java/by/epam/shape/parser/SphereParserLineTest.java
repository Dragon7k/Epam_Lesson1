package by.epam.shape.parser;

import by.epam.shape.exception.SphereException;
import by.epam.shape.parser.impl.SphereLineParserImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereParserLineTest {
    private static final SphereLineParserImpl SPHERE_LINE_PARSER = new SphereLineParserImpl();
    private static final String LINE = "10.0 12.0 12.0 14.0";
    private static final List<Double> DOUBLE_LIST = new ArrayList<>();

    @Test
    public void ifParseSphereLinesReturnsValidValues() throws SphereException {
        DOUBLE_LIST.add(10.0);
        DOUBLE_LIST.add(12.0);
        DOUBLE_LIST.add(12.0);
        DOUBLE_LIST.add(14.0);
        List<Double> doubleList = SPHERE_LINE_PARSER.sphereLineParser(LINE);
        assertEquals(doubleList, DOUBLE_LIST);
    }
}
