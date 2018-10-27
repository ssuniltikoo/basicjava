package com.training.java.collections.DemoThreads2;

public class DemoThread implements Runnable{
   final Balance account;

    private int withdrawal;

    public DemoThread(int withdrawal, Balance account){
        this.withdrawal =withdrawal;
        this.account = account;
    }

    public   void run() {
        delay();
           // synchronized (account) {
                if(account.getBalance()>withdrawal){
                    account.Withdraw(withdrawal);
                    System.out.println(" Money deducted is " + withdrawal + " Balance after money deducted is " + account.getBalance() + " Tran.done by " + Thread.currentThread().getName());
                }else
                    System.out.println("Insufficient balance . balance is" + account.getBalance() + " Tran.done by " + Thread.currentThread().getName());
          // }

       delay();
        /*if (account.getBalance() <0)
            throw new ArithmeticException("Balnce cannnot be less than zero");*/

    }

    void delay(){
        try{
            Thread.sleep(10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
