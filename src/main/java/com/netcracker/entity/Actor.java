package com.netcracker.entity;

import java.util.Calendar;

public class Actor {
    private static int counterid=0;
    private final int actorid;
    private String firstname;
    private String lastname;
    private Calendar birthdate;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public Actor(String firstname, String lastname, Calendar birthdate) {
        this.actorid = counterid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.counterid++;
    }

    public int getActor_id() {
        return actorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public Actor() {
        this.actorid = counterid;
        this.counterid++;
    }
}
