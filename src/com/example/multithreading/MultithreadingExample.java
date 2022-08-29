package com.example.multithreading;

import java.io.IOException;

public class MultithreadingExample {

    public static void main(String[] args) throws IOException {
        SharedResource resource = new SharedResource();
        Thread1 thread1 = new Thread1(resource);
        Thread2 thread2 = new Thread2(resource);

        thread1.start();
        thread2.start();
    }



}

class SharedResource {
    void print( int resourceNumber ,int n) {

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


class Thread1 extends Thread{
    SharedResource resource;

    Thread1(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        this.resource.print(1, 10);
    }
}

class Thread2 extends Thread{
    SharedResource resource;

    Thread2(SharedResource resource) {
        this.resource = resource;
    }

    public void run(){
        this.resource.print(2,100);
    }

}

