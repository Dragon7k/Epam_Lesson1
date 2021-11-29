package by.epam.shape.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SphereWarehouse {
    private static SphereWarehouse instance;
    private Map<Long, SphereParameters> parameters;

    private SphereWarehouse() {
        parameters = new HashMap<>();
    }

    public static SphereWarehouse getInstance() {
        if (instance == null) {
            instance = new SphereWarehouse();
        }
        return instance;
    }

    public Optional<SphereParameters> get(long id) {
        return Optional.ofNullable(parameters.get(id));
    }

    public Optional<SphereParameters> put(long id, SphereParameters parameter) {
        return Optional.ofNullable(parameters.put(id, parameter));
    }

    public Optional<SphereParameters> remove(long id) {
        return Optional.ofNullable(parameters.remove(id));
    }
}
