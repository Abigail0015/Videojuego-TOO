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
            if(gameMode != "chooseCharacter" && gameMode !="motionless")
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
                    shootArrow(2);
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
            /*if(checked == 1)
                return(5);
            else*/
                return(6);

        }
    }
}
