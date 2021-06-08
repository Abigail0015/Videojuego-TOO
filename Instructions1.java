import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Instructions1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions1 extends World
{
    Player1 p1;
    Player2 p2 = new Player2(6,0,7);
    /**
     * Constructor for objects of class Instructions1.
     * 
     */
    public Instructions1(Player1 p1)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.p1 = p1;
        addObject(new Background(3),300,200);
        locatePlayer();
    }
   
    public void act()
    {
        wallsCreator();
        if(Greenfoot.isKeyDown("enter") == true )
        {
            Greenfoot.setWorld(new Instructions2(p2));
        }
    }
    
    public void wallsCreator()
    {
        addObject(new horWall(),405,165);
        addObject(new horWall(),538,165);
        addObject(new horWall(),405,242);
        addObject(new horWall(),538,242);
        addObject(new horWall(),450,120);
        addObject(new horWall(),450,280);
        //Vertical walls
        addObject(new vertWall(),445,143);
        addObject(new vertWall(),445,275);
        addObject(new vertWall(),490,143);
        addObject(new vertWall(),490,275);
        addObject(new vertWall(),360,200);
        addObject(new vertWall(),530,200);
    }
    
    public void locatePlayer()
    {
        p1.setGameMode(5,2);
        addObject(p1,465,200);
    }
}