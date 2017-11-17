package com.netcracker.entity;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Actor {

    private UUID actoridd;
    private String firstname;
    private String lastname;
    private Calendar birthdate;
    private List<Film> films;

    public Actor() {
        this.actoridd=UUID.randomUUID();
    }

    public Actor(String firstname, String lastname, Calendar birthdate) {
        this.actoridd=UUID.randomUUID();
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

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public UUID getActorid() {
        return actoridd;
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

    public Calendar getBirthdate() {
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
            return "Style [id="+getActorid().toString()+" name="+getName()+"]";
        }

    }
}
