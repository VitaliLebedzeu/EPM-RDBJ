package exception.vehicle.air;

import annotation.UseStackOnly;
import exception.vehicle.VehicleParametersException;
import model.vehicle.air.AirVehicle;

public final class AirVehicleMaxTakeoffWeightException extends VehicleParametersException {

    @UseStackOnly
    private static final String MESSAGE = "[AirVehicleMaxTakeoffException] The '%s' should have positive max takeoff wight parameter.";

    public AirVehicleMaxTakeoffWeightException(AirVehicle airVehicle) {
        super(airVehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, ((AirVehicle) vehicle).getMaxTakeoffWeight());
    }
}
