/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilation.units;

import java.util.UUID;

/**
 *
 * @author Hounsvad
 */
public abstract class SensorReader {
    private int value;
    private String name;
    private int minValue;
    private int maxValue;
    private final UUID id = UUID.randomUUID();

    public SensorReader(String name, int minValue, int maxValue) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public abstract int getValue();

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
    
    
}
