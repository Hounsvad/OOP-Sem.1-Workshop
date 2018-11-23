/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cli;

import ventilation.units.Manager;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Hounsvad
 */
public class Main {

    public static void main(String[] args) {
        Manager p = new Manager();
        while (true) {
            CommandContainer input = new CommandContainer();
            CommandList command = input.getCommand();
            List<String> arguments = input.getArgs();
            switch (input.getCommand()) {
                case EXIT:
                    System.exit(1);
                    break;
                case LIST:
                    for (Map.Entry<UUID, String> e : p.getBuildingInformation().entrySet()) {
                        UUID buildingId = e.getKey();
                        String buildingName = e.getValue();
                        System.out.println(buildingName + ":");
                        System.out.println("Sensors:");
                        for (Map.Entry<UUID, String> SensorEntries : p.getSensorInformation(buildingId).entrySet()) {
                            UUID SensorId = SensorEntries.getKey();
                            String sensorName = SensorEntries.getValue();
                            System.out.println("-" + sensorName);
                        }

                        System.out.println("Actuators:");
                        for (Map.Entry<UUID, String> actuatorEntries : p.getSensorInformation(buildingId).entrySet()) {
                            UUID actuatorId = actuatorEntries.getKey();
                            String actuatorName = actuatorEntries.getValue();
                            System.out.println("-" + actuatorName);
                        }
                        System.out.println("\n");
                    }
                    break;
                case ADDACTUATOR:
                    p.addVentilationActuator(arguments.get(1), arguments.get(0));
                    break;
                case ADDBUILDING:
                    p.addBuilding(arguments.get(0), arguments.get(1));
                    break;
                case ADDCO2SENSOR:
                    p.addCo2Sensor(arguments.get(1), arguments.get(0));
                    break;
                case ADDTEMPERATURESENSOR:
                    p.addTemperatureSensor(arguments.get(1), arguments.get(0));
                    break;
                case REMOVEACTUATOR:
                    p.removeActuator(arguments.get(0), arguments.get(1));
                    break;
                case REMOVESENSOR:
                    p.removeSensor(arguments.get(0), arguments.get(1));
                    break;
                default:
            }
        }
    }
}
