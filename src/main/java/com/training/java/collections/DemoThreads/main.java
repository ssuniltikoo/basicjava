package com.training.java.collections.DemoThreads;




public class main {

    public static void main(String[] args) {

        long strarttime =  System.currentTimeMillis();

        ThreadsDemo th = new ThreadsDemo("ABCDEFGHIJKLM");
        ThreadsDemo th1 = new ThreadsDemo("12345678@#$%&" );
       // ThreadsDemo th2 = new ThreadsDemo("bye @ 3* & HGHgh ^^");
        Thread T1 = new Thread(th);
        Thread T2 = new Thread(th1);
        //Thread T3 = new Thread(th2);

        T1.start();
        T2.start();
        //T3.start();


        try {
            T1.join();
            T2.join();
          //  T3.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        long stoptime = System.currentTimeMillis();
        long executiontime = stoptime-strarttime;
        System.out.println("Time in ms"+executiontime);
    }
}
