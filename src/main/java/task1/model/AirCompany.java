package task1.model;

import org.apache.commons.lang3.StringUtils;
import task1.InfoHarvester;
import task1.annotation.ThisCodeSmells;
import task1.annotation.UseArrayList;
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

    @UseArrayList
    public List<AirVehicle> getAirVehicles() {
        return airVehicles;
    }

    @UseArrayList
    public void setAirVehicles(List<AirVehicle> airVehicles) {
        this.airVehicles = airVehicles;
    }

    @UseArrayList
    public void addAirVehicle(AirVehicle... airVehicles) {
        this.airVehicles.addAll(Arrays.asList(airVehicles));
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

    @UseArrayList
    public int calculateCivilCapacity() {
        return airVehicles.stream()
                          .filter(airVehicle -> airVehicle.getServiceZone().equals(ServiceZone.CIVIL))
                          .mapToInt(civilAirVehicle -> ((CivilAirVehicle) civilAirVehicle).getCapacity())
                          .sum();
    }

    @ThisCodeSmells()
    @ThisCodeSmells(reviewer = "Vitali Lebedzeu")
    public String getAirVehiclesInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Air Company: ").append(getName()).append(StringUtils.SPACE);
        InfoHarvester<AirVehicle> infoHarvester = (List<AirVehicle> x) -> x.stream().map(AirVehicle::getInfo).collect(Collectors.joining());
        return stringBuilder.append(infoHarvester.harvest(airVehicles)).toString();
    }

    /**
     * This method is not specified by Service Zone
     * @deprecated Please use {@link #calculateFullCivilCarryingCapacity()} or {@link #calculateFullMilitaryCarryingCapacity()}
     */
    @Deprecated
    @UseArrayList
    public double calculateFullCarryingCapacity() {
        return airVehicles.stream().mapToDouble(AirVehicle::getCarryingCapacity).sum();
    }

    public double calculateFullCivilCarryingCapacity() {
        return calculateFullCarryingCapacity(ServiceZone.CIVIL);
    }

    public double calculateFullMilitaryCarryingCapacity() {
        return calculateFullCarryingCapacity(ServiceZone.MILITARY);
    }

    @UseArrayList
    public List<AirVehicle> sortAirVehiclesByRange() {
        return airVehicles.stream().sorted(Comparator.comparingInt(AirVehicle::getRange)).collect(Collectors.toList());
    }

    @UseArrayList
    public List<AirVehicle> getAirVehicleByParameters(AirVehicle airVehicle) {
        return airVehicles.stream()
                          .filter(a -> a.getRange() >= airVehicle.getRange())
                          .filter(a -> a.getCarryingCapacity() > airVehicle.getCarryingCapacity()).collect(Collectors.toList());
    }

    @UseArrayList
    private double calculateFullCarryingCapacity(ServiceZone serviceZone) {
        return airVehicles.stream()
                          .filter(airVehicle -> airVehicle.getServiceZone().equals(serviceZone))
                          .mapToDouble(AirVehicle::getCarryingCapacity)
                          .sum();
    }
}
