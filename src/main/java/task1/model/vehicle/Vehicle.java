package task1.model.vehicle;

import java.util.Objects;

public abstract class Vehicle {

    protected String manufacturer;
    protected String name;
    protected double emptyWeight;

    protected Vehicle() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.emptyWeight, emptyWeight) == 0 &&
                manufacturer.equals(vehicle.manufacturer) &&
                name.equals(vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, name, emptyWeight);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", emptyWeight=" + emptyWeight +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    protected abstract Vehicle setManufacturer(String manufacturer);

    protected abstract Vehicle setName(String name);

    protected abstract Vehicle setEmptyWeight(double emptyWeight);
}
