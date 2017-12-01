package com.netcracker.entity;

import java.util.ArrayList;

public class FilmActor {
    private String filmId;
    private String actorId;

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public FilmActor(String filmId, String actorId) {

        this.filmId = filmId;
        this.actorId = actorId;
    }

    public String getFilmId() {
        return filmId;
    }

    public String getActorId() {
        return actorId;
    }
}
