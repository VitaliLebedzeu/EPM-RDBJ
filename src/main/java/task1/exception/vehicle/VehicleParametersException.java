package task1.exception.vehicle;

import task1.model.vehicle.Vehicle;

public class VehicleParametersException extends RuntimeException {

    protected final Vehicle vehicle;

    private static final String MESSAGE = "[VehicleParametersException] The task1.model '%s' has wrong parameters";

    public VehicleParametersException(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, vehicle.getName());
    }
}
