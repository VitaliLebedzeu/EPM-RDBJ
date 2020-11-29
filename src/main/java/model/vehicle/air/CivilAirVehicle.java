package model.vehicle.air;

import annotation.ProdCode;
import exception.vehicle.VehicleEmptyWeightException;
import exception.vehicle.air.AirVehicleMaxTakeoffWeightException;
import exception.vehicle.air.AirVehicleRangeException;
import exception.vehicle.air.civil.CivilAirVehicleCapacityException;
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
        if (emptyWeight <= 0) {
            System.err.println(new VehicleEmptyWeightException(this).getMessage());
        }
        super.emptyWeight = emptyWeight;
        return this;

    }

    @Override
    public CivilAirVehicle setAirVehicleType(AirVehicleType airVehicleType) {
        super.airVehicleType = airVehicleType;
        return this;
    }

    @Override
    public CivilAirVehicle setMaxTakeoffWeight(double maxTakeoffWeight) {
        if (maxTakeoffWeight <= 0) {
            System.err.println(new AirVehicleMaxTakeoffWeightException(this).getMessage());
        }
        super.maxTakeoffWeight = maxTakeoffWeight;
        return this;
    }

    @Override
    public CivilAirVehicle setRange(int range) {
        if (range <= 0) {
            System.err.println(new AirVehicleRangeException(this).getMessage());
        }
        super.range = range;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public CivilAirVehicle setCapacity(int capacity) {
        if (capacity < 0) {
            System.err.println(new CivilAirVehicleCapacityException(this).getMessage());
        }
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
                '}';
    }

    /**
     * This method return detailed civil air vehicle info
     * @return String that contains all parameters including ancestor's
     */
    @Override
    @ProdCode
    public String getInfo() {
        return super.getInfo() + "   Capacity: " + capacity + "\n";
    }
}
