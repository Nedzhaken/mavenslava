package com.netcracker.infrastructure.services.states;

public abstract class AbstractState implements State {

    boolean analyzeCommonCommands(String command){
        switch (command) {
            case "about":
                System.out.println("Program by Slava");
                return true;
            default:
                //System.out.println("Error. Repeat command.");
                break;
        }

        return false;
    }
}
