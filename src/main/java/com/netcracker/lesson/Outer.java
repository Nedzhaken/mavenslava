package com.netcracker.lesson;

public class Outer {

    private final String name;

    public Outer(String name) {
        this.name = name;
    }

    public class Inner {
        public String getOuterName(){
            return name;
        }
    }
}
