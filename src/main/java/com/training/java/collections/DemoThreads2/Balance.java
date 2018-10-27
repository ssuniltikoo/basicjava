package com.training.java.collections.DemoThreads2;

public class Balance {
    private   int balance;

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public void Withdraw(int amount){

         balance-=amount;
        //System.out.println("Withdrawal amount is "+amount +" BALANce is "+balance);
    }


    void delay(){
        try{
            Thread.sleep(10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
