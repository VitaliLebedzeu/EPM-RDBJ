package exception.vehicle;

import model.vehicle.Vehicle;

public class VehicleEmptyWeightException extends VehicleParametersException {

    private static final String MESSAGE = "[VehicleEmptyWeightException] The model '%s' should have positive empty weight parameter.";

    public VehicleEmptyWeightException(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, vehicle.getName());
    }
}
