/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilation.enumerators;

/**
 *
 * @author Hounsvad
 */
public enum SensorTypes {
    CO2("CO2 sensor", "ppm"),
    TEMPERATURE("Temperature sensor", "C");

    private final String sensorType;
    private final String unit;
    
    SensorTypes(String sensorType, String unit) {
        this.sensorType = sensorType;
        this.unit = unit;
    }

    public String getSensorType() {
        return sensorType;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("Type: %-20s Unit: %-4s", getSensorType(), getUnit());
    }
}
