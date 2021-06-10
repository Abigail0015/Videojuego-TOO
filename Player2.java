import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Player
{
    public Player2(int numberCharacter,String gameMode, int size)
    {
        this.gameMode = gameMode;
        this.numberCharacter = numberCharacter;
        this.size = size;
        getPlayer(2);
    }

    public void act() 
    {

        direction = handleDirection();

        showAnimation(direction);
    }    

    public int handleDirection()
    {
        boolean up = Greenfoot.isKeyDown("up");
        boolean down = Greenfoot.isKeyDown("down");
        boolean left = Greenfoot.isKeyDown("left");
        boolean right = Greenfoot.isKeyDown("right");
        boolean button = Greenfoot.isKeyDown("p");

        if(right)
        {
            checkerH("right");
<<<<<<< HEAD
            if(gameMode != "chooseCharacter" && gameMode !="motionless")
=======
            if(gameMode != 0)
>>>>>>> master
            {
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
<<<<<<< HEAD
            if(gameMode != "chooseCharacter" && gameMode !="motionless")
=======
            if(gameMode != 0)
>>>>>>> master
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
<<<<<<< HEAD
            if(gameMode == "fourDirections")
=======
            if(gameMode != 0)
>>>>>>> master
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
<<<<<<< HEAD
            if(gameMode == "fourDirections")
=======
            if(gameMode != 0)
>>>>>>> master
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
            if(gameMode != "chooseCharacter"&& gameMode !="motionless")
                return(5);
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
            if(checked == 1)
                return(5);
            else
                return(6);

        }
    }
}
