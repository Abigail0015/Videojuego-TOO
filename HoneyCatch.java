import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class HoneyCatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HoneyCatch extends World
{
    private Player1 p1;
    private Player2 p2;
    int scoreP1 = 0;
    int scoreP2 = 0;
    private int speed;
    private int numHoney=0;
    int numBee=0;
    private int count=0;
    Timer timer = new Timer(60,true);
    Timer changeScreenTimer = new Timer(4,false);
    FontText scoreP1Text = new FontText();   
    FontText scoreP2Text = new FontText();
    FontText timeOver = new FontText(); 
    String difficulty;
    int enemyProbability;
    /**
     * Constructor for objects of class HoneyCatch.
     * 
     */
    public HoneyCatch(Player1 p1, Player2 p2,String difficulty)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(7),300,200);
        this.p1 = p1;
        this.p2 = p2;
        locatePlayers();
        wallsCreator();
        this.difficulty = difficulty;

        EnemiesDifficulty();
    }
    public void act(){
        if(timer.getTimer() == 0 )
        {
            p1.setGameMode("motionless",2);
            p2.setGameMode("motionless",2);
            endSequence();
        }
        else{
            addObject(timer,300,25);
            checkScore();
            showScore(p1.setPlayer(),scoreP1,scoreP2Text,100);
            showScore(p2.setPlayer(),scoreP2,scoreP1Text,500);
            addElements();
        }
    }
    public void checkScore()
    {
        scoreP1 = p1.checkHoney();
        scoreP2 = p2.checkHoney();
    }
    
    private void addElements()
    {
        int probability =  Greenfoot.getRandomNumber(enemyProbability);
        
        if(probability + 1  == enemyProbability)
        {
            addEnemies();
        }
        else
        {
            addHoney();
        }
    }
    private void EnemiesDifficulty()
    {
        switch(difficulty)
        {
            case "FACIL":
                enemyProbability = 9;
            break;
            case "NORMAL":
                enemyProbability = 6;
            break;
            case "DIFICIL":
                enemyProbability = 3;
            break;
        }
    }

    private void addHoney()
    {
        if(numHoney <= 4){
            int positions = Greenfoot.getRandomNumber(4);
            switch(positions)
            {
                case 0:
                    addObject(new Honey(),45,200);
                    break;
                case 1:
                    addObject(new Honey(),220,200);
                    break;
                case 2:
                    addObject(new Honey(),390,200);
                    break;
                case 3: 
                    addObject(new Honey(),535,200);
                    break;
            }
            numHoney++;
            count++;
        }
    }
    
    private void addEnemies()
    {
        int par =count;
        par%=count;
        if(numBee <= 2 && count == 1 ){
            int positions = Greenfoot.getRandomNumber(3);
            switch(positions)
            {
                case 0:
                    addObject(new Bee(),45,200);
                    break;
                case 1:
                    addObject(new Bee(),220,200);
                    break;
                case 2:
                    addObject(new Bee(),390,200);
                    break;
                case 3: 
                    addObject(new Bee(),535,200);
                    break;
            }
            numBee++;
        }
    }
    private void showScore(int player,int score ,FontText scoreText,int posX)
    {
        scoreText.setText("Jugador "+player+": "+ score);
        addObject(scoreText,posX,380);
    } 
    
    public void lessHoney()
    {
        numHoney--;
    }
    
    private void wallsCreator()
    {
        addObject(new BigHor(),150,330);
        addObject(new BigHor(),450,330);
        addObject(new BigHor(),150,270);
        addObject(new BigHor(),450,270);
        //Vertical Walls
        addObject(new BigVert(),0,300);
        addObject(new BigVert(),695,300);        
    }
    
    private void locatePlayers()
    {
        p1.setGameMode("twoDirections",2);
        p2.setGameMode("twoDirections",2);
        p1.showAnimation(6);
        p2.showAnimation(6);
        addObject(p1,100,300);
        addObject(p2,500,300);
    }
    private void endSequence()
    {
        timeOver.imageText("images/Backgrounds/timeOver.png");
        addObject(timeOver,300,200);
        addObject(changeScreenTimer,1000,1000);
        if(changeScreenTimer.getTimer() <= 0)
        {
            p1.score = p1.score + scoreP1;
            p2.score = p2.score + scoreP2;
            Greenfoot.setWorld(new Results("TurnImage",p1,p2,scoreP1,scoreP2,difficulty));
        }
    }
}
