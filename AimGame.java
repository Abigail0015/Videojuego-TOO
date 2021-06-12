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
        this.p1 = p1;
        this.p2 = p2;
        wallMaker();
        LocatePlayers();
        
    }
    
    public void wallMaker()
    {
        ArrayList<horWall> wallH = new ArrayList<horWall>();
        for(int i=0;i<20;i++)
        {
            wallH.add(new horWall());
            wallH.get(i).getImage().setTransparency(0);
        }
        addObject(wallH.get(0),0,335);
        addObject(wallH.get(1),100,335);
        addObject(wallH.get(2),200,335);
        addObject(wallH.get(3),300,335);
        addObject(wallH.get(4),400,335);
        addObject(wallH.get(5),500,335);
        addObject(wallH.get(6),600,335);
        addObject(wallH.get(7),0,270);
        addObject(wallH.get(8),100,270);
        addObject(wallH.get(9),200,270);
        addObject(wallH.get(10),300,270);
        addObject(wallH.get(11),400,270);
        addObject(wallH.get(12),500,270);
        addObject(wallH.get(13),600,270);
        
        ArrayList<vertWall> wallV = new ArrayList<vertWall>();
        for(int i=0;i<14;i++)
        {
            wallV.add(new vertWall());
            wallV.get(i).getImage().setTransparency(0);
        }
        
        addObject(wallV.get(0),0,0);
        addObject(wallV.get(1),0,100);
        addObject(wallV.get(2),0,200);
        addObject(wallV.get(3),0,300);
        addObject(wallV.get(4),0,400);
        addObject(wallV.get(5),0,500);
        addObject(wallV.get(6),0,600);
        addObject(wallV.get(7),600,0);
        addObject(wallV.get(8),600,100);
        addObject(wallV.get(9),600,200);
        addObject(wallV.get(10),600,300);
        addObject(wallV.get(11),600,400);
        addObject(wallV.get(12),600,500);
        addObject(wallV.get(13),600,600);
    }
    
    public void LocatePlayers()
    {
        p1.setGameMode(2,2);
        p2.setGameMode(2,2);
        p1.showAnimation(6);
        p2.showAnimation(6); 
        addObject(p1,50,300);
        addObject(p2,550,300);
    }
    
}











