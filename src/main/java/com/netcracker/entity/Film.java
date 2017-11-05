package com.netcracker.entity;

import java.util.Date;

public class Film {
    private static int counterid=0;
    private final int filmid;
    private Date releasedate;
    private int budget;
    private Style style;
    private String name;
    private CinemaCompany company;
    private int bookid;

    public Film() {
        this.filmid = counterid;
        this.counterid++;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public void setBudget(int budget) {
        this.budget = budget;
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

    public Film(Date releasedate, int budget, Style style, String name, CinemaCompany company, int bookid) {
        this.filmid = counterid;
        this.counterid++;
        this.releasedate = releasedate;
        this.budget = budget;
        this.style = style;
        this.name = name;
        this.company = company;
        this.bookid = bookid;
    }

    public int getFilmid() { return filmid; }

    public Date getReleasedate() {
        return releasedate;
    }

    public int getBudget() {
        return budget;
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
}
