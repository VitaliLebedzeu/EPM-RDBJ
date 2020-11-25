package model.vehicle.air;

import model.ServiceZone;

import java.util.Objects;

public class MilitaryAirVehicle extends AirVehicle {

    private MilitaryAirVehicleType militaryType;

    public MilitaryAirVehicle() {
        super();
        super.serviceZone = ServiceZone.MILITARY;
    }

    @Override
    public MilitaryAirVehicle setManufacturer(String manufacturer) {
        super.manufacturer = manufacturer;
        return this;
    }

    @Override
    public MilitaryAirVehicle setName(String name) {
        super.name = name;
        return this;
    }

    @Override
    public MilitaryAirVehicle setEmptyWeight(double emptyWeight) {
        super.emptyWeight = emptyWeight;
        return this;

    }

    @Override
    public MilitaryAirVehicle setAirVehicleType(AirVehicleType airVehicleType) {
        super.airVehicleType = airVehicleType;
        return this;
    }

    @Override
    public MilitaryAirVehicle setServiceCeiling(double serviceCeiling) {
        super.serviceCeiling = serviceCeiling;
        return this;
    }

    @Override
    public MilitaryAirVehicle setMaxTakeoffWeight(double maxTakeoffWeight) {
        super.maxTakeoffWeight = maxTakeoffWeight;
        return this;
    }

    @Override
    public MilitaryAirVehicle setMaxLandingWeight(double maxLandingWeight) {
        super.maxLandingWeight = maxLandingWeight;
        return this;
    }

    @Override
    public MilitaryAirVehicle setRange(int range) {
        super.range = range;
        return this;
    }

    public MilitaryAirVehicleType getMilitaryType() {
        return militaryType;
    }

    public MilitaryAirVehicle setMilitaryType(MilitaryAirVehicleType militaryType) {
        this.militaryType = militaryType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MilitaryAirVehicle that = (MilitaryAirVehicle) o;
        return militaryType == that.militaryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }

    @Override
    public String toString() {
        return "MilitaryAirVehicle{" +
                "militaryType=" + militaryType +
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
