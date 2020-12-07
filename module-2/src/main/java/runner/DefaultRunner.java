package runner;

import annotation.ProdCode;
import model.AirCompany;
import model.vehicle.Vehicle;
import model.vehicle.air.AirVehicle;
import model.vehicle.air.AirVehicleType;
import model.vehicle.air.CivilAirVehicle;
import model.vehicle.air.MilitaryAirVehicle;
import model.vehicle.air.MilitaryAirVehicleType;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;

public class DefaultRunner {

    public static final String DELIMITER = StringUtils.LF + "===============================" + StringUtils.LF;

    @ProdCode
    private static void run() {
        String log = "Default Runner:" + DefaultRunner.DELIMITER;

        MilitaryAirVehicle phantom = new MilitaryAirVehicle().setAirVehicleType(AirVehicleType.PLANE).setMilitaryType(MilitaryAirVehicleType.FIGHTER)
                                                             .setName("F-4").setRange(680).setEmptyWeight(30).setMaxTakeoffWeight(0);
        MilitaryAirVehicle falcon = new MilitaryAirVehicle().setAirVehicleType(AirVehicleType.PLANE).setMilitaryType(MilitaryAirVehicleType.FIGHTER)
                                                            .setName("F-16").setRange(4217).setEmptyWeight(0).setMaxTakeoffWeight(19.19);
        MilitaryAirVehicle hind = new MilitaryAirVehicle().setAirVehicleType(AirVehicleType.HELICOPTER).setName("Mi-24").setRange(450)
                                                          .setEmptyWeight(18.74).setMaxTakeoffWeight(26.46);
        MilitaryAirVehicle quad = new MilitaryAirVehicle().setAirVehicleType(AirVehicleType.QUADCOPTER).setName("Quad-1600").setRange(0)
                                                          .setEmptyWeight(0.45).setMaxTakeoffWeight(0.45);
        CivilAirVehicle airbus320 = new CivilAirVehicle().setAirVehicleType(AirVehicleType.PLANE).setName("Airbus A320").setRange(3300)
                                                         .setEmptyWeight(37.23).setMaxTakeoffWeight(57.13).setCapacity(180);
        CivilAirVehicle twinRanger = new CivilAirVehicle().setAirVehicleType(AirVehicleType.HELICOPTER).setName("Bell 400").setRange(730)
                                                          .setEmptyWeight(1.40).setMaxTakeoffWeight(2.50).setCapacity(5);
        AirCompany aeroflot = new AirCompany("Aeroflot");
        aeroflot.addAirVehicle(phantom, falcon, hind, quad, airbus320, twinRanger);

        log += "Full civil air vehicles capacity: " + aeroflot.calculateCivilCapacity() + StringUtils.LF;
        log += "Full civil air vehicles carrying capacity: " + aeroflot.calculateFullCivilCarryingCapacity() + StringUtils.LF;
        log += "Full military air vehicles carrying capacity: " + aeroflot.calculateFullMilitaryCarryingCapacity() + DefaultRunner.DELIMITER;
        log += "All air vehicle sorting by range:" + aeroflot.sortAirVehiclesByRange().stream().map(Vehicle::getName)
                                                             .collect(Collectors.joining(StringUtils.LF));

        AirVehicle searchedParameters = new CivilAirVehicle().setRange(500);
        log += "All air vehicle with range more or equals than 500 km:" + aeroflot.getAirVehicleByParameters(searchedParameters).stream()
                                                                                  .map(Vehicle::getName).collect(Collectors.joining(StringUtils.LF));
        log += DefaultRunner.DELIMITER;
        log += aeroflot.getAirVehiclesInfo();
        System.out.println(log);
    }
}
