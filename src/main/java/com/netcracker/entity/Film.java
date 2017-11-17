package com.netcracker.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Film {

    private UUID filmid;
    private Date releasedate;
    private Style style;
    private String name;
    private CinemaCompany company;
    private int bookid;
    private List<Actor> actors;

    public Film() {
        this.filmid=UUID.randomUUID();
    }

    public Film(Date releasedate, Style style, String name, CinemaCompany company, int bookid) {
        filmid=UUID.randomUUID();
        this.releasedate = releasedate;
        this.style = style;
        this.name = name;
        this.company = company;
        this.bookid = bookid;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(CinemaCompany company) {
        this.company = company;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public UUID getFilmid() { return filmid; }

    public Date getReleasedate() {
        return releasedate;
    }

    public Style getStyle() {
        return style;
    }

    public String getName() {
        return name;
    }

    public CinemaCompany getCompany() { return company; }

    public int getBookid() {
        return bookid;
    }

    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString(){
        return "Film [id="+getFilmid().toString()+" name="+getName()+"]";
    }

}
