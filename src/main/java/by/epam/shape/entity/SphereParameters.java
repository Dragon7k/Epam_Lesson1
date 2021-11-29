package by.epam.shape.entity;

import java.util.Objects;

public class SphereParameters {
    private double surfaceArea;
    private double volume;

    public SphereParameters(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphereParameters that = (SphereParameters) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (31 * surfaceArea * volume);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SphereParameters{");
        sb.append("surfaceArea=").append(surfaceArea);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
