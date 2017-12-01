package com.netcracker.entity;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Actor {

    private String actorid;
    private String firstname;
    private String lastname;
    private String  birthdate;
    private List<Film> films;

    public Actor() {
        this.actorid=UUID.randomUUID().toString();
    }

    public Actor(String firstname, String lastname, String  birthdate) {
        this.actorid=UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public Actor(String actorId, String firstname, String lastname, String  birthdate) {
        this.actorid=actorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String  birthdate) {
        this.birthdate = birthdate;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getActorid() {
        return actorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName(){
        return firstname+' '+lastname;
    }

    public String  getBirthdate() {
        return birthdate;
    }

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public String toString(){
        if(this == null){
            System.out.println("Error, Actor is null");
            return null;
        }
        else{
            return "Actor [id="+getActorid()+" name="+getName()+" birthdate="+getBirthdate()+"]";
        }

    }
}
