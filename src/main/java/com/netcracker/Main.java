package com.netcracker;

import com.netcracker.infrastructure.repositories.StyleRepository;
import com.netcracker.infrastructure.repositories.StyleRepositoryImpl;
import com.netcracker.infrastructure.services.Controller;
import com.netcracker.entity.Film;
import com.netcracker.entity.Style;

import java.util.*;


public class Main {
    public static void main(String[] args){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(1,3);
        Film film1=new Film();
        ArrayList<Style> style=new ArrayList<Style>();

        Style style1=new Style("Horror");
        Style style2=new Style("Comedy");
        StyleRepository styleRepositoryStyle =new StyleRepositoryImpl();
        styleRepositoryStyle.save(style1);
        styleRepositoryStyle.save(style2);
        //styleRepositoryStyle.load();
        Controller controller=new Controller(styleRepositoryStyle);
        controller.ConnectWithPeople();


        }
}
