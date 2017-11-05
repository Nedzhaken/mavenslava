package com.netcracker.infrastructure.services;

import com.netcracker.infrastructure.repositories.StyleRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private StyleRepository styleRepository;

    public Controller(StyleRepository styleRepository) {

        this.styleRepository = styleRepository;
    }

    public void ConnectWithPeople(){
        boolean b=true;
        while (b) {
            System.out.println("1 - Information about styles\n2 - End programms");
            try{
             Scanner in = new Scanner(System.in);
             int i=in.nextInt();
                switch (i) {
                    case 1:  styleRepository.load();
                        break;
                    case 2:  b=false;
                        break;
                    default: System.out.println("Error. Repeat command.");
                        break;
                }
            }
            catch (InputMismatchException r){
                System.out.println("Error. Not number.\n");
            }


        }
    }
}
