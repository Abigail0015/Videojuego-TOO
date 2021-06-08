import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class turnImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurnImage extends World
{
    Player1 p1;
    Player2 p2;
    /**
     * Constructor for objects of class turnImage.
     * 
     */
    public TurnImage(Player1 p1,Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(8),300,200);
        this.p1 = p1;
        this.p2 = p2;
        locatePlayers();
    }
    
    public void locatePlayers()
    {
        p1.setGameMode(8,2);
        p2.setGameMode(8,2);
        p1.showAnimation(6);
        p2.showAnimation(6);
        addObject(p1,15,15);
        addObject(p2,590,390);
    }
}












