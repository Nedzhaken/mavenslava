package com.netcracker;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class SearchPort extends RecursiveTask {
    private int maxPort;
    private int minPort;
     public static CopyOnWriteArrayList<String> copyOnWriteArrayList=new CopyOnWriteArrayList<String>();

    public SearchPort(int minPort,int maxPort){
        this.minPort=minPort;
        this.maxPort=maxPort;
    }

    @Override
    protected CopyOnWriteArrayList<String> compute(){
        if (maxPort==minPort){
            openPort(maxPort);
        }
        else {
            SearchPort task = new SearchPort(minPort,maxPort-1);
            task.fork();
            openPort(maxPort);
            task.join();
        }
        return copyOnWriteArrayList;
    }

    public void  openPort (int portMin){
        String ip="192.168.1.2";
            try {
                InetAddress ipAddress = InetAddress.getLocalHost();
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip, portMin),2);
                socket.close();
                copyOnWriteArrayList.add(String.valueOf(portMin));
                //System.out.println(ip +":"+ portMin + " port is open ttttttttttttttttttttttttttttt");
            } catch (Exception ex) {
                //System.out.println(ip +":"+ portMin + " port is close");
        }

    }

}
