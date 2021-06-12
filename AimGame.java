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
    int scoreP1 = 0;
    int scoreP2 = 0;
    Timer timer = new Timer(10,true);
    Timer changeScreenTimer = new Timer(4,false);
    FontText timeOver = new FontText(); 

    public AimGame(Player1 p1, Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(6),300,200);
        this.p1 = p1;
        this.p2 = p2;
        wallMaker();
        LocatePlayers();
        
    }
    public void act()
    {
        if(timer.getTimer() == 0)
        {
           
            p1.setGameMode("motionless",2);
            p2.setGameMode("motionless",2);
            endSequence();

        }
        else
        {
            addObject(timer,300,25);
        }
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
    
    public void LocatePlayers()
    {
        p1.setGameMode("twoDirections",2);
        p2.setGameMode("twoDirections",2);
        p1.showAnimation(6);
        p2.showAnimation(6); 
        addObject(p1,50,300);
        addObject(p2,550,300);
    }
    
    private void endSequence()
    {
        
        timeOver.imageText("images/Backgrounds/timeOver.png");
        addObject(timeOver,300,200);
        addObject(changeScreenTimer,1000,1000);
        if(changeScreenTimer.getTimer() <= 0)
        {
            Greenfoot.setWorld(new Results("HoneyCatch",p1,p2,scoreP1,scoreP2));
        }
    }
    
}
