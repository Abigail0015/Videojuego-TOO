import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This function create Instruction 2 screen
 * 
 * @author (Abigail Espinoza Ibarra, Cristopher Pineda Martínez) 
 * @version (14 / 06 / 21)
 */
public class Instructions2 extends World
{
    Player2 p2;
    /**
     * Constructor for objects of class Instructions2.
     * 
     */
    public Instructions2(Player2 p2)
    {            
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.p2 = p2; 
        addObject(new Background(4),300,200);
        LocatePlayer();
    }
    
    public void act()
    {
        wallsCreator();
        if(Greenfoot.isKeyDown("enter")==true)
        {
            Greenfoot.setWorld(new MenuScreen());

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
    
    private void LocatePlayer()
    {

        p2.setGameMode("fourDirections",2);

        addObject(p2,465,200);
    }
}
