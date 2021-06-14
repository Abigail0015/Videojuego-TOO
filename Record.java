import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.awt.FileDialog;
import java.io.*;
import java.util.ArrayList;
public class Record extends Actor
{
    String link = "images/records.txt";
    String records[] = new String[6];

    public Record()
    {
         readRecords(link,records);
    }

    public void act() 
    {
        // Add your action code here.
    }    
    
    public String getRecord(int counter)
    {
        return records[counter];
    }
    
    private void readRecords(String link,String array[])
    {
        String file = link;
        int counter = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                readFiles(counter,line,array);
                array[counter] = line;
                counter++;
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }

    private void readFiles(int counter, String line,String array[])
    {

        array[counter] = line;

    }

    public void writeRecords(String array[])
    {
        FileWriter file = null;
        PrintWriter pw =null;
        try{ 
            file = new FileWriter(link);
            pw = new PrintWriter(file);
            for (int counter=0; counter< 6; counter++)
            {
                //System.out.println(counter +"-"+ array[counter]);

                pw.println(array[counter]);

            }
        }catch (Exception e0){
            e0.printStackTrace();
        }
        finally{
            try{
                if (null!=file){
                    file.close();
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }

    }
}