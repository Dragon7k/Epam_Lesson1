package by.epam.shape.observer;

@FunctionalInterface
public interface Observer {
    void parametersChange(SphereEvent event);
}
