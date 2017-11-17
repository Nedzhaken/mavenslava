package com.netcracker.infrastructure.services.states;

import com.netcracker.infrastructure.services.Controller;

public class AdminState extends AbstractState implements State {

    private Controller controller;

    public AdminState(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void analyzeCommand(String command) {
        if(analyzeCommonCommands(command)){
            return;
        }

        switch (command) {
            case "help":
                break;
            case "beadmin":
                System.out.println("I am admin");
                break;
            default:
                System.out.println("Error. Repeat command.");
                break;
        }

    }
}
