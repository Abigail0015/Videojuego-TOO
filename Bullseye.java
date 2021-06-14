import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullseye here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullseye extends Actor
{
    GreenfootImage bullseye = new GreenfootImage("images/Enemies/bullseye.png");
    String direction;
    
    public Bullseye(String direction)
    {
        setImage(bullseye);
        this.direction = direction;
    }
    public void act() 
    {
        moveBullseye();
    }   
    
    private void moveBullseye()
    {
        switch(direction)
        {
            case "left":
                 setLocation(getX() - 3, getY()) ;
            break;
            case "right":
                setLocation(getX() + 3, getY()) ;
            break;
        }
    }
    
    public void deleteBullseye()
    {
        
           getWorld().removeObject(this); 

    }
    
    
}
