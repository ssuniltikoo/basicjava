package com.training.java.collections.DemoIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IoDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        TransferDataFromFile t = new TransferDataFromFile();
        ProgressBar p = new ProgressBar();
       // Thread test1 = new Thread(p);
        //Thread test = new Thread(t);

        //test.start();
        //test1.start();*/

       ExecutorService es = Executors.newFixedThreadPool(2);
       es.submit(t);
       es.submit(p);

        es.shutdown();
        try {
            es.awaitTermination(60, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long EndTime = System.currentTimeMillis();
        long duration = EndTime - startTime;
        System.out.println("Total time in milii seconds is " + duration);



       /* try {
            test.join();
            test1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("End main");


    }

}

