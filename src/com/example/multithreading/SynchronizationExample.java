package com.example.multithreading;

import java.io.IOException;

public class SynchronizationExample {
    public static void main(String[] args) throws IOException {
        SynchronizedSharedResource resource = new SynchronizedSharedResource();
        Thread3 thread1 = new Thread3(resource);
        Thread4 thread2 = new Thread4(resource);

        thread1.start();
        thread2.start();
    }
}

class SynchronizedSharedResource {
    synchronized  void print( int resourceNumber ,int n) {

        // Assume that the data is being read from db
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){
                System.out.println(e);
            }
        }

    }
}

class Thread3 implements Runnable{
    SynchronizedSharedResource resource;

    Thread3(SynchronizedSharedResource resource) {
        this.resource = resource;
    }

    public void start(){
        this.resource.print(1, 10);
    }

    @Override
    public void run() {

    }
}

class Thread4 implements Runnable{
    SynchronizedSharedResource resource;

    Thread4(SynchronizedSharedResource resource) {
        this.resource = resource;
    }

    public void start(){
        this.resource.print(2,100);
    }

    @Override
    public void run() {

    }
}
