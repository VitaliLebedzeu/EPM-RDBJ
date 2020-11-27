package task1.exception.vehicle.air.civil;

import task1.exception.vehicle.VehicleParametersException;
import task1.model.vehicle.air.CivilAirVehicle;

public class CivilAirVehicleCapacityException extends VehicleParametersException {

    private static final String MESSAGE = "[CivilAirVehicleCapacityException] The task1.model '%s' should have positive capacity parameter.";

    public CivilAirVehicleCapacityException(CivilAirVehicle civilAirVehicle) {
        super(civilAirVehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, vehicle.getName());
    }
}
