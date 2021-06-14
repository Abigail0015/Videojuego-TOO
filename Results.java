
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Results here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Results extends World
{
    String roomName;
    String difficulty;
    Player1 p1;
    Player2 p2;
    FontText text = new FontText();
    FontText P1 = new FontText();
    FontText P2 = new FontText();
    int score1;
    int score2;

    public Results(String roomName,Player1 p1, Player2 p2,int score1,int score2, String difficulty)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(9),300,200);
        this.roomName = roomName;
        this.score1 = score1;
        this.score2 = score2;
        this.p1 = p1;
        this.p2 = p2;
        this.difficulty = difficulty;
    }

    private void sumFinalScore()
    {
        p1.score += score1;
        p2.score += score2;
    }
    public void act() 
    {
        showScore();
        if(Greenfoot.isKeyDown("enter") == true)
        {
            switch(roomName)   
            {  
                case "ColorTheFloor":
                    Greenfoot.setWorld(new ColorTheFloor(p1,p2,difficulty));
                    break;  
                case "AimGame":  
                    Greenfoot.setWorld(new AimGame(p1,p2,difficulty));
                    break;
                case "HoneyCatch": 
                    Greenfoot.setWorld(new HoneyCatch(p1,p2,difficulty));
                    break;
                case "TurnImage": 
                    Greenfoot.setWorld(new TurnImage(p1,p2,difficulty)); 
                    break;
                case "ScoreScreen":
                    Greenfoot.setWorld(new ScoreScreen(p1,p2));
                    break;
            }  
        }
    }  

    public void showScore()
    {
        text.setText("  Puntuacion ");
        addObject(text,300,158);
        P1.setText("Jugador 1: "+score1);
        addObject(P1,300,208);
        P2.setText("Jugador 2: "+score2);
        addObject(P2,300,258);
        showWinner();
    }
    
    public void showWinner()
    {
        if(p1.score > p2.score)
        {
            addObject(new Winner(),180,208);
        }
        else if(p1.score < p2.score)
        {
            addObject(new Winner(),180,258);
        }
        else if(p1.score == p2.score)
        { 
            addObject(new Winner(),180,258);
            addObject(new Winner(),180,208);
        }
    }
}




