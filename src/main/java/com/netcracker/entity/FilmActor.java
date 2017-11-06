package com.netcracker.entity;

import java.util.ArrayList;

public class FilmActor {
    private int filmid;
    private ArrayList<Actor> actor;

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public void setActor(ArrayList<Actor> actor) {
        this.actor = actor;
    }

    public FilmActor() {
    }

    public FilmActor(int filmid, ArrayList<Actor> actor) {
        this.filmid = filmid;
        this.actor = actor;
    }

    public int getFilmid() {
        return filmid;
    }

    public ArrayList<Actor> getActor() {
        return actor;
    }
}
