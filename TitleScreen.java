import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This function create Title screen
 * 
 * @author (Abigail Espinoza Ibarra, Cristopher Pineda Martínez) 
 * @version (14 / 06 / 21)
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
        }
    }    

    private void beginning()
    {
        //Greenfoot.playSound("sounds/Music/titleTheme.wav");
        addObject(new Background(0),300,200);
    }

    
}
