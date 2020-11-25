package model.vehicle.air;

import model.ServiceZone;

import java.util.Objects;

public class CivilAirVehicle extends AirVehicle {

    private int capacity;

    public CivilAirVehicle() {
        super();
        super.serviceZone = ServiceZone.CIVIL;
    }

    @Override
    public CivilAirVehicle setManufacturer(String manufacturer) {
        super.manufacturer = manufacturer;
        return this;
    }

    @Override
    public CivilAirVehicle setName(String name) {
        super.name = name;
        return this;
    }

    @Override
    public CivilAirVehicle setEmptyWeight(double emptyWeight) {
        super.emptyWeight = emptyWeight;
        return this;

    }

    @Override
    public CivilAirVehicle setAirVehicleType(AirVehicleType airVehicleType) {
        super.airVehicleType = airVehicleType;
        return this;
    }

    @Override
    public CivilAirVehicle setServiceCeiling(double serviceCeiling) {
        super.serviceCeiling = serviceCeiling;
        return this;
    }

    @Override
    public CivilAirVehicle setMaxTakeoffWeight(double maxTakeoffWeight) {
        super.maxTakeoffWeight = maxTakeoffWeight;
        return this;
    }

    @Override
    public CivilAirVehicle setMaxLandingWeight(double maxLandingWeight) {
        super.maxLandingWeight = maxLandingWeight;
        return this;
    }

    @Override
    public CivilAirVehicle setRange(int range) {
        super.range = range;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public CivilAirVehicle setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CivilAirVehicle that = (CivilAirVehicle) o;
        return capacity == that.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }

    @Override
    public String toString() {
        return "CivilAirVehicle{" +
                "capacity=" + capacity +
                ", serviceZone=" + serviceZone +
                ", airVehicleType=" + airVehicleType +
                ", serviceCeiling=" + serviceCeiling +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                ", maxLandingWeight=" + maxLandingWeight +
                ", range=" + range +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", emptyWeight=" + emptyWeight +
                '}';
    }
}
