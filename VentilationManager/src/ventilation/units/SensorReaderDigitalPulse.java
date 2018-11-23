/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilation.units;

import java.util.Random;

/**
 *
 * @author Hounsvad
 */
public class SensorReaderDigitalPulse extends SensorReader{
    public SensorReaderDigitalPulse(String name, int minValue, int maxValue) {
        super(name, minValue, maxValue);
    }

    @Override
    public int getValue() {
        Random r = new Random();
        return r.nextInt(this.getMaxValue()-this.getMinValue()+1)+this.getMinValue();
    }
}
