package com.netcracker.infrastructure.services;

import com.netcracker.entity.Style;
import com.netcracker.infrastructure.repositories.StyleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceStyle {

    @Autowired
    public StyleRepositoryImpl styleRepository;

    public void insert(Style style){
        styleRepository.insert(style);
    }

    public List<Style> loadAll() {
        return styleRepository.loadAll();
    }

    public List<Style> loadByStyleName(String styleName) {
        return styleRepository.loadByStyleName(styleName);
    }

    public Style loadByStyleID(String styleId){
        return styleRepository.loadByStyleID(styleId);
    }

    public List<Style> loadAllFull() {
        return styleRepository.loadAllFull();
    }

    public List<Style> loadByStyleNameFull(String styleName){
         return styleRepository.loadByStyleNameFull(styleName);
    }

    public Style loadByStyleIDFull(String styleId){
        return styleRepository.loadByStyleIDFull(styleId);
    }

    public void deleteAll(){
        styleRepository.deleteAll();
    }

    public void deleteStyleName(String styleName){
        styleRepository.deleteStyleName(styleName);
    }

    public void deleteStyleId(String styleId){
        styleRepository.deleteStyleId(styleId);
    }

}
