package com.netcracker.infrastructure.services.states;

import com.netcracker.infrastructure.services.Controller;
import com.netcracker.infrastructure.services.ServiceStyle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StyleState extends AbstractState implements State {

    ServiceStyle serviceStyle=new ServiceStyle();
    private Controller controller;

    public StyleState(Controller controller) {
        this.controller = controller;
    }
    @Override
    public void work(){
        System.out.println("Help\nState\nLoadAllStyle\nClearStyle\nBack\nExit\n");
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
                System.out.println("On the page you can work with style");
                break;
            case "State":
                System.out.println("AdminState");
                break;
            case "LoadAllStyle":
                System.out.println("all style\n");
                serviceStyle.SearchFullAll();
                break;
            case "ClearStyle":
                serviceStyle.DeleteAll();
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
