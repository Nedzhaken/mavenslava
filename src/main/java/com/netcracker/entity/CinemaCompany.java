package com.netcracker.entity;

import java.util.ArrayList;

public class CinemaCompany {
    private static int counterid=0;
    private final int companyid;
    private  String name;
    private String countryname;
    private ArrayList<Film> films;

    public CinemaCompany() {
        this.companyid = counterid;
        this.counterid++;
    }

    public CinemaCompany(String name, String countryname) {
        this.companyid = counterid;
        this.counterid++;
        this.name = name;
        this.countryname = countryname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public int getCompanyid() {
        return companyid;
    }

    public String getName() {
        return name;
    }

    public String getCountryname() {
        return countryname;
    }

    public ArrayList<Film> getFilms() {

        return films;
    }
}
