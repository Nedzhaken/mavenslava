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

    public List<Style> loadAll() {
        return styleRepository.loadAll();
    }

    public List<Style> loadByStyleName(String styleName) {
        return styleRepository.loadByStyleName(styleName);
    }

    public List<Style> loadAllFull() {
        return styleRepository.loadAllFull();
    }

}
