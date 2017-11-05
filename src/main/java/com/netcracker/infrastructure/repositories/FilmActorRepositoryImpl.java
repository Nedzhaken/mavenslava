package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.FilmActor;

import java.util.ArrayList;

public class FilmActorRepositoryImpl implements FilmActorRepository {
    private ArrayList<FilmActor> list=new ArrayList<FilmActor>();

    @Override
    public void save(FilmActor filmActor) {
        list.add(filmActor);
        System.out.println("Save successfully = "+filmActor.getFilmid()+" "+filmActor.getActor().getActor_id());
    }

    @Override
    public ArrayList<FilmActor> load() {
        if (list.size()==0) {
            System.out.println("Не один стиль не был введен");
            return null;
        }
        else {
            for(int index=0;index<list.size();index++){
                System.out.println(list.get(index).getFilmid()+" "+list.get(index).getActor().getActor_id());
            }
            return list;
        }
    }
}
