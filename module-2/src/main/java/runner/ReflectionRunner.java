package runner;

import annotation.ProdCode;
import model.AirCompany;
import model.vehicle.air.AirVehicleType;
import model.vehicle.air.CivilAirVehicle;
import model.vehicle.air.MilitaryAirVehicle;
import org.apache.commons.lang3.StringUtils;
import tool.ReflectionApi;

public class ReflectionRunner {

    @ProdCode
    public static void run() {
        StringBuilder stringBuilder = new StringBuilder("Reflection Runner: START").append(StringUtils.LF);
        stringBuilder.append(DefaultRunner.DELIMITER).append(StringUtils.LF);

        CivilAirVehicle airbus320 = (CivilAirVehicle) ReflectionApi.createClass("model.vehicle.air.CivilAirVehicle");
        CivilAirVehicle twinRanger = (CivilAirVehicle) ReflectionApi.createClass("model.vehicle.air.CivilAirVehicle");
        MilitaryAirVehicle phantom = (MilitaryAirVehicle) ReflectionApi.createClass("model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle falcon = (MilitaryAirVehicle) ReflectionApi.createClass("model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle hind = (MilitaryAirVehicle) ReflectionApi.createClass("model.vehicle.air.MilitaryAirVehicle");
        MilitaryAirVehicle quad = (MilitaryAirVehicle) ReflectionApi.createClass("model.vehicle.air.MilitaryAirVehicle");

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

        AirCompany aeroflot = (AirCompany) ReflectionApi.createClass("model.AirCompany", "Aeroflot");
        ReflectionApi.invokeVoidClassMethod(aeroflot, "addAirVehicle", airbus320, twinRanger, phantom, falcon, hind, quad);

        stringBuilder.append((String) ReflectionApi.invokeClassMethod(aeroflot, "getAirVehiclesInfo"));

        System.out.println(stringBuilder.toString());
    }
}
