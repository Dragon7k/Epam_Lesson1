package by.epam.shape.reader;

import by.epam.shape.exception.SphereException;
import by.epam.shape.reader.impl.SphereFileReaderImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereFileReaderTest {
    private static final String FILE_PATH = "file/sphere1.txt";

    @Test
    public void ifEllipseFileReaderReturnsValidResult() throws SphereException {
        SphereFileReaderImpl sphereFileReader = new SphereFileReaderImpl();
        List<String> fileLines = sphereFileReader.readValidSphereLines(FILE_PATH);
        List<String> expectedFileLines = new ArrayList<>();
        expectedFileLines.add("12.0 12.0 14.0 14.0");
        expectedFileLines.add("10.0 12.0 16.0 16.0");
        assertEquals(fileLines, expectedFileLines);
    }
}
