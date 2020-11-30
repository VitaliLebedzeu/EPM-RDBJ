package exception.vehicle;

import annotation.UseStackOnly;
import model.vehicle.Vehicle;

public class VehicleEmptyWeightException extends VehicleParametersException {

    @UseStackOnly
    private static final String MESSAGE = "[VehicleEmptyWeightException] The '%s' should have positive empty weight parameter.";

    public VehicleEmptyWeightException(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, vehicle.getName());
    }
}
