package task1.model.vehicle.air;

import task1.exception.vehicle.air.AirVehicleCarryingCapacityException;
import task1.model.ServiceZone;
import task1.model.vehicle.Vehicle;

import java.util.Objects;

public abstract class AirVehicle extends Vehicle implements Flyable {

    protected ServiceZone serviceZone;
    protected AirVehicleType airVehicleType;
    protected double maxTakeoffWeight;
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
        return Double.compare(that.maxTakeoffWeight, maxTakeoffWeight) == 0 &&
                range == that.range &&
                isFlown == that.isFlown &&
                serviceZone == that.serviceZone &&
                airVehicleType == that.airVehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), serviceZone, airVehicleType, maxTakeoffWeight, range, isFlown);
    }

    @Override
    public String toString() {
        return "AirVehicle{" +
                "serviceZone=" + serviceZone +
                ", airVehicleType=" + airVehicleType +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
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

    public double getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public int getRange() {
        return range;
    }

    public double getCarryingCapacity() {
        try {
            return calculateCarryingCapacity();
        } catch (AirVehicleCarryingCapacityException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    abstract AirVehicle setAirVehicleType(AirVehicleType airVehicleType);

    abstract AirVehicle setMaxTakeoffWeight(double maxTakeoffWeight);

    abstract AirVehicle setRange(int range);

    private boolean isNotFlown() {
        return !isFlown;
    }

    private double calculateCarryingCapacity() throws AirVehicleCarryingCapacityException {
        if (maxTakeoffWeight < emptyWeight) {
            throw new AirVehicleCarryingCapacityException(this);
        }
        return maxTakeoffWeight - emptyWeight;
    }
}
