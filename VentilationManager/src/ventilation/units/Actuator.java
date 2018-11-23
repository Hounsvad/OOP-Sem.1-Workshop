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
public class Actuator {
    private final UUID id = UUID.randomUUID();
    private String name;
    private int state;
    

    public Actuator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if(state == 0 || state == 1){
            this.state = state;
        }else{
            this.state = (state ^ 1);
        }
    }
    


}
