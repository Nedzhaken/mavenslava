package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.FilmActor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;

public class FilmActorRepositoryImpl  {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FilmActorRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    }

