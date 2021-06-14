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
    int velocity;
    
    public Bullseye(String direction,int velocity)
    {
        setImage(bullseye);
        this.direction = direction;
        this.velocity = velocity;
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
                 setLocation(getX() - velocity, getY()) ;
            break;
            case "right":
                setLocation(getX() + velocity, getY()) ;
            break;
        }
    }
    
    public void deleteBullseye()
    {
        
           getWorld().removeObject(this); 

    }
    
    
}
