package Cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hounsvad
 */
public class CommandContainer {

    CommandList command;
    List<String> args;
    int commandCount = 0;

    public CommandContainer(CommandList command, String[] args) {
        this.command = command;
        this.args = Arrays.asList(args);
    }

    public CommandContainer() {
        Scanner s = new Scanner(System.in).useDelimiter(";");
        outer:

        while (true) {
            System.out.print("Enter a command seperated with ; and ending with ;\n-> ");
            this.args = new ArrayList<String>();
            String input = s.next();

            if (input.equalsIgnoreCase("help") || input.equalsIgnoreCase("?")) {
                for (CommandList c : CommandList.values()) {
                    System.out.println(c.getHelp());
                }
                continue;
            }
            try {
                switch (CommandList.valueOf(input.replace('\32', '\0').toUpperCase())) {
                    case ADDBUILDING:
                        command = CommandList.ADDBUILDING;
                        break;
                    case ADDCO2SENSOR:
                        command = CommandList.ADDCO2SENSOR;
                        break;
                    case ADDTEMPERATURESENSOR:
                        command = CommandList.ADDTEMPERATURESENSOR;
                        break;
                    case ADDACTUATOR:
                        command = CommandList.ADDACTUATOR;
                        break;
                    case REMOVEACTUATOR:
                        command = CommandList.REMOVEACTUATOR;
                        break;
                    case REMOVESENSOR:
                        command = CommandList.REMOVESENSOR;
                        break;
                    case LIST:
                        command = CommandList.LIST;
                        break outer;
                    case EXIT:
                        command = CommandList.EXIT;
                        break outer;
                    default:
                        System.out.println("That was not a command!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("That was not a command!");
                continue;
            }

            if (s.hasNext()) {
                while (s.hasNext()) {
                    commandCount++;
                    args.add(s.next());
                }
                if (commandCount > this.command.getCommandCount()) {
                    System.out.println("This command does not take this many commands");
                } else if (commandCount < this.command.getCommandCount()) {
                    System.out.println("This command takes more arguments");
                    continue;
                } else {
                    break;
                }
            } else {
                System.out.println("This command takes multiple arguments");
            }
        }
    }

    public CommandList getCommand() {
        return command;
    }

    public List<String> getArgs() {
        return args;
    }
}
