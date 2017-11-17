package com.netcracker.infrastructure.services;

import com.netcracker.infrastructure.repositories.StyleRepository;
import com.netcracker.infrastructure.services.states.NoUserState;
import com.netcracker.infrastructure.services.states.State;
import org.hibernate.SessionFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
//    private StyleRepository styleRepository;

    SessionFactory sessionFactory;
    State currentState = new NoUserState(this);

    public Controller(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void start() {
        boolean b = true;
        while (b) {
            System.out.println("1 - Information about styles\n2 - End programms");
            try {
                Scanner in = new Scanner(System.in);
                String command = in.next();
                currentState.analyzeCommand(command);

            } catch (InputMismatchException r) {
                System.out.println("Error. Not number.\n");
            }


        }
    }

}
