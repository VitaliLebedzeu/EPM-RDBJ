package exception.vehicle.air;

import annotation.UseStackOnly;
import exception.vehicle.VehicleParametersException;
import model.vehicle.air.AirVehicle;

public final class AirVehicleRangeException extends VehicleParametersException {

    @UseStackOnly
    private static final String MESSAGE = "[AirVehicleRangeException] The '%s' should have positive range parameter.";

    public AirVehicleRangeException(AirVehicle airVehicle) {
        super(airVehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, vehicle.getName());
    }
}
