package com.netcracker.infrastructure.services.states;

import com.netcracker.infrastructure.services.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NoUserState extends AbstractState implements State {

    private Controller controller;

    public NoUserState(Controller controller) {
        this.controller = controller;
    }

   @Override
    public void work(){
       System.out.println("Help\nState\nUser\nAdmin\nExit\n");
       try {
           Scanner in = new Scanner(System.in);
           String command = in.next();
           analyzeCommand(command);
       } catch (InputMismatchException r) {
           System.out.println("Error. Not number.\n");
       }
   }

    @Override
    public void analyzeCommand(String command) {
        if(analyzeCommonCommands(command)){
            return;
        }

        switch (command) {
            case "Help":
                System.out.println("On this page you can determine your user level");
                break;
            case "State":
                System.out.println("NoUserState");
                break;
            case "User":
                controller.setCurrentState(new UserState(controller));
                break;
            case "Admin":
                controller.setCurrentState(new AdminState(controller));
                break;
            case "Exit":
                System.out.println("BB");
                controller.setCurrentState(new NoUserState(controller));
                controller.setB(false);
                break;
            default:
                System.out.println("Error. Repeat command.");
                break;
        }

    }
}
