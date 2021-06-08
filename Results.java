import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Results here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Results extends World
{
    String roomName;
    Player1 p1;
    Player2 p2;

    public Results(String roomName,Player1 p1, Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.roomName = roomName;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void act() 
    {
        if(Greenfoot.isKeyDown("enter") == true)
        {
            switch(roomName)   
        {  
            case "ColorTheFloor": Greenfoot.setWorld(new ColorTheFloor(p1,p2)); break;  
            case "AimGame": Greenfoot.setWorld(new AimGame(p1,p2));break;
            case "Juego 3": Greenfoot.setWorld(new MenuScreen()); break;
            case "Juego 4": Greenfoot.setWorld(new MenuScreen()); break;


        }  
            
        }
    }  

    
}
