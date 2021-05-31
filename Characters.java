import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.awt.FileDialog;
import java.io.*;
import java.util.ArrayList;
/**
 * Write a description of class Characters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Characters extends Actor
{
    String characterLocations = "images/CharacterLocations.txt";
    String imageLocations[] = new String[5];
    String images[] = new String[9];
    int size;
    int numberCharacter = 0;

    public Characters()
    {
        generateCharacters(characterLocations, imageLocations);
        generateCharacters(imageLocations[numberCharacter],images);

    }

    public void act() 
    {

    }  

    public void setNumbercharacter(int numberCharacter)
    {
        this.numberCharacter = numberCharacter;
        generateCharacters(imageLocations[numberCharacter],images);
    }

    private void generateCharacters(String link,String array[])
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

        //System.out.println(line);
        array[counter] = line;

    }

    public String getSprites(int counter)
    {
        return(images[counter]);
    }

}
/*

private void readFiles(String file)
{
int counter = 0;
try(BufferedReader br = new BufferedReader(new FileReader(file))) 
{
String line;
while ((line = br.readLine()) != null) {
System.out.println(line);
imageLocations[counter] = line;
counter++;
}
}
catch (IOException e) {
System.out.println("An error occurred.");
e.printStackTrace();
}
}*/

