/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cli;

/**
 *
 * @author Hounsvad
 */
public enum Types {
    Building("Building"),
    Sensor("Sensor"),
    ACTUATOR("Actuator");

    String type;

    private Types(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
