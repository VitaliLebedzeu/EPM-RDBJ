package exception.vehicle.air;

import annotation.UseStackOnly;
import model.vehicle.air.AirVehicle;

public class AirVehicleCarryingCapacityException extends Exception {

    @UseStackOnly
    private static final String MESSAGE = "[AirVehicleCarryingCapacityException] The maximum takeoff weight should be higher than empty weight. " +
            "The air vehicle '%s'. Empty weight: %f; Maximum takeoff weight: %f";

    private final AirVehicle airVehicle;

    public AirVehicleCarryingCapacityException(AirVehicle airVehicle) {
        this.airVehicle = airVehicle;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, airVehicle.getName(), airVehicle.getEmptyWeight(), airVehicle.getMaxTakeoffWeight());
    }
}
