/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilation.units;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import ventilation.enumerators.SensorTypes;
import ventilation.interfaces.IBuildingManagementSystem;

/**
 *
 * @author Hounsvad
 */
public class Manager implements IBuildingManagementSystem {

    private final Map<UUID, Building> buildings = new HashMap<>();

    public void addBuilding(Building b) {
        this.buildings.put(b.getId(), b);
    }

    public UUID addBuilding(String name, String address) {
        Building newBuilding = new Building(name, address);
        this.buildings.put(newBuilding.getId(), newBuilding);
        return newBuilding.getId();
    }

    public void updateSensors() {
        for (Map.Entry<UUID, Building> entry : buildings.entrySet()) {
            Building value = entry.getValue();
            for (Map.Entry<UUID, Sensor> entry1 : value.getSensors().entrySet()) {
                Sensor value1 = entry1.getValue();
                value1.updateValue();
            }
        }
    }

    public String getUpdateUpdate() {
        updateSensors();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<UUID, Building> entry : buildings.entrySet()) {

            Building value = entry.getValue();
            sb.append("Building name: ").append(value.getName()).append(".\n");
            sb.append("Sensors:\n");
            for (Map.Entry<UUID, Sensor> entry1 : value.getSensors().entrySet()) {
                Sensor value1 = entry1.getValue();

                sb.append("Name: ").append(value1.getName()).append(" Value: ").append(value1.getValue()).append(value1.getType().getUnit()).append(".\n");
            }
            sb.append("Actuators:\n");
            for (Map.Entry<UUID, Actuator> entry1 : value.getActuators().entrySet()) {
                Actuator value1 = entry1.getValue();
                sb.append("Name: ").append(value1.getName()).append(" Value: ").append(value1.getState()).append(".\n");
            }
        }
        return sb.toString();
    }

    @Override
    public Map<UUID, String> getBuildingInformation() {
        Map<UUID, String> result = new HashMap<>();

        for (Map.Entry<UUID, Building> entry : buildings.entrySet()) {
            UUID key = entry.getKey();
            Building value = entry.getValue();
            result.put(key, value.getName());
        }
        return result;
    }

    public UUID getBuildingId(String buildingName) {
        for (Map.Entry<UUID, Building> entry : buildings.entrySet()) {
            UUID key = entry.getKey();
            Building value = entry.getValue();
            if (value.getName().equalsIgnoreCase(buildingName)) {
                return key;
            }
        }
        return null;
    }

    public UUID getSensorId(String buildingName, String SensorName) {
        for (Map.Entry<UUID, Sensor> entry : buildings.get(getBuildingId(buildingName)).getSensors().entrySet()) {
            UUID key = entry.getKey();
            Sensor value = entry.getValue();
            if (value.getName().equalsIgnoreCase(SensorName)) {
                return key;
            }
        }
        return null;
    }

    public UUID getActuatorId(String buildingName, String ActuatorName) {
        for (Map.Entry<UUID, Actuator> entry : buildings.get(getBuildingId(buildingName)).getActuators().entrySet()) {
            UUID key = entry.getKey();
            Actuator value = entry.getValue();
            if (value.getName().equalsIgnoreCase(ActuatorName)) {
                return key;
            }
        }
        return null;
    }

    @Override
    public Map<UUID, String> getSensorInformation(UUID buildingId) {
        Map<UUID, String> result = new HashMap<>();

        for (Map.Entry<UUID, Sensor> entry : buildings.get(buildingId).getSensors().entrySet()) {
            UUID key = entry.getKey();
            Sensor value = entry.getValue();
            result.put(key, value.getName());
        }
        return result;
    }

    @Override
    public Map<UUID, String> getActuatorInformation(UUID buildingId) {
        Map<UUID, String> result = new HashMap<>();

        for (Map.Entry<UUID, Actuator> entry : buildings.get(buildingId).getActuators().entrySet()) {
            UUID key = entry.getKey();
            Actuator value = entry.getValue();
            result.put(key, value.getName());
        }
        return result;
    }

    @Override
    public UUID addTemperatureSensor(UUID buildingId, String name) {
        return buildings.get(buildingId).addSensor(new Sensor(name, new ventilation.units.SensorReaderAnalog420(name, 0, 120), SensorTypes.TEMPERATURE));
    }

    public UUID addTemperatureSensor(String buildingName, String name) {
        return addTemperatureSensor(getBuildingId(buildingName), name);
    }

    @Override
    public UUID addCo2Sensor(UUID buildingId, String name) {
        return buildings.get(buildingId).addSensor(new Sensor(name, new ventilation.units.SensorReaderAnalog420(name, 0, 10000), SensorTypes.CO2));
    }

    public UUID addCo2Sensor(String buildingName, String name) {
        return addCo2Sensor(getBuildingId(buildingName), name);
    }

    @Override
    public void removeSensor(UUID buildingId, UUID sensorId) {
        buildings.get(buildingId).removeSensor(sensorId);
    }

    public void removeSensor(String buildingName, String name) {
        removeSensor(getBuildingId(buildingName), getSensorId(buildingName, name));
    }

    @Override
    public UUID addVentilationActuator(UUID buildingId, String name) {
        return buildings.get(buildingId).addActuator(new Actuator(name));
    }

    public UUID addVentilationActuator(String buildingName, String name) {
        return addVentilationActuator(getBuildingId(buildingName), name);
    }

    @Override
    public void removeActuator(UUID buildingId, UUID actuatorId) {
        buildings.get(buildingId).removeActuator(actuatorId);
    }

    public void removeActuator(String buildingName, String actuatorName) {
        removeActuator(getBuildingId(buildingName), getActuatorId(buildingName, actuatorName));
    }
}
