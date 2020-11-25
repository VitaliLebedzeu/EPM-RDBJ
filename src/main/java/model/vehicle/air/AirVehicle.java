package model.vehicle.air;

import model.ServiceZone;
import model.vehicle.Vehicle;

import java.util.Objects;

public abstract class AirVehicle extends Vehicle implements Flyable {

    protected ServiceZone serviceZone;
    protected AirVehicleType airVehicleType;
    protected double serviceCeiling;
    protected double maxTakeoffWeight;
    protected double maxLandingWeight;
    protected int range;

    private boolean isFlown;

    protected AirVehicle() {
        super();
    }

    final public void flyIn() {
        if (isNotFlown()) {
            setFlown(true);
        }
    }

    final public void landIn() {
        if (isFlown()) {
            setFlown(false);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AirVehicle that = (AirVehicle) o;
        return Double.compare(that.serviceCeiling, serviceCeiling) == 0 &&
                Double.compare(that.maxTakeoffWeight, maxTakeoffWeight) == 0 &&
                Double.compare(that.maxLandingWeight, maxLandingWeight) == 0 &&
                range == that.range &&
                isFlown == that.isFlown &&
                serviceZone == that.serviceZone &&
                airVehicleType == that.airVehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), serviceZone, airVehicleType, serviceCeiling, maxTakeoffWeight, maxLandingWeight, range, isFlown);
    }

    @Override
    public String toString() {
        return "AirVehicle{" +
                "serviceZone=" + serviceZone +
                ", airVehicleType=" + airVehicleType +
                ", serviceCeiling=" + serviceCeiling +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                ", maxLandingWeight=" + maxLandingWeight +
                ", range=" + range +
                ", isFlown=" + isFlown +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", emptyWeight=" + emptyWeight +
                '}';
    }

    protected boolean isFlown() {
        return isFlown;
    }

    protected void setFlown(boolean flown) {
        isFlown = flown;
    }

    public ServiceZone getServiceZone() {
        return serviceZone;
    }

    public AirVehicleType getAirVehicleType() {
        return airVehicleType;
    }

    public double getServiceCeiling() {
        return serviceCeiling;
    }

    public double getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public double getMaxLandingWeight() {
        return maxLandingWeight;
    }

    public int getRange() {
        return range;
    }

    public double calculateCarryingCapacity() {
        return maxTakeoffWeight - emptyWeight;
    }

    abstract AirVehicle setAirVehicleType(AirVehicleType airVehicleType);

    abstract AirVehicle setServiceCeiling(double serviceCeiling);

    abstract AirVehicle setMaxTakeoffWeight(double maxTakeoffWeight);

    abstract AirVehicle setMaxLandingWeight(double maxLandingWeight);

    abstract AirVehicle setRange(int range);

    private boolean isNotFlown() {
        return !isFlown;
    }
}
