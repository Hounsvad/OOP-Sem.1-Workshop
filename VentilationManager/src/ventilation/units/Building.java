package ventilation.units;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hounsvad
 */
public class Building{

    private Map<UUID, Sensor> sensors = new HashMap<>();
    private Map<UUID, Actuator> actuators = new HashMap<>();
    private UUID id;
    private String name;
    private String address;

    public Building(String name, String address) {
        this.name = name;
        this.address = address;
        this.id = UUID.randomUUID();
    }

    public UUID addSensor(Sensor sensor) {
        if (sensor != null && !this.sensors.containsKey(sensor.getId())) {
            this.sensors.put(sensor.getId(), sensor);
            return sensor.getId();
        }
        return null;
    }

    public UUID addActuator(Actuator actuator) {
        if (actuator != null && !this.actuators.containsKey(actuator.getId())) {
            this.actuators.put(actuator.getId(), actuator);
            return actuator.getId();
        }
        return null;
    }

    public boolean removeSensor(UUID id) {
        if (id != null && this.sensors.containsKey(id)) {
            this.sensors.remove(id);
            return true;
        }
        return false;
    }

    public boolean removeActuator(UUID id) {
        if (id != null && this.actuators.containsKey(id)) {
            this.actuators.remove(id);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<UUID, Sensor> getSensors() {
        return sensors;
    }

    public Map<UUID, Actuator> getActuators() {
        return actuators;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UUID : ").append(this.id).append(".\n");
        sb.append("Name : ").append(this.name).append(".\n");
        sb.append("Sensors : ").append(".\n");
        for (Map.Entry<UUID, Sensor> entry : this.sensors.entrySet()) {
            UUID key = entry.getKey();
            Sensor value = entry.getValue();
            sb.append("Id : ").append(key).append(" Name : ").append(value.getName()).append(" Type: ").append(value.getType().getSensorType()).append(".\n");
        }
        for (Map.Entry<UUID, Actuator> entry : this.actuators.entrySet()) {
            UUID key = entry.getKey();
            Actuator value = entry.getValue();
            sb.append("Id : ").append(key).append(" Name : ").append(value.getName()).append(".\n");
        }
        return sb.toString();
    }

}
