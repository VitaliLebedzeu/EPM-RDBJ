package task1.model;

import task1.model.vehicle.air.AirVehicle;
import task1.model.vehicle.air.CivilAirVehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AirCompany {

    private String name;
    private List<AirVehicle> airVehicles;

    public AirCompany(String name) {
        this.name = name;
        airVehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AirVehicle> getAirVehicles() {
        return airVehicles;
    }

    public void setAirVehicles(List<AirVehicle> airVehicles) {
        this.airVehicles = airVehicles;
    }

    public AirCompany addAirVehicle(AirVehicle... airVehicles) {
        this.airVehicles.addAll(Arrays.asList(airVehicles));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCompany that = (AirCompany) o;
        return name.equals(that.name) &&
                Objects.equals(airVehicles, that.airVehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, airVehicles);
    }

    @Override
    public String toString() {
        return "AirCompany{" +
                "name='" + name + '\'' +
                ", airVehicles=" + airVehicles +
                '}';
    }

    public int calculateCivilCapacity() {
        return airVehicles.stream()
                          .filter(airVehicle -> airVehicle.getServiceZone().equals(ServiceZone.CIVIL))
                          .mapToInt(civilAirVehicle -> ((CivilAirVehicle) civilAirVehicle).getCapacity())
                          .sum();
    }

    public double calculateFullCivilCarryingCapacity() {
        return calculateFullCarryingCapacity(ServiceZone.CIVIL);
    }

    public double calculateFullMilitaryCarryingCapacity() {
        return calculateFullCarryingCapacity(ServiceZone.MILITARY);
    }

    public List<AirVehicle> sortAirVehiclesByRange() {
        return airVehicles.stream().sorted(Comparator.comparingInt(AirVehicle::getRange)).collect(Collectors.toList());
    }

    public List<AirVehicle> getAirVehicleByParameters(AirVehicle airVehicle) {
        return airVehicles.stream()
                          .filter(a -> a.getRange() >= airVehicle.getRange())
                          .filter(a -> a.getCarryingCapacity() > airVehicle.getCarryingCapacity()).collect(Collectors.toList());
    }

    private double calculateFullCarryingCapacity(ServiceZone serviceZone) {
        return airVehicles.stream()
                          .filter(airVehicle -> airVehicle.getServiceZone().equals(serviceZone))
                          .mapToDouble(AirVehicle::getCarryingCapacity)
                          .sum();
    }
}
