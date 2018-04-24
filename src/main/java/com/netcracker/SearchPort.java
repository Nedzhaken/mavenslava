package com.netcracker;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.RecursiveAction;

public class SearchPort extends RecursiveAction {
    private int maxPort;
    private int minPort;
    private int step=2;

    public SearchPort(int minPort,int maxPort){
        this.minPort=minPort;
        this.maxPort=maxPort;
    }

    @Override
    protected void compute(){

        if (maxPort==minPort){
            openPort(maxPort);
        }
        else {
            SearchPort task = new SearchPort(minPort,maxPort-1);
            task.fork();
            openPort(maxPort);
            task.join();
        }

    }

    public void  openPort (int portMin){
        String ip="195.19.34.72";
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip, portMin),2);
                socket.close();
                System.out.println(ip +":"+ portMin + " port is open ttttttttttttttttttttttttttttt");
            } catch (Exception ex) {
                System.out.println(ip +":"+ portMin + " port is close");
        }

    }

}
