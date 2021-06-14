import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreScreen extends World
{
    Player1 p1;
    Player2 p2;
    FontText text = new FontText();
    FontText P1 = new FontText();
    FontText P2 = new FontText();
    /**
     * Constructor for objects of class ScoreScreen.
     * 
     */
    public ScoreScreen(Player1 p1,Player2 p2)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(10),300,200);
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public void act()
    {
        showScore();
    }
    public void showScore()
    {
        text.setText("Puntuacion Final ");
        addObject(text,300,108);
        P1.setText("Jugador 1: "+p1.score);
        addObject(P1,300,158);
        P2.setText("Jugador 2: "+p2.score);
        addObject(P2,300,208);
        showWinner();
        if(Greenfoot.isKeyDown("enter") == true )
        {
            Greenfoot.delay(20);
            Greenfoot.setWorld(new MenuScreen());
        }
    }
    
    public void showWinner()
    {
        if(p1.score > p2.score)
        {
            addObject(new Winner(),180,158);
        }
        else if(p1.score < p2.score)
        {
            addObject(new Winner(),180,208);
        }
    }
}











