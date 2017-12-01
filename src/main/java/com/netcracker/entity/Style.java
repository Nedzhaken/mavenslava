package com.netcracker.entity;

import java.util.List;
import java.util.UUID;

public class Style {

    private String styleid;
    private String name;
    private List<Film> films;

    public Style() {
        this.styleid=UUID.randomUUID().toString();
    }

    public Style(String styleid, String name) {
        this.styleid=styleid;
        this.name = name;
    }

    public Style( String name) {
        this.styleid=UUID.randomUUID().toString();
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

    public String getStyleId() {
        return styleid;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString(){
        return "Style [id="+getStyleId().toString()+" name="+getName()+"]";
    }
}
