package by.epam.shape.validator.impl;

import by.epam.shape.validator.SphereValidator;

import java.io.File;

public class SphereValidationImpl implements SphereValidator {
    private static final String REGEXP_FOR_LINE_VALIDATION = "([-]?\\d+\\.\\d+\\s+){3}([-]?\\d+\\.\\d+)";
    public SphereValidationImpl() {
    }

    @Override
    public boolean isValidFile(String filepath) {
        if(filepath==null){
            return false;
        }
        File file = new File(filepath);
        return file.exists();
    }

    @Override
    public boolean isValidFileLines(String fileLine) {
        return fileLine.matches(REGEXP_FOR_LINE_VALIDATION);
    }
}
