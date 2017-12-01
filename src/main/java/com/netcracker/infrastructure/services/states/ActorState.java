package com.netcracker.infrastructure.services.states;

import com.netcracker.infrastructure.services.Controller;
import com.netcracker.infrastructure.services.ServiceActor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActorState extends AbstractState implements State {

    ServiceActor serviceActor=new ServiceActor();
    private Controller controller;

    public ActorState(Controller controller) {
        this.controller = controller;
    }
    @Override
    public void work(){
        System.out.println("Help\nState\nLoadAllActors\nClearActors\nBack\nExit\n");
        try {
            Scanner in = new Scanner(System.in);
            String command = in.next();
            analyzeCommand(command);
        } catch (InputMismatchException r) {
            System.out.println("Error. Not number.\n");
        }}

    @Override
    public void analyzeCommand(String command) {
        if(analyzeCommonCommands(command)){
            return;
        }

        switch (command) {
            case "Help":
                System.out.println("On the page you can work with actors");
                break;
            case "State":
                System.out.println("AdminState");
                break;
            case "LoadAllActors":
                System.out.println("all actors\n");
                serviceActor.SearchFullAll();
                break;
            case "ClearActors":
                serviceActor.DeleteAll();
                System.out.println("Successful\n");
                break;
            case "Back":
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
