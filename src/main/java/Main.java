import annotation.ProdCode;
import handler.ProdCodeHandler;
import handler.ThisCodeSmellsHandler;
import model.AirCompany;
import model.vehicle.air.AirVehicle;
import model.vehicle.air.AirVehicleType;
import model.vehicle.air.CivilAirVehicle;
import model.vehicle.air.MilitaryAirVehicle;
import model.vehicle.air.MilitaryAirVehicleType;

public class Main {

    public static void main(String[] args) {
        ProdCodeHandler prodCodeHandler = new ProdCodeHandler();
        try {
            prodCodeHandler.initializeObject("Main");
        } catch (Exception e) {
            System.err.printf("Class '%s' not found", e.getMessage());
        }
    }

    @ProdCode
    private static void run() {
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

        System.out.println("===============================");
        System.out.println("Full civil capacity: " + aeroflot.calculateCivilCapacity());
        System.out.println("Full civil carrying capacity: " + aeroflot.calculateFullCivilCarryingCapacity());
        System.out.println("Full military carrying capacity: " + aeroflot.calculateFullMilitaryCarryingCapacity());

        System.out.println("===============================");
        System.out.println("All air vehicle sorting by range:");
        aeroflot.sortAirVehiclesByRange().forEach(a -> System.out.println(a.getName()));

        System.out.println("===============================");
        System.out.println("All air vehicle with range more or equals than 500 km:");
        AirVehicle searchedParameters = new CivilAirVehicle().setRange(500);
        aeroflot.getAirVehicleByParameters(searchedParameters).forEach(a -> System.out.println(a.getName()));

        System.out.println("===============================");
        System.out.println(aeroflot.getAirVehiclesInfo());

        ThisCodeSmellsHandler thisCodeSmellsHandler = new ThisCodeSmellsHandler();
        thisCodeSmellsHandler.printSmeltCodeByObject(aeroflot);
    }
}
