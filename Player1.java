import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player
{
    
    public Player1(int numberCharacter,String gameMode,int size)
    {
        this.gameMode = gameMode;
        this.numberCharacter = numberCharacter;
        this.size = size;
        getPlayer(1);
    }

    public void act() 
    {
        direction = handleDirection();
        showAnimation(direction);
        checkHoney();
    } 

    public int handleDirection()
    {
        boolean up = Greenfoot.isKeyDown("w");
        boolean down = Greenfoot.isKeyDown("s");
        boolean left = Greenfoot.isKeyDown("a");
        boolean right = Greenfoot.isKeyDown("d");
        boolean button = Greenfoot.isKeyDown("q");

        if(right)
        {
            checkerH("right");
            if(gameMode != "chooseCharacter" && gameMode !="motionless")
            {
                checkerH("right");
                setLocation(getX() + 5, getY()) ;
                return(1);
            }
            else if(gameMode == "chooseCharacter")
            {
                changeCharacter(1);
                return(6);
            }
            return(6);
        }
        else if(left )
        {  
            checkerH("left");
            if(gameMode != "chooseCharacter" && gameMode !="motionless")
            {
                setLocation(getX() - 5, getY()) ;
                return(2);
            }
            else if(gameMode == "chooseCharacter")
            {
                changeCharacter(2);
                return(6);
            }
            return(6);

        }
        else if(down)
        {
            checkerH("down");
            if(gameMode == "fourDirections")
            {
                setLocation(getX(), getY() + 5) ;
                return(3);
            }
            else if(gameMode == "chooseCharacter")
            {
                return(6);
            }
            return(6);
        }
        else if(up)
        {
            checkerH("up");
            if(gameMode == "fourDirections")
            {
                setLocation(getX(), getY() - 5) ;
                return(4);
            }
            else if(gameMode == "chooseCharacter")
            {

                return(6);
            }
            return(6);
        }
        else if(button)
        {
            if(gameMode != "chooseCharacter" && gameMode !="motionless")
            {
                if(activeShoot == true)
                    shootArrow(1);
                return(5);
            }    
            else if(gameMode == "chooseCharacter")
            {

                if(checked == 0)
                    checked = 1;
                else if(checked == 1)
                    checked =0;
                return(5);
            }
            return(6);

        }
        else
        {
            return(6);

        }

    }

    
}
