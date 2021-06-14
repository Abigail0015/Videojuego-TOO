import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turn extends Actor
{
    int status;
    /**
     * Act - do whatever the Turn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Turn(int status)
    {
        this.status = status;
        setTurning(status);
    }
    
    public void act() 
    {
        
    }    
    
    public void setMovement( int sig,Marcador setter)
    {
        int x = setter.getX();
        int y = setter.getY();
        if( sig == 1)
        {
            setter.setLocation(x-10,y);
            if( x <= 150 )
            {
                setter.setLocation(x+10,y);
            }
        }
        if( sig == 2 )
        {
            setter.setLocation(x+10,y);
            if( x >= 300 )
            {
                setter.setLocation(x-10,y);
            }
        }
        if( sig == 3 )
        {
            setter.setLocation(x,y-10);
            if( y < 100 )
            {
                setter.setLocation(x,y+10);
            }
        }
        if( sig == 4 )
        {
            setter.setLocation(x,y+10);
            if( y >= 250 )
            {
                setter.setLocation(x,y-10);
            }
        }
        else sig =5;
    }
    public void setTurning(int status)
    {
        switch(status)
        {
            case 1:
                setImage("images/Turning/hongo_arr_der.png");
                break;
            case 2:
                setImage("images/Turning/hongo_arr_izq.png");
                break;
            case 3:
                setImage("images/Turning/hongo_abaj_izq.png");
                break;
            case 4:
                setImage("images/Turning/hongo_abaj_der.png");
                break;
            case 5:
                setImage("images/Turning/Ball_arr_izq.png");
                break;
            case 6:
                setImage("images/Turning/Ball_arr_der.png");
                break;
            case 7:
                setImage("images/Turning/Ball_ab_izq.png");
                break;
            case 8:
                setImage("images/Turning/Ball_ab_der.png");
                break;
        }
        GreenfootImage img = getImage();
        img.scale(50,50);
    }
}













