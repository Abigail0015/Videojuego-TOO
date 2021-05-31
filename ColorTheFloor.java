import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ColorTheFloor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColorTheFloor extends World
{
    Player1 p1;
    Player2 p2; 
    /**
     * Constructor for objects of class ColorTheFloor.
     * 
     */
    public ColorTheFloor(Player1 p1, Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.p1 = p1;
        this.p2 = p2;
        p1.setGameMode(1,2);
        p2.setGameMode(1,2);
        locatePlayers();

    }

    private void locatePlayers()
    {
        p1.showAnimation(6);
        p2.showAnimation(6);
        addObject(p1,135,230);
        addObject(p2,465,230);

    }
}
