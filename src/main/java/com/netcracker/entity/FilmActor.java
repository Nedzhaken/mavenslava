package com.netcracker.entity;

import java.util.ArrayList;

public class FilmActor {
    private int filmid;
    private Actor actor;

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public FilmActor() {
    }

    public FilmActor(int filmid, Actor actor) {
        this.filmid = filmid;
        this.actor = actor;
    }

    public int getFilmid() {
        return filmid;
    }

    public Actor getActor() {
        return actor;
    }
}
