import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class menuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menuScreen extends World
{
    /**
     * Constructor for objects of class menuScreen.
     * 
     */
    public menuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Pointer point = new Pointer();
        addObject(point,160,160);
        point.selector();
    }
}
