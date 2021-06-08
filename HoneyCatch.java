import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class HoneyCatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HoneyCatch extends World
{
    private Player1 p1;
    private Player2 p2;
    private int speed;
    private int numHoney=0;
    int numBee=0;
    private int count=0;
    /**
     * Constructor for objects of class HoneyCatch.
     * 
     */
    public HoneyCatch(Player1 p1, Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(7),300,200);
        this.p1 = p1;
        this.p2 = p2;
        locatePlayers();
        wallsCreator();
    }
    public void act(){
        addItems();
        addEnemies();
    }
    public void addItems()
    {
        if(numHoney <= 4){
            int positions = Greenfoot.getRandomNumber(4);
            switch(positions)
            {
                case 0:
                    addObject(new Honey(),45,200);
                    break;
                case 1:
                    addObject(new Honey(),220,200);
                    break;
                case 2:
                    addObject(new Honey(),390,200);
                    break;
                case 3: 
                    addObject(new Honey(),535,200);
                    break;
            }
            numHoney++;
            count++;
        }
    }
    
    public void addEnemies()
    {
        int par =count;
        par%=count;
        if(numBee <= 2 && count == 1 ){
            int positions = Greenfoot.getRandomNumber(3);
            switch(positions)
            {
                case 0:
                    addObject(new Bee(),45,200);
                    break;
                case 1:
                    addObject(new Bee(),220,200);
                    break;
                case 2:
                    addObject(new Bee(),390,200);
                    break;
                case 3: 
                    addObject(new Bee(),535,200);
                    break;
            }
            numBee++;
        }
    }
    
    public int getRandom(int start, int end)
    {
        int number = Greenfoot.getRandomNumber(end-start+1);
        return number+start;
    }
    
    
    public void lessHoney()
    {
        numHoney--;
    }
    
    public void wallsCreator()
    {
        addObject(new BigHor(),150,330);
        addObject(new BigHor(),450,330);
        addObject(new BigHor(),150,270);
        addObject(new BigHor(),450,270);
        //Vertical Walls
        addObject(new BigVert(),0,300);
        addObject(new BigVert(),695,300);        
    }
    
    public void locatePlayers()
    {
        p1.setGameMode(3,2);
        p2.setGameMode(3,2);
        p1.showAnimation(6);
        p2.showAnimation(6);
        addObject(p1,100,300);
        addObject(p2,500,300);
    }
}






