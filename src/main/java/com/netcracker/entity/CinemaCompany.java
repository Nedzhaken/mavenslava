package com.netcracker.entity;

import java.util.ArrayList;

public class CinemaCompany {
    private static int counterid=0;
    private final int companyid;
    private  String name;
    private String countryname;
    private ArrayList films;

    public CinemaCompany() {
        this.companyid = counterid;
        this.counterid++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public void setFilms(ArrayList films) {
        this.films = films;
    }

    public CinemaCompany(String name, String countryname) {
        this.companyid = counterid;
        this.counterid++;
        this.name = name;
        this.countryname = countryname;
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

    public ArrayList getFilms() {

        return films;
    }
}
