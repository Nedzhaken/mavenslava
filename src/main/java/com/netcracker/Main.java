package com.netcracker;

import com.netcracker.entity.Actor;
import com.netcracker.entity.CinemaCompany;
import com.netcracker.entity.Film;
import com.netcracker.entity.Style;
import com.netcracker.infrastructure.repositories.ActorRepositoryImpl;
import com.netcracker.infrastructure.repositories.CinemaCompanyRepositoryImpl;
import com.netcracker.infrastructure.repositories.FilmRepositoryImpl;
import com.netcracker.infrastructure.repositories.StyleRepositoryImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//                Controller controller = context.getBean(Controller.class);
//        controller.start();
//        CinemaCompanyRepositoryImpl cinemaCompanyRepository=context.getBean(CinemaCompanyRepositoryImpl.class);
//        ActorRepositoryImpl actorRepository=context.getBean(ActorRepositoryImpl.class);
//        FilmRepositoryImpl filmRepository=context.getBean(FilmRepositoryImpl.class);
//        StyleRepositoryImpl styleRepository=context.getBean(StyleRepositoryImpl.class);
//
//        cinemaCompanyRepository.deleteAll();
//        actorRepository.deleteAll();
//        filmRepository.deleteAll();
//        styleRepository.deleteAll();
//
//        Actor actor=new Actor("Okunevich","Yaroslav","12.12.12");
//        Actor actor1=new Actor("Nemchenko","Danil","11.11.11");
//        actorRepository.insert(actor);
//        actorRepository.insert(actor1);
//        Style style=new Style("horror");
//        Style style1=new Style("comedy");
//        styleRepository.insert(style);
//        styleRepository.insert(style1);
//        CinemaCompany cinemaCompany1=new CinemaCompany("DC");
//        CinemaCompany cinemaCompany=new CinemaCompany("Marvel");
//        cinemaCompanyRepository.insert(cinemaCompany1);
//        cinemaCompanyRepository.insert(cinemaCompany);
//        Film film=new Film("Avangers",style1,"12.12.43",cinemaCompany,3);
//        Film film1=new Film("SuperMan", style,"12.4.25",cinemaCompany1,5);
//        List<Actor> list=new ArrayList<Actor>();
//        list.add(actor);
//        list.add(actor1);
//        film.setActors(list);
//        filmRepository.insertFull(film);
//        filmRepository.insert(film1);
//        List<Film> film=filmRepository.loadFilmWithActor();

        //List<CinemaCompany> load=cinemaCompanyRepository.loadByCompanyName("DC");

    }
}
