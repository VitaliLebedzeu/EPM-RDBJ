import task1.model.vehicle.air.CivilAirVehicle;
import task1.model.vehicle.air.MilitaryAirVehicle;

public class ReflectionMain {

    public static void main(String[] args) {
        CivilAirVehicle airbus320 = (CivilAirVehicle) ReflectionApi.createAirVehicle("task1.model.vehicle.air.CivilAirVehicle");
        CivilAirVehicle twinRanger = (CivilAirVehicle) ReflectionApi.createAirVehicle("task1.model.vehicle.air.CivilAirVehicle");
        MilitaryAirVehicle phantom = (MilitaryAirVehicle) ReflectionApi.createAirVehicle("task1.model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle falcon = (MilitaryAirVehicle) ReflectionApi.createAirVehicle("task1.model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle hind = (MilitaryAirVehicle) ReflectionApi.createAirVehicle("task1.model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle quad = (MilitaryAirVehicle) ReflectionApi.createAirVehicle("task1.model.vehicle.air.MilitaryAirVehicle");
    }
}
