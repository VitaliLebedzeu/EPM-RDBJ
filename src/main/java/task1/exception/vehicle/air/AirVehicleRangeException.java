package task1.exception.vehicle.air;

import task1.exception.vehicle.VehicleParametersException;
import task1.model.vehicle.air.AirVehicle;

public class AirVehicleRangeException extends VehicleParametersException {

    private static final String MESSAGE = "[AirVehicleRangeException] The task1.model '%s' should have positive range parameter.";

    public AirVehicleRangeException(AirVehicle airVehicle) {
        super(airVehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, ((AirVehicle) vehicle).getRange());
    }
}
