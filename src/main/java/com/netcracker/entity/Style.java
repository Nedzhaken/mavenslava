package com.netcracker.entity;

import java.util.List;
import java.util.UUID;

public class Style {

    private String styleId;
    private String name;
    private List<Film> films;

    public Style() {
        this.styleId=UUID.randomUUID().toString();
    }

    public Style(String styleid, String name) {
        this.styleId=styleid;
        this.name = name;
    }

    public Style( String name) {
        this.styleId=UUID.randomUUID().toString();
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
        return styleId;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString(){
        return "Style [id="+getStyleId().toString()+" name="+getName()+"]";
    }
}
