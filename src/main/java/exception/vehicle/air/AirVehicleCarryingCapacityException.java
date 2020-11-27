package exception.vehicle.air;

import model.vehicle.air.AirVehicle;

public class AirVehicleCarryingCapacityException extends Exception {

    private static final String MESSAGE = "[AirVehicleCarryingCapacityException] The maximum takeoff weight should be higher than empty weight. " +
            "The air vehicle model: '%s'. Empty weight: %f; Maximum takeoff weight: %f";

    private final AirVehicle airVehicle;

    public AirVehicleCarryingCapacityException(AirVehicle airVehicle) {
        this.airVehicle = airVehicle;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, airVehicle.getName(), airVehicle.getEmptyWeight(), airVehicle.getMaxTakeoffWeight());
    }
}
