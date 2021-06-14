import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends Actor
{
    int option;
    int counter = 10;
    /**
     * Act - do whatever the Pointer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pointer(){
        setImage("pointer.png");
        GreenfootImage image = getImage();
        image.scale(80,20);
    }

    public void act() 
    {
        selector();
    }  
    int state=0;
    public int selector()
    {
        boolean up = Greenfoot.isKeyDown("up");
        boolean down = Greenfoot.isKeyDown("down");
        boolean enter = Greenfoot.isKeyDown("enter");
        int x = getX();
        int y = getY();
        if(counter == 0)
        {
            if(up ==true && state !=0 && y >= 160 )
            {
                state--;
                setLocation(x,y-50);
            }
            if( down == true && state !=3 && y <310 )
            {
                state++;
                setLocation(x,y+50);
            }
            if( enter  == true )
            {
                return state;

            }
        }counter =(counter + 1) % 60;
        
        if(!up && !down && !enter)
        {
            counter =0;
        }
        return -1;
    }
}


