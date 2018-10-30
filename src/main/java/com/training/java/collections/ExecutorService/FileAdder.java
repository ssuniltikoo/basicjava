package com.training.java.collections.ExecutorService;
import com.training.java.collections.FileManager.*;

import java.io.*;

public class FileAdder implements Runnable{

    TextFileOperations tf = null;
    String directoryPath = "C:\\Users\\shreeram\\Desktop\\adder";

    private String fileNames[] = new String[5];
    private String resultfile[]= new String[5];

    public FileAdder(String [] fileNames, String [] resultfile){
        int size=fileNames.length;
        //fileNames = new String[size];
        //resultfile = new String[size];
        for(int i=0;i<size;i++) {
            this.fileNames[i] = fileNames[i];
            this.resultfile[i]=resultfile[i];
        }
    }
    public FileAdder(){
    }
    String inputfile,outputfile;
    public FileAdder(String inputfile, String outputfile){
       this.inputfile = inputfile;
       this.outputfile=outputfile;
    }


    public void AddDataFromFile(String inputfile, String outputfile){
        TextFileOperations tf = new TextFileOperations();
        int sum = tf.AddAllDataInFile(inputfile);
        tf.writeToFile(outputfile,(String.valueOf(sum)));
    }

    public void AddDataFromFile(){
        TextFileOperations tf = new TextFileOperations();
        int sum = tf.AddAllDataInFile(this.inputfile);
        tf.writeToFile(this.outputfile,(String.valueOf(sum)));
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
       /* try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(Thread.currentThread().getName());
        AddDataFromFile();
        Thread.yield();
       /* try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
