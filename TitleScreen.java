import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
<<<<<<< HEAD

=======
    Player1 p1 = new Player1(5,0,7);
>>>>>>> master
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
<<<<<<< HEAD
            Greenfoot.setWorld(new MenuScreen());
=======
            Greenfoot.setWorld(new menuScreen());
>>>>>>> master
        }
    }    

    private void beginning()
    {
        //Greenfoot.playSound("sounds/Music/titleTheme.wav");

    }

    
}
