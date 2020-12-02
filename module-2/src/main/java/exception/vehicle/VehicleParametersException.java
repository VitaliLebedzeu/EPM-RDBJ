package exception.vehicle;

import annotation.UseStackOnly;
import model.vehicle.Vehicle;

public class VehicleParametersException extends RuntimeException {

    protected final Vehicle vehicle;

    @UseStackOnly
    private static final String MESSAGE = "[VehicleParametersException] The '%s' has wrong parameters";

    public VehicleParametersException(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, vehicle.getName());
    }
}
