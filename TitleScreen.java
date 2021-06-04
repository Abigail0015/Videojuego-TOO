import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Player1 p1 = new Player1(5,0,7);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        beginning();
    }

    public void act() 
    {
        if(Greenfoot.isKeyDown("enter") == true)
        {
            Greenfoot.setWorld(new menuScreen());
        }
    }    

    private void beginning()
    {
        //Greenfoot.playSound("sounds/Music/titleTheme.wav");

    }

    /*private void showText()
    {
    String text;
    String text2 = character.getLink();
    showText("HI:"+text2, 200 , 300);

    for(int counter = 0;counter < 5; counter++)
    {
    text = character.getText(counter);
    showText("SCORE: "+String.valueOf(text),100,(40 + (20*counter)));
    }
    }*/
}
