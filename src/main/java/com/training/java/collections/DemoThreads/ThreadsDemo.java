package com.training.java.collections.DemoThreads;

public class ThreadsDemo implements Runnable{

    private String statement;

    public ThreadsDemo(String statement){
        this.statement =statement;
    }

    public void run(){
        for(int i = 0; i<statement.length();i++){
            System.out.print(" "+Thread.currentThread().getName());
            System.out.print(" " +statement.charAt(i));
            try{
               Thread.yield();
            Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
