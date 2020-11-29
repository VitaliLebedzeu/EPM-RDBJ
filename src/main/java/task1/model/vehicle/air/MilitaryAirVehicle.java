package task1.model.vehicle.air;

import task1.annotation.ProdCode;
import task1.exception.vehicle.VehicleEmptyWeightException;
import task1.exception.vehicle.air.AirVehicleMaxTakeoffWeightException;
import task1.exception.vehicle.air.AirVehicleRangeException;
import task1.model.ServiceZone;

import java.util.Objects;

public class MilitaryAirVehicle extends AirVehicle {

    private MilitaryAirVehicleType militaryType;

    //TODO: Will be implemented in the next iteration.
    @SuppressWarnings("unused")
    private int power;

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
        if (emptyWeight <= 0) {
            System.err.println(new VehicleEmptyWeightException(this).getMessage());
        }
        super.emptyWeight = emptyWeight;
        return this;

    }

    @Override
    public MilitaryAirVehicle setAirVehicleType(AirVehicleType airVehicleType) {
        super.airVehicleType = airVehicleType;
        return this;
    }

    @Override
    public MilitaryAirVehicle setMaxTakeoffWeight(double maxTakeoffWeight) {
        if (maxTakeoffWeight <= 0) {
            System.err.println(new AirVehicleMaxTakeoffWeightException(this).getMessage());
        }
        super.maxTakeoffWeight = maxTakeoffWeight;
        return this;
    }

    @Override
    public MilitaryAirVehicle setRange(int range) {
        if (range <= 0) {
            System.err.println(new AirVehicleRangeException(this).getMessage());
        }
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
                '}';
    }

    /**
     * This method return detailed military air vehicle info
     * @return String that contains all parameters including ancestor's
     */
    @Override
    @ProdCode
    public String getInfo() {
        return super.getInfo() + "   Military Type: " + militaryType + "\n";
    }
}
