package task1.exception.vehicle.air;

import task1.exception.vehicle.VehicleParametersException;
import task1.model.vehicle.air.AirVehicle;

public class AirVehicleMaxTakeoffWeightException extends VehicleParametersException {

    private static final String MESSAGE = "[AirVehicleMaxTakeoffException] The task1.model '%s' should have positive max takeoff wight parameter.";

    public AirVehicleMaxTakeoffWeightException(AirVehicle airVehicle) {
        super(airVehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, ((AirVehicle) vehicle).getMaxTakeoffWeight());
    }
}
