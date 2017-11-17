package com.netcracker.entity;

import java.util.List;
import java.util.UUID;

public class Style {

    private UUID styleid;
    private String name;
    private List<Film> films;

    public Style() {
        this.styleid=UUID.randomUUID();
    }

    public Style(String name) {
        this.styleid=UUID.randomUUID();
        this.name = name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getStyleid() {
        return styleid;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString(){
        return "Style [id="+getStyleid().toString()+" name="+getName()+"]";
    }
}
