package com.netcracker;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        int maxPort=1000;
        int minPort=0;
        new ForkJoinPool(100).invoke(new SearchPort(minPort,maxPort));
    }

}
