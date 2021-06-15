import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World
{
    Pointer point = new Pointer();
    int option;
    /**
     * Constructor for objects of class MenuScreen.
     * 
     */
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        addObject(new Background(1),300,200);
        addObject(point,160,160);

    }

    public void act()
    {
        checkPointer();
    }

    private void checkPointer()
    {
        option = point.selector();
        switch(option){
            case 0: 
            Greenfoot.setWorld(new ChooseDifficulty());  
            break;

            case 1:
            Greenfoot.setWorld(new Instructions1());     
            break;

            case 2:
            Greenfoot.setWorld(new RecordsScreen());
            break;

            case 3:
            Greenfoot.setWorld(new TitleScreen());
            Greenfoot.stop();
            break;
        }
    }
}