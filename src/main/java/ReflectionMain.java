import task1.model.AirCompany;
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

        ReflectionApi.setAllClassFields(airbus320, airbus320.getClass());
        ReflectionApi.setAllClassFields(twinRanger, airbus320.getClass());
        ReflectionApi.setAllClassFields(phantom, phantom.getClass());
        ReflectionApi.setAllClassFields(falcon, falcon.getClass());
        ReflectionApi.setAllClassFields(hind, hind.getClass());
        ReflectionApi.setAllClassFields(quad, quad.getClass());

        AirCompany aeroflot = (AirCompany) ReflectionApi.createAirVehicle("task1.model.AirCompany");
        ReflectionApi.setClassField(aeroflot, aeroflot.getClass(), "name", "Aeroflot");
        ReflectionApi.setClassField(aeroflot, aeroflot.getClass(), "airVehicles", airbus320, twinRanger, phantom, falcon, hind, quad);

        System.out.println(falcon.getInfo());
        System.out.println(airbus320.getInfo());
        System.out.println(phantom.getInfo());

    }
}
