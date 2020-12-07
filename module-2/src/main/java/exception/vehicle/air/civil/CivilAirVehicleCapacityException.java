package exception.vehicle.air.civil;

import model.vehicle.air.CivilAirVehicle;

public final class CivilAirVehicleCapacityException extends IllegalArgumentException  {

    private static final String MESSAGE = "[CivilAirVehicleCapacityException] The '%s' should have positive capacity parameter.";

    public CivilAirVehicleCapacityException(CivilAirVehicle civilAirVehicle) {
        super(String.format(MESSAGE, civilAirVehicle.getName()));
    }
}
