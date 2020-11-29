import task1.model.AirCompany;
import task1.model.vehicle.air.AirVehicleType;
import task1.model.vehicle.air.CivilAirVehicle;
import task1.model.vehicle.air.MilitaryAirVehicle;

public class ReflectionMain {

    public static void main(String[] args) {
        CivilAirVehicle airbus320 = (CivilAirVehicle) ReflectionApi.createClass("task1.model.vehicle.air.CivilAirVehicle");
        CivilAirVehicle twinRanger = (CivilAirVehicle) ReflectionApi.createClass("task1.model.vehicle.air.CivilAirVehicle");
        MilitaryAirVehicle phantom = (MilitaryAirVehicle) ReflectionApi.createClass("task1.model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle falcon = (MilitaryAirVehicle) ReflectionApi.createClass("task1.model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle hind = (MilitaryAirVehicle) ReflectionApi.createClass("task1.model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle quad = (MilitaryAirVehicle) ReflectionApi.createClass("task1.model.vehicle.air.MilitaryAirVehicle");

        ReflectionApi.setClassField(airbus320, airbus320.getClass(), "airVehicleType", AirVehicleType.PLANE);
        ReflectionApi.setClassField(airbus320, airbus320.getClass(), "name", "Airbus A320");
        ReflectionApi.setClassField(airbus320, airbus320.getClass(), "range", 3300);
        ReflectionApi.setClassField(airbus320, airbus320.getClass(), "emptyWeight", 37.23);
        ReflectionApi.setClassField(airbus320, airbus320.getClass(), "maxTakeoffWeight", 57.13);
        ReflectionApi.setClassField(airbus320, airbus320.getClass(), "capacity", 180);

        ReflectionApi.setAllClassFields(twinRanger, airbus320.getClass());
        ReflectionApi.setAllClassFields(phantom, phantom.getClass());
        ReflectionApi.setAllClassFields(falcon, falcon.getClass());
        ReflectionApi.setAllClassFields(hind, hind.getClass());
        ReflectionApi.setAllClassFields(quad, quad.getClass());

        AirCompany aeroflot = (AirCompany) ReflectionApi.createClass("task1.model.AirCompany", "Aeroflot");
        ReflectionApi.invokeVoidClassMethod(aeroflot, "addAirVehicle", airbus320, twinRanger, phantom, falcon, hind, quad);

        System.out.println((String) ReflectionApi.invokeClassMethod(aeroflot, "getAirVehiclesInfo"));

        System.out.println(ReflectionApi.getClassMetadata(falcon));
    }
}
