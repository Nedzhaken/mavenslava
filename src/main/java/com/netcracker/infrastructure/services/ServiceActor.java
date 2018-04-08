package com.netcracker.infrastructure.services;

import com.netcracker.entity.Actor;
import com.netcracker.entity.CinemaCompany;
import com.netcracker.entity.Film;
import com.netcracker.infrastructure.repositories.ActorRepositoryImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class  ServiceActor {
//
//    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//    ActorRepositoryImpl actorRepository=context.getBean(ActorRepositoryImpl.class);
//
//    public void SearchAll(){
//        List<Actor> list=actorRepository.loadAll();
//        for(Actor element : list) {
//            System.out.println(element.toString());
//        }
//    }
//
//    public void DeleteAll(){
//        actorRepository.deleteAll();
//    }
//
//    public void SearchFullAll(){
//        List<Actor> list=actorRepository.loadAllFull();
//        for(Actor element : list) {
//            System.out.println(element.toString()+"\n");
//            for (Film element1 : element.getFilms()){
//                System.out.println("   "+element1.toString()+"\n");
//            }
//        }
//    }
}
