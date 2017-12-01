package com.netcracker.infrastructure.services.states;

import com.netcracker.entity.Style;
import com.netcracker.infrastructure.services.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserState extends AbstractState implements State {

    private Controller controller;

    public UserState(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void work(){
        System.out.println("Hello User\nHelp\nState\nStyle\nCompany\nFilms\nActors\nChange\nExit\n");
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
                System.out.println("On the page you can see all objects of this class");
                break;
            case "State":
                System.out.println("UserState");
                break;
            case "Style":
                System.out.println("all style\n");
                ServiceStyle serviceStyle=new ServiceStyle();
                serviceStyle.SearchAll();
                break;
            case "Company":
                System.out.println("all company\n");
                ServiceCompany serviceCompany=new ServiceCompany();
                serviceCompany.SearchAll();
                break;
            case "Films":
                System.out.println("all films\n");
                ServiceFilm serviceFilm=new ServiceFilm();
                serviceFilm.SearchAll();
                break;
            case "Actors":
                System.out.println("all actors\n");
                ServiceActor serviceActor=new ServiceActor();
                serviceActor.SearchAll();
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
