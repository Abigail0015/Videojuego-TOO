import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chooseDifficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChooseDifficulty extends World
{

    Pointer point = new Pointer();
    int option;

    public ChooseDifficulty()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new Background(12),300,200);

        addObject(point,160,160);

    }

    public void act()
    {
        checkPointer();
    }

    private void checkPointer()
    {
        option = point.selector();
        switch(option){
            case 0: 
            Greenfoot.setWorld(new ChooseCharacter("FACIL"));  
            break;

            case 1:
            Greenfoot.setWorld(new ChooseCharacter("NORMAL"));      
            break;

            case 2:
            Greenfoot.setWorld(new ChooseCharacter("DIFICIL"));  
            break;

            case 3:
            Greenfoot.setWorld(new TitleScreen());
            break;
        }
    }
}