package exception.vehicle.air.civil;

import exception.vehicle.VehicleParametersException;
import model.vehicle.air.CivilAirVehicle;

public class CivilAirVehicleCapacityException extends VehicleParametersException {

    private static final String MESSAGE = "[CivilAirVehicleCapacityException] The '%s' should have positive capacity parameter.";

    public CivilAirVehicleCapacityException(CivilAirVehicle civilAirVehicle) {
        super(civilAirVehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, vehicle.getName());
    }
}
