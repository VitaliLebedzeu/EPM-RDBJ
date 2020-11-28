package task1.model.vehicle.air;

public enum AirVehicleType {
    PLANE, HELICOPTER, QUADCOPTER,

    /**
     * This is not popular vehicle and not recommended for using
     */
    @SuppressWarnings("unused")
    DRONE
}
