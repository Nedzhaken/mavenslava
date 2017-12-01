package com.netcracker.infrastructure.services.states;

import com.netcracker.infrastructure.services.Controller;
import com.netcracker.infrastructure.services.ServiceFilm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FilmState extends AbstractState implements State {

    ServiceFilm serviceFilm=new ServiceFilm();
    private Controller controller;

    public FilmState(Controller controller) {
        this.controller = controller;
    }
    @Override
    public void work(){
        System.out.println("Help\nState\nLoadAllFilms\nLoadFilmsByName\nLoadFilmsByPartName\nClearFilms\nBack\nExit\n");
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
                System.out.println("On the page you can work with films");
                break;
            case "State":
                System.out.println("AdminState");
                break;
            case "LoadAllFilms":
                System.out.println("all films\n");
                serviceFilm.SearchFullAll();
                break;
            case "LoadFilmsByName":
                System.out.println("Name film?\n");
                serviceFilm.SearchFullAllByName();
                break;
            case "LoadFilmsByPartName":
                System.out.println("Part Name film?\n");
                serviceFilm.SearchFullAllByPartName();
                break;
            case "ClearFilms":
                serviceFilm.DeleteAll();
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
