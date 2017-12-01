package com.netcracker.entity;

import java.util.List;
import java.util.UUID;


public class CinemaCompany {
    private String companyid;
    private String companyname;
    private List<Film> films;

    public CinemaCompany() {
        this.companyid=UUID.randomUUID().toString();
    }

    public CinemaCompany(String name) {
        this.companyid=UUID.randomUUID().toString();
        this.companyname = name;
    }

    public CinemaCompany(String companyid,String name) {
        this.companyid=companyid;
        this.companyname = name;
    }

    public void setCompanyname(String name) {
        this.companyname = name;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getCompanyId() {
        return companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public List<Film> getFilms() {

        return films;
    }

    @Override
    public String toString(){
        return "Company [id="+getCompanyId().toString()+" name="+getCompanyname()+"]";
    }
}
