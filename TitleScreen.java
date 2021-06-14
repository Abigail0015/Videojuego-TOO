import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
 
        super(600, 400, 1);
        beginning();
    }

    public void act() 
    {
        if(Greenfoot.isKeyDown("enter") == true)
        {
            Greenfoot.setWorld(new MenuScreen());
            Greenfoot.setWorld(new MenuScreen());
        }
    }    

    private void beginning()
    {
        //Greenfoot.playSound("sounds/Music/titleTheme.wav");

    }

    
}
