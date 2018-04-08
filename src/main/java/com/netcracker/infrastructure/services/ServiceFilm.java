package com.netcracker.infrastructure.services;

import com.netcracker.entity.Actor;
import com.netcracker.entity.Film;
import com.netcracker.infrastructure.repositories.FilmRepositoryImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class ServiceFilm {
//
//    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//    FilmRepositoryImpl filmRepository=context.getBean(FilmRepositoryImpl.class);
//
//    public void SearchAll(){
//
//        List<Film> list=filmRepository.loadAll();
//        for(Film element : list) {
//            System.out.println(element.toString());
//        }
//    }
//
//    public void DeleteAll(){
//        filmRepository.deleteAll();
//    }
//
//    public void SearchFullAll(){
//        List<Film> list=filmRepository.loadFilmWithActor();
//        for(Film element : list) {
//            System.out.println(element.toString()+"\n");
//            for (Actor element1 : element.getActors()){
//                System.out.println("   "+element1.toString()+"\n");
//            }
//            System.out.println("  Style = "+element.getStyle().getName()+"\n");
//            System.out.println("  Cinema company = "+element.getCompany().getCompanyname()+"\n");
//        }
//    }
//
//    public void SearchFullAllByName() {
//        Scanner in = new Scanner(System.in);
//        String command = in.next();
//
//        List<Film> list = filmRepository.loadByFilmNameWithActor(command);
//        if (list.size() == 0) {
//            System.out.println("Film is not found\n");
//        } else {
//            for (Film element : list) {
//                System.out.println(element.toString() + "\n");
//                for (Actor element1 : element.getActors()) {
//                    System.out.println("   " + element1.toString() + "\n");
//                }
//                System.out.println("  Style = " + element.getStyle().getName() + "\n");
//                System.out.println("  Cinema company = " + element.getCompany().getCompanyname() + "\n");
//            }
//        }
//    }
//
//    public void SearchFullAllByPartName() {
//        Scanner in = new Scanner(System.in);
//        String command = in.next();
//
//        List<Film> list = filmRepository.loadByFilmPartNameWithActor(command);
//        if (list.size() == 0) {
//            System.out.println("Film is not found\n");
//        } else {
//            for (Film element : list) {
//                System.out.println(element.toString() + "\n");
//                for (Actor element1 : element.getActors()) {
//                    System.out.println("   " + element1.toString() + "\n");
//                }
//                System.out.println("  Style = " + element.getStyle().getName() + "\n");
//                System.out.println("  Cinema company = " + element.getCompany().getCompanyname() + "\n");
//            }
//        }
//    }

}
