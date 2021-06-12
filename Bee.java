import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bee()
    {
        setImage("images/Enemies/bee.png");
        GreenfootImage images = getImage();
        images.scale(15,15);
    }
    public void act()
    {
        movement();
    }
    public void movement()
    {
        int speed=1;
        int x = this.getX();
        int y = this.getY();
        setLocation(x,y+speed);
        if(y >= 330 )
        {
            HoneyCatch game = (HoneyCatch) getWorld();
            game.removeObject(this);
        } 
    }
}

