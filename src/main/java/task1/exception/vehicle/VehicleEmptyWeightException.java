package task1.exception.vehicle;

import task1.model.vehicle.Vehicle;

public class VehicleEmptyWeightException extends VehicleParametersException {

    private static final String MESSAGE = "[VehicleEmptyWeightException] The task1.model '%s' should have positive empty weight parameter.";

    public VehicleEmptyWeightException(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, vehicle.getName());
    }
}
