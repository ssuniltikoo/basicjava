package com.training.java.collections.DemoThreads2;

public class MainThread {

    public static void main(String[] args) {
        try{
             Balance b = new Balance();
             b.setBalance(15);
            /*DemoThread d2 = new DemoThread(1);
            DemoThread d3 = new DemoThread(2);
            DemoThread d4 = new DemoThread(3);
            DemoThread d5 = new DemoThread(1);*/
            Thread[] threads = new Thread[10];
            int amount= 10;
            for(int i = 1 ; i<=2;i++){
                DemoThread d = new DemoThread(amount,b);
                threads[i]= new Thread(d);
                threads[i].start();

            }
            for(Thread t:threads){
                t.join();
            }
            /*d1.run();
            d2.run();
            d3.run();
            d4.run();
            d5.run();*/
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
