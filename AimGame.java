import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class AimGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AimGame extends World
{
    int counter = 0;
    Player1 p1;
    Player2 p2;
    int scoreP1 = 0;
    int scoreP2 = 0;
    Timer timer = new Timer(5,true);
    Timer changeScreenTimer = new Timer(4,false);
    FontText timeOver = new FontText();
    FontText scoreP1Text = new FontText();   
    FontText scoreP2Text = new FontText();
    double p1Counter = 0;
    double p2Counter = 0;

    /**
     * Constructor for objects of class AimGame.
     * 
     */
    public AimGame(Player1 p1, Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.p1 = p1;
        this.p2 = p2;
        wallMaker();
        LocatePlayers();

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
        ArrayList<horWall> wallH = new ArrayList<horWall>();
        for(int i=0;i<20;i++)
        {
            wallH.add(new horWall());
            wallH.get(i).getImage().setTransparency(0);
        }
        addObject(wallH.get(0),0,335);
        addObject(wallH.get(1),100,335);
        addObject(wallH.get(2),200,335);
        addObject(wallH.get(3),300,335);
        addObject(wallH.get(4),400,335);
        addObject(wallH.get(5),500,335);
        addObject(wallH.get(6),600,335);
        addObject(wallH.get(7),0,270);
        addObject(wallH.get(8),100,270);
        addObject(wallH.get(9),200,270);
        addObject(wallH.get(10),300,270);
        addObject(wallH.get(11),400,270);
        addObject(wallH.get(12),500,270);
        addObject(wallH.get(13),600,270);

        ArrayList<vertWall> wallV = new ArrayList<vertWall>();
        for(int i=0;i<14;i++)
        {
            wallV.add(new vertWall());
            wallV.get(i).getImage().setTransparency(0);
        }

        addObject(wallV.get(0),0,0);
        addObject(wallV.get(1),0,100);
        addObject(wallV.get(2),0,200);
        addObject(wallV.get(3),0,300);
        addObject(wallV.get(4),0,400);
        addObject(wallV.get(5),0,500);
        addObject(wallV.get(6),0,600);
        addObject(wallV.get(7),600,0);
        addObject(wallV.get(8),600,100);
        addObject(wallV.get(9),600,200);
        addObject(wallV.get(10),600,300);
        addObject(wallV.get(11),600,400);
        addObject(wallV.get(12),600,500);
        addObject(wallV.get(13),600,600);
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

    private void createBullseye()
    {
        int posY = 60 +(40 * Greenfoot.getRandomNumber(5));
        int direction =Greenfoot.getRandomNumber(2);

        if (direction == 0)
        {
            addObject(new Bullseye("left"),584,posY);

        }
        else if (direction == 1)
        {
            addObject(new Bullseye("right"),1,posY);

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
            Greenfoot.setWorld(new Results("Juego 3",p1,p2));
        }
    }

}



