import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    GreenfootImage arrow = new GreenfootImage("images/Objects/arrow.png");
    int propiety;

    public Arrow(int propiety)
    {
        this.propiety = propiety;
        setImage(arrow);
    }

    public void act() 
    {
        moveArrow();
        arrowHitBullseye();

    }    

    private void moveArrow()
    {

        setLocation(getX(), getY() - 8) ;

    }

    public int setPropiety()
    {
        return propiety;
    }

    public  Bullseye  arrowHitBullseye()
    {
        Bullseye bullseye = (Bullseye)getOneIntersectingObject(Bullseye.class);

        if(bullseye!=null)
        {
            return  bullseye ;
        } 
        return null;
    }
}
