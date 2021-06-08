import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class AimGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AimGame extends World
{
    Player1 p1;
    Player2 p2;
    /**
     * Constructor for objects of class AimGame.
     * 
     */
    public AimGame(Player1 p1, Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new Background(6),300,200);
        this.p1 = p1;
        this.p2 = p2;
        wallMaker();
        locatePlayers();
        
    }
    
    public void wallMaker()
    {
        addObject(new BigHor(),150,330);
        addObject(new BigHor(),450,330);
        addObject(new BigHor(),150,270);
        addObject(new BigHor(),450,270);
        addObject(new BigVert(),5,150);
        addObject(new BigVert(),5,450);
        addObject(new BigVert(),595,150);
        addObject(new BigVert(),595,450);
    }
    
    public void locatePlayers()
    {
        p1.setGameMode(2,2);
        p2.setGameMode(2,2);
        p1.showAnimation(6);
        p2.showAnimation(6); 
        addObject(p1,50,300);
        addObject(p2,550,300);
    }
    
}











