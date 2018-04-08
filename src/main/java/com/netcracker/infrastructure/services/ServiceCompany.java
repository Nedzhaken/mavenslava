package com.netcracker.infrastructure.services;

import com.netcracker.entity.CinemaCompany;
import com.netcracker.entity.Film;
import com.netcracker.entity.Style;
import com.netcracker.infrastructure.repositories.CinemaCompanyRepositoryImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceCompany {

//    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//    CinemaCompanyRepositoryImpl cinemaCompanyRepository=context.getBean(CinemaCompanyRepositoryImpl.class);
//
//    public void SearchAll(){
//        List<CinemaCompany> list=cinemaCompanyRepository.loadAll();
//        for(CinemaCompany element : list) {
//            System.out.println(element.toString());
//        }
//    }
//
//    public void DeleteAll(){
//        cinemaCompanyRepository.deleteAll();
//    }
//
//    public void SearchFullAll(){
//        List<CinemaCompany> list=cinemaCompanyRepository.loadAllFull();
//        for(CinemaCompany element : list) {
//            System.out.println(element.toString()+"\n");
//            for (Film element1 : element.getFilms()){
//                System.out.println("   "+element1.toString()+"\n");
//            }
//        }
//    }
}
