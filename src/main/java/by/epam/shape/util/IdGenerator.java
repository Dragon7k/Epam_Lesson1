package by.epam.shape.util;

public class IdGenerator {
    private static int counter;

    public static int generateId(){
       return counter++;
    }
}
