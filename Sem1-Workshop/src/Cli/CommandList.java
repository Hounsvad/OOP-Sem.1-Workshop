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
public enum CommandList {
    ADDBUILDING("ADD BUILDING", "ADD BUILDING; <Name>; <Address>", 2),
    ADDCO2SENSOR("ADD SENSOR", "ADD SENSOR; <Name>; <BuildingName>", 3),
    ADDTEMPERATURESENSOR("ADD SENSOR", "ADD SENSOR; <Name>; <BuildingName>", 3),
    ADDACTUATOR("ADD ACTUATOR", "ADD ACTUATOR; <Name>; <BuildingName>", 1),
    REMOVEACTUATOR("REMOVE ACTUATOR", "REMOVE; <BuildingName>; <Name>", 1),
    REMOVESENSOR("REMOVE SENSOR", "REMOVE SENSOR; <BuildingName>; <Name>", 1),
    LIST("LIST", "LIST", 0),
    EXIT("EXIT", "EXIT", 0);

    String commandText;
    String help;
    int commandCount;

    private CommandList(String commandText, String help, int commandCount) {
        this.commandText = commandText;
        this.help = help;
        this.commandCount = commandCount;
    }

    public int getCommandCount() {
        return commandCount;
    }

    public String getHelp() {
        return help;
    }

    public String getCommandText() {
        return commandText;
    }

    @Override
    public String toString() {
        return commandText;
    }
}
