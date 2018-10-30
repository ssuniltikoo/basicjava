package com.training.java.collections.FileManager;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public  class TextFileOperations implements java.io.Serializable
{
    /*String filePath = null;
    String fileName = null;
    File file = null;*/

    public TextFileOperations(){}

   /* public TextFileOperations(String filePath, String fileName){
        this.filePath = filePath;
        this.fileName = fileName;
        file = new File(this.filePath+"\\"+this.fileName);
    }*/

    public boolean createFile(String path, String FileName) {
        String pathWithFileName = path+"\\"+FileName;
        boolean flag = false;
        File f = new File(pathWithFileName);
        try{
            if(!f.exists())
                f.createNewFile();
            flag = true;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

   /* public boolean createFile() {
        boolean flag = false;
        try{
            if(!file.exists())
                file.createNewFile();
            flag = true;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public void deleteFile() {
        if(file.exists()){
            file.delete();

        }

    }*/

    /*public String readFromFile() {
         //StringBuffer strBuf = new StringBuffer();
        String data ="";
        try{
            Reader reader = new FileReader(file);
            BufferedReader bufferedReader =  new BufferedReader(reader);
            String temp = null;
            while((temp =  bufferedReader.readLine()) !=null){
                data += temp;

            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            e.getMessage();
        }
        return data;
    }*/

    /*public void writeToFile(String str) {
        try{
            Writer writer = new FileWriter(file);
            BufferedWriter bufWriter =new BufferedWriter(writer);
            bufWriter.write(str);
            bufWriter.flush();
            bufWriter.close();
            writer.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }*/

    public void writeToFile(String FileNameWithPath,String str) {
        File fi = new File(FileNameWithPath);
        if(!fi.exists()) {
            try {
                fi.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try{
            Writer writer = new FileWriter(fi);
            BufferedWriter bufWriter =new BufferedWriter(writer);
            bufWriter.write(str);
            bufWriter.flush();
            bufWriter.close();
            writer.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int AddAllDataInFile(String FileNameWithPath){
        int sum = 0;
        File f = new File(FileNameWithPath);
        try{
            if(f.exists()) {
                Reader reader = new FileReader(f);
                BufferedReader bufread = new BufferedReader(reader);
                String data = null;
                while ((data = bufread.readLine()) != null) {
                    String[] temp = data.split(" ");
                    for (String t : temp) {
                        t.trim();
                        //Pattern pattern = Pattern.compile("[]0-9]+");
                        //Matcher matcher = pattern.matcher(t);
                        if (t.matches("[0-9]+")) {
                            sum += (Integer.parseInt(t));
                        }
                    }
                }
            }else
                throw new FileNotFoundException(FileNameWithPath+" File Not Found. Please check..");
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch(EOFException e){
            System.out.println(e.getMessage());
        }catch(IOException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return sum;
    }

}
