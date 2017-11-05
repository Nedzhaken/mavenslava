package com.netcracker.entity;

public class Style {
    private static int counterid=0;
    private final int styleid;
    private String name;

    public Style() {
        this.styleid = counterid;
        this.counterid++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Style(String name) {
        this.styleid = counterid;
        this.counterid++;
        this.name = name;
    }

    public int getStyleid() {
        return styleid;
    }

    public String getName() {
        return name;
    }
}
