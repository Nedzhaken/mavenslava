package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.FilmActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class FilmActorRepositoryImpl  {
    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FilmActorRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    }

