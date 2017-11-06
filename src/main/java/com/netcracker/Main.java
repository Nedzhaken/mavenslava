package com.netcracker;

import com.netcracker.entity.CinemaCompany;
import com.netcracker.infrastructure.repositories.StyleRepository;
import com.netcracker.infrastructure.repositories.StyleRepositoryImpl;
import com.netcracker.infrastructure.services.Controller;
import com.netcracker.entity.Film;
import com.netcracker.entity.Style;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


public class Main {
    public static void main(String[] args){
        //Map<Integer,Integer> map=new HashMap<>();
       // map.put(1,2);
       // map.put(1,3);
        // film1=new Film();
        //ArrayList<Style> style=new ArrayList<Style>();

        //Style style1=new Style("Horror");
        //Style style2=new Style("Comedy");
       // StyleRepository styleRepositoryStyle =new StyleRepositoryImpl();
        //styleRepositoryStyle.save(style1);
        //styleRepositoryStyle.save(style2);
        //styleRepositoryStyle.load();
        //Controller controller=new Controller(styleRepositoryStyle);
        //controller.ConnectWithPeople();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Style style1=new Style();
        CinemaCompany cinemaCompany=new CinemaCompany();
        Film film4 = new Film(style1,cinemaCompany);
        Film film5 = new Film(style1,cinemaCompany);
        Film film1 = context.getBean(Film.class);
        Film film2 = context.getBean(Film.class);
        Film film3 = context.getBean(Film.class);




        }
}
