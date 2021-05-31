import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player
{
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player1(int numberCharacter,int gameMode,int size)
    {
        this.gameMode = gameMode;
        this.numberCharacter = numberCharacter;
        this.size = size;
    }

    public void act() 
    {

        direction = handleDirection();
        showAnimation(direction);
    } 

    public int handleDirection()
    {
        boolean up = Greenfoot.isKeyDown("w");
        boolean down = Greenfoot.isKeyDown("s");
        boolean left = Greenfoot.isKeyDown("a");
        boolean right = Greenfoot.isKeyDown("d");
        boolean button = Greenfoot.isKeyDown("g");

        if(right)
        {
            if(gameMode != 0)
            {
                setLocation(getX() + 5, getY()) ;
                return(1);
            }
            else
            {
                changeCharacter(1);
                return(6);
            }

        }
        else if(left )
        {  
            if(gameMode != 0)
            {
                setLocation(getX() - 5, getY()) ;
                return(2);
            }
            else
            {
                changeCharacter(2);
                return(6);
            }

        }
        else if(down)
        {

            if(gameMode != 0)
            {
                setLocation(getX(), getY() + 5) ;
                return(3);
            }
            else
            {
                return(6);
            }
        }
        else if(up)
        {
            if(gameMode != 0)
            {
                setLocation(getX(), getY() - 5) ;
                return(4);
            }
            else
            {

                return(6);
            }
        }
        else if(button)
        {
            if(gameMode != 0)
                return(5);
            else
            {

                if(checked == 0)
                    checked = 1;
                else if(checked == 1)
                    checked =0;

                return(5);
            }

        }
        else
        {
            if(checked == 1)
                return(5);
            else
                return(6);

        }

    }
}
