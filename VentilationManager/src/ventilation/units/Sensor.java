/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilation.units;

import java.util.UUID;
import ventilation.enumerators.SensorTypes;

/**
 *
 * @author Hounsvad
 */
public class Sensor {

    private final UUID id = UUID.randomUUID();
    private int value;
    private String name;
    private SensorReader reader;
    private final SensorTypes type;

    public Sensor(String name, SensorReader reader, SensorTypes type) {
        this.name = name;
        this.reader = reader;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorReader getReader() {
        return reader;
    }

    public void setReader(SensorReader reader) {
        this.reader = reader;
    }

    public UUID getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
    
    public void updateValue(){
        this.value = this.reader.getValue();
    }

    public SensorTypes getType() {
        return type;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UUID : ").append(this.id).append(".\n");
        sb.append("Name : ").append(this.name).append(".\n");
        sb.append("Max input : ").append(this.reader.getMaxValue()).append(".\n");
        sb.append("Min input : ").append(this.reader.getMinValue()).append(".\n");
        sb.append("Type: ").append(this.type.getSensorType()).append(".\n");
        sb.append("Unit: ").append(this.type.getUnit()).append(".\n");    
        return sb.toString();
    }

}
