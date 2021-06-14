import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    GreenfootImage floor = new GreenfootImage("images/Floor/floor_1.png");
    String type = "NORMAL";

    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Floor()
    {   
        floor.scale(floor.getWidth() * 2 ,floor.getHeight() * 2);
        setImage(floor);
    }

    public void act() 
    {

    }  
    
    public String getType()
    {
        return(type);
    }
    
    public String changeColor(String color)
    {
        if(color == "BLUE")
        {
            floor = new GreenfootImage("images/Floor/floor_1_Blue.png");
            type = "BLUE";
        }
        else if(color == "RED")
        {
            floor = new GreenfootImage("images/Floor/floor_1_Red.png"); 
            type = "RED";
        }
        else if(color == "NORMAL")
        {
            floor = new GreenfootImage("images/Floor/floor_1.png"); 
            type = "NORMAL";
        }
        floor.scale(floor.getWidth() * 2 ,floor.getHeight() * 2);

        setImage(floor);

        return(type);
    }
}

