package com.netcracker.infrastructure.services;

import com.netcracker.infrastructure.repositories.StyleRepository;
import com.netcracker.infrastructure.services.states.NoUserState;
import com.netcracker.infrastructure.services.states.State;
import org.hibernate.SessionFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    SessionFactory sessionFactory;
    boolean b = true;
    State currentState = new NoUserState(this);

    public Controller(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void start() {
        while (b) {
            currentState.work();
        }
    }

}
