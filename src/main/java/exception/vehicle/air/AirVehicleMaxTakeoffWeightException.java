package exception.vehicle.air;

import exception.vehicle.VehicleParametersException;
import model.vehicle.air.AirVehicle;

public class AirVehicleMaxTakeoffWeightException extends VehicleParametersException {

    private static final String MESSAGE = "[AirVehicleMaxTakeoffException] The model '%s' should have positive max takeoff wight parameter.";

    public AirVehicleMaxTakeoffWeightException(AirVehicle airVehicle) {
        super(airVehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, ((AirVehicle) vehicle).getMaxTakeoffWeight());
    }
}
