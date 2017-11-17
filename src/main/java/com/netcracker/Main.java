package com.netcracker;

import com.netcracker.entity.CinemaCompany;
import com.netcracker.infrastructure.repositories.CinemaCompanyRepositoryImpl;
import com.netcracker.infrastructure.services.Controller;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        CinemaCompanyRepositoryImpl cinemaCompanyRepository=context.getBean(CinemaCompanyRepositoryImpl.class);
        CinemaCompany cinemaCompany1=new CinemaCompany("DC");
        CinemaCompany cinemaCompany=new CinemaCompany("Marvel");

        cinemaCompanyRepository.deleteCompanyName("DC");
        //cinemaCompanyRepository.insert(cinemaCompany);
        //cinemaCompanyRepository.insert(cinemaCompany1);
        //List<CinemaCompany> load=cinemaCompanyRepository.loadByCompanyName("DC");


//        Controller controller = context.getBean(Controller.class);
//        controller.start();
    }
}
