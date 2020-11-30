package model.vehicle;

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

    /**
     * This method return detailed vehicle info
     * @return String that contains all parameters
     */
    public String getInfo() {
        return "\n" + name + "Specification:\n" + "   Name: " + name + "\n" +
                "   Manufacturer: " + manufacturer + "\n" +
                "   Empty Weight: " + emptyWeight + "\n";
    }

    protected abstract Vehicle setManufacturer(String manufacturer);

    protected abstract Vehicle setName(String name);

    protected abstract Vehicle setEmptyWeight(double emptyWeight);
}
