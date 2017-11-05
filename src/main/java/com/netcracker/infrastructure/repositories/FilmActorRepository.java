package com.netcracker.infrastructure.repositories;

import com.netcracker.substance.FilmActor;

import java.util.ArrayList;

public interface FilmActorRepository {
    public void save(FilmActor style);
    public ArrayList<FilmActor> load();
}