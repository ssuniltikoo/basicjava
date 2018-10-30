package com.training.java.collections.DemoIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TransferDataFromFile implements Runnable {
    private  static int counter=1;
    public TransferDataFromFile() {

    }

    public TransferDataFromFile(String name) {
        System.out.println("percentage");
    }

    public void TransferData() {
        try {
            FileReader reader = new FileReader(new File("C:\\Users\\shreeram\\Desktop\\evolutionoflanguage.txt"));
            Delay(1000);
            FileWriter writer = new FileWriter(new File("C:\\Users\\shreeram\\Desktop\\Display.txt"));
            char[] buffer = new char[128];

            int charread = reader.read();

            while (charread != -1) {
                Delay(100);
                writer.write(buffer, 0, charread);
                System.out.println("data copied is" + charread);
                Thread.yield();
                counter ++;
                System.out.println(Thread.currentThread().getName());
               // Delay(1000);
                charread = reader.read(buffer);
                Thread.yield();
                counter ++;
                Delay(100);
                System.out.println(Thread.currentThread().getName());
                System.out.println(counter);
                counter ++;
                Thread.yield();
                System.out.println(counter);
               // Delay(1000);
                writer.flush();
                Thread.yield();
                System.out.println(Thread.currentThread().getName());
                counter ++;
                Delay(100);

            }
            System.out.println(counter);
            counter=100;
            Delay(1000);
            writer.close();
            reader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {

        System.out.println("Data Transfer started . Done BY  " + Thread.currentThread().getName());
        Delay(100);

        TransferData();
        Thread.yield();
    }

    public int Status() {
        //System.out.println("Data transfer status status progress");
        return counter;
    }

    public void Delay(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}
