import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Honey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Honey extends Actor
{
    /**
     * Act - do whatever the Honey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
    }
    public void movement()
    {
        int speed=2;
        int x = this.getX();
        int y = this.getY();
        setLocation(x,y+speed);
        if(y >= 330 )
        {
            HoneyCatch game = (HoneyCatch) getWorld();
            game.removeObject(this);
            game.lessHoney();
        } 
    }
    
}
