import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChooseCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChooseCharacter extends World
{
    Player1 p1 = new Player1(1,"chooseCharacter",7);
    Player2 p2 = new Player2(2,"chooseCharacter",7);

    public ChooseCharacter() 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        locatePlayers();
    }

    public void act() 
    {

        if(p1.getChecked()== 1 && p2.getChecked()== 1 )
        {

            Greenfoot.setWorld(new AimGame(p1,p2));

            //Greenfoot.setWorld(new ColorTheFloor(p1,p2)); 
        }
    } 

    private void locatePlayers()
    {
        addObject(p1,135,230);
        addObject(p2,465,230);

    }

}
