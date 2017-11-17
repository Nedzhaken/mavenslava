package com.netcracker.infrastructure.services.states;

import com.netcracker.infrastructure.services.Controller;

public class NoUserState extends AbstractState implements State {

    private Controller controller;

    public NoUserState(Controller controller) {
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
            case "login":
                controller.setCurrentState(new UserState(controller));
                break;
            default:
                System.out.println("Error. Repeat command.");
                break;
        }

    }
}
