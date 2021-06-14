import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * This function create the Aim Game Level
 * @author (Abigail Espinoza Ibarra, Cristopher Pineda Martínez) 
 * @version (14 / 06 / 21)
 */
public class AimGame extends World
{
    int counter = 0;
    Player1 p1;
    Player2 p2;
    int scoreP1 = 0;
    int scoreP2 = 0;
    int velocity;
    Timer timer = new Timer(60,true);
    Timer changeScreenTimer = new Timer(4,false);
    FontText timeOver = new FontText();
    FontText scoreP1Text = new FontText();   
    FontText scoreP2Text = new FontText();
    double p1Counter = 0;
    double p2Counter = 0;
    String difficulty;
    /**
     * Constructor for objects of class AimGame.
     * 
     */
    public AimGame(Player1 p1, Player2 p2,String difficulty)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(6),300,200);
        this.p1 = p1;
        this.p2 = p2;
        wallMaker();
        LocatePlayers();
        this.difficulty = difficulty;

        selectVelocity();


    }

    public void act()
    {
        if(timer.getTimer() == 0)
        {

            p1.setGameMode("motionless",2);
            p2.setGameMode("motionless",2);
            endSequence();

        }
        else
        {
            addObject(timer,300,25);
            bullseyeGenerator();
            showScore(p1.setPlayer(),scoreP1,scoreP2Text,100);
            showScore(p2.setPlayer(),scoreP2,scoreP1Text,500);
            bullseyeTouchBorder();
            ArrowTouchBorder();
            ArrowShoot();
        }
    }

     public void wallMaker()
    {
        addObject(new BigHor(),150,330);
        addObject(new BigHor(),450,330);
        addObject(new BigHor(),150,270);
        addObject(new BigHor(),450,270);
        addObject(new BigVert(),5,150);
        addObject(new BigVert(),5,450);
        addObject(new BigVert(),595,150);
        addObject(new BigVert(),595,450);
    }

    private void LocatePlayers()
    {
        p1.setGameMode("twoDirections",2);
        p2.setGameMode("twoDirections",2);
        p1.showAnimation(6);
        p2.showAnimation(6); 
        p1.getActiveShoot(true);
        p2.getActiveShoot(true);
        addObject(p1,50,300);
        addObject(p2,550,300);

    }
    
    private void showScore(int player,int score ,FontText scoreText,int posX)
    {
        scoreText.setText("Jugador "+player+": "+ score);
        addObject(scoreText,posX,390);
    } 
    
    private void ArrowTouchBorder()
    {
        List arrowsList;
        Arrow arrow;
        arrowsList = getObjects(Arrow.class);
        if(arrowsList != null)
        {
            for(int counter = 0; counter <arrowsList.size(); counter++)
            {
                arrow = (Arrow)arrowsList.get(counter);

                if(arrow.getY() <= 0 )
                {
                    removeObject(arrow);
                }
            }
        }

    }
    

    private void ArrowShoot()
    {
        List arrowsList;
        Arrow arrow;
        arrowsList = getObjects(Arrow.class);
        Bullseye bullseye;
        if(arrowsList != null)
        {
            for(int counter = 0; counter <arrowsList.size(); counter++)
            {
                arrow = (Arrow)arrowsList.get(counter);
                bullseye = arrow.arrowHitBullseye();
                if(bullseye!= null )
                {
                    if(arrow.setPropiety() == 1)
                    {
                        scoreP1++;
                        removeObject(arrow);
                        removeObject(bullseye);
                    }
                    else if(arrow.setPropiety() == 2)
                    {
                        scoreP2++;
                        removeObject(arrow);
                        removeObject(bullseye);
                    }
                }
            }
        }

    }
    
    private void bullseyeGenerator()
    {
        if(counter == 0)
        {
            createBullseye();
        }
        counter =(counter + 1) % 30;
    }
    
    private void selectVelocity()
    {
        switch(difficulty)
        {
            case "FACIL":
                velocity = 2;
            break;
            case "NORMAL":
                velocity = 4;
            break;
            case "DIFICIL":
                velocity = 8;
            break;
        }
    }
    
    private void createBullseye()
    {
        int posY = 60 +(40 * Greenfoot.getRandomNumber(5));
        int direction =Greenfoot.getRandomNumber(2);

        if (direction == 0)
        {
            addObject(new Bullseye("left",velocity),584,posY);

        }
        else if (direction == 1)
        {
            addObject(new Bullseye("right",velocity),1,posY);

        }

    }
    
    private void bullseyeTouchBorder()
    {
        List bullseyesList;
        Bullseye bullseye;
        bullseyesList = getObjects(Bullseye.class);
        if(bullseyesList != null)
        {
            for(int counter = 0; counter <bullseyesList.size(); counter++)
            {
                bullseye = (Bullseye)bullseyesList.get(counter);

                if(bullseye.getX()>= 599 || bullseye.getX()<= 0 )
                {
                    removeObject(bullseye);
                }
            }
        }

    }

    private void deleteAllBullseye()
    {
        List bullseyesList;
        Bullseye bullseye;
        bullseyesList = getObjects(Bullseye.class);
        if(bullseyesList != null)
        {
            for(int counter = 0; counter <bullseyesList.size(); counter++)
            {
                bullseye = (Bullseye)bullseyesList.get(counter);


                    removeObject(bullseye);
                
            }
        }

    }

    private void endSequence()
    {

        timeOver.imageText("images/Backgrounds/timeOver.png");
        addObject(timeOver,300,200);
        addObject(changeScreenTimer,1000,1000);
        deleteAllBullseye();
        if(changeScreenTimer.getTimer() <= 0)
        {
            Greenfoot.setWorld(new Results("HoneyCatch",p1,p2,scoreP1,scoreP2,difficulty));

        }
    }

}



