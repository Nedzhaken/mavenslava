package com.netcracker;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        int maxPort=1000;
        int minPort=0;
        ForkJoinPool forkJoinPoll = new ForkJoinPool(10);
        CopyOnWriteArrayList<String> copyOnWriteArrayList=(CopyOnWriteArrayList)forkJoinPoll.invoke(new SearchPort(minPort,maxPort));
    }

}
