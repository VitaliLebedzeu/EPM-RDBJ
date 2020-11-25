package model;

import model.vehicle.air.AirVehicle;
import model.vehicle.air.CivilAirVehicle;
import model.vehicle.air.MilitaryAirVehicle;

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
}
