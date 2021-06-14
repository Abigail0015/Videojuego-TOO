import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This function create the Choose character screen
 * 
 * @author (Abigail Espinoza Ibarra, Cristopher Pineda Martínez) 
 * @version (14 / 06 / 21)
 */

public class ChooseCharacter extends World
{
    Player1 p1 = new Player1(1,"chooseCharacter",7);
    Player2 p2 = new Player2(2,"chooseCharacter",7);
    String difficulty;
    public ChooseCharacter(String difficulty) 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(2),300,200);
        locatePlayers();
        this.difficulty = difficulty;
    }

    public void act() 
    {
        if(p1.getChecked()== 1 && p2.getChecked()== 1 )
        {
            Greenfoot.setWorld(new ColorTheFloor(p1,p2, difficulty));
            //Greenfoot.setWorld(new TurnImage(p1,p2, difficulty));

        }
    } 

    private void locatePlayers()
    {
        addObject(p1,135,230);
        addObject(p2,465,230);

    }

}
