package com.netcracker.infrastructure.services.states;

import com.netcracker.infrastructure.services.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminState extends AbstractState implements State {

    private Controller controller;

    public AdminState(Controller controller) {
        this.controller = controller;
    }
    @Override
    public void work(){
        System.out.println("Help\nState\nStyle\nCompany\nFilms\nActors\nChange\nExit\n");
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
                System.out.println("On the page you can see all objects of this class");
                break;
            case "State":
                System.out.println("AdminState");
                break;
            case "Style":
                controller.setCurrentState(new StyleState(controller));
                break;
            case "Company":
                controller.setCurrentState(new CompanyState(controller));
                break;
            case "Films":
                controller.setCurrentState(new FilmState(controller));
                break;
            case "Actors":
                controller.setCurrentState(new ActorState(controller));
                break;
            case "Change":
                System.out.println("Change state\n");
                controller.setCurrentState(new NoUserState(controller));
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
