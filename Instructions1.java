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
<<<<<<< HEAD
    Player2 p2 = new Player2(6,"fourDirections",7);
=======
    Player2 p2 = new Player2(6,0,7);
>>>>>>> master
    /**
     * Constructor for objects of class Instructions1.
     * 
     */
    public Instructions1(Player1 p1)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.p1 = p1;
        addObject(new Background(),300,200);
        LocatePlayer();
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
        ArrayList<horWall> wallH = new ArrayList<horWall>();
        ArrayList<vertWall> wallV = new ArrayList<vertWall>(); 
        for(int i=0;i<7;i++)
        {
            wallH.add(new horWall());
            wallH.get(i).getImage().setTransparency(0);
        }
        for(int i=0;i<7;i++)
        {
            wallV.add(new vertWall());
            wallV.get(i).getImage().setTransparency(0);
        }
        addObject(wallH.get(0),405,165);
        addObject(wallH.get(1),538,165);
        addObject(wallH.get(2),405,242);
        addObject(wallH.get(3),538,242);
        addObject(wallH.get(4),450,120);
        addObject(wallH.get(5),450,280);
        
        //Vertical walls
        addObject(wallV.get(0),445,143);
        addObject(wallV.get(1),445,275);
        addObject(wallV.get(2),490,143);
        addObject(wallV.get(3),490,275);
        addObject(wallV.get(4),360,200);
        addObject(wallV.get(5),530,200);
    }
    
    public void LocatePlayer()
    {
<<<<<<< HEAD
        p1.setGameMode("fourDirections",2);
=======
        p1.setGameMode(5,2);
>>>>>>> master
        addObject(p1,465,200);
    }
}











