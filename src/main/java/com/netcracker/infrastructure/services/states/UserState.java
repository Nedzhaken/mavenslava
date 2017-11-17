package com.netcracker.infrastructure.services.states;

import com.netcracker.infrastructure.services.Controller;

public class UserState extends AbstractState implements State {

    private Controller controller;

    public UserState(Controller controller) {
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
            case "beuser":
                System.out.println("I am user");
                break;
            default:
                System.out.println("Error. Repeat command.");
                break;
        }
    }
}
