package com.netcracker.infrastructure.services;

import com.netcracker.entity.Film;
import com.netcracker.entity.Style;
import com.netcracker.infrastructure.repositories.StyleRepository;
import com.netcracker.infrastructure.repositories.StyleRepositoryImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceStyle {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    StyleRepositoryImpl styleRepository=context.getBean(StyleRepositoryImpl.class);

    public void SearchAll(){
        List<Style> list=styleRepository.loadAll();
        for(Style element : list) {
            System.out.println(element.toString());
        }
    }

    public void DeleteAll(){
        styleRepository.deleteAll();
    }

    public void SearchFullAll(){
        List<Style> list=styleRepository.loadAllFull();
        for(Style element : list) {
            System.out.println(element.toString()+"\n");
            for (Film element1 : element.getFilms()){
                System.out.println("   "+element1.toString()+"\n");
            }
        }
    }

}
