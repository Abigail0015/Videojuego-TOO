import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class ColorTheFloor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColorTheFloor extends World
{
    Player1 p1;
    Player2 p2;
    int scoreP1 = 0;
    int scoreP2 = 0; 
    Timer timer = new Timer(8,true);
    Timer changeScreenTimer = new Timer(4,false);
    FontText scoreP1Text = new FontText();   
    FontText scoreP2Text = new FontText();
    FontText timeOver = new FontText(); 

    public ColorTheFloor(Player1 p1, Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new Background(5),300,200);
        setPaintOrder(FontText.class,Player.class,Enemie.class, Floor.class);
        this.p1 = p1;
        this.p2 = p2;
        createFloor();
        locatePlayers();
        wallsMaker();
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
            showScore(p1.setPlayer(),scoreP1,scoreP2Text,100);
            showScore(p2.setPlayer(),scoreP2,scoreP1Text,500);
            colorFloor(p1); 
            colorFloor(p2);
        }

    }

    private void wallsMaker()
    {
        addObject(new BigHor(),150,0);
        addObject(new BigHor(),150,0);
        addObject(new BigHor(),450,0);
        addObject(new BigHor(),150,365);
        addObject(new BigHor(),450,365);
        //Vertical Walls
        addObject(new BigVert(),15,150);
        addObject(new BigVert(),15,450);
        addObject(new BigVert(),585,150);
        addObject(new BigVert(),585,450);
    }

    private void locatePlayers()
    {
        p1.setGameMode("fourDirections",2);
        p2.setGameMode("fourDirections",2);
        p1.showAnimation(6);
        p2.showAnimation(6); 
        addObject(p1,22,35);
        addObject(p2,570,325);
        addObject(new Enemie(),50,50);

    }

    private void createFloor()
    {
        for(int i = 26; i <= 579 ; i+=32)
        {
            for(int j = 55; j <= 358; j +=32)
            {
                addObject(new Floor(),i,j);
            }

        }

    }

    private void colorFloor(Player player)
    {
        Floor floor = player.intersectFloor();

        if(floor != null)
        {
            if(player.setPlayer() == 1)
            {
                if(floor.getType() != "BLUE")
                {
                    if(floor.getType() == "RED")
                    {
                        scoreP2--;
                    } 
                    floor.changeColor("BLUE");
                    scoreP1++;
                }
            }
            else if(player.setPlayer() == 2)
            {
                if(floor.getType() != "RED")
                {
                    if(floor.getType() == "BLUE")
                    {
                        scoreP1--;
                    } 
                    floor.changeColor("RED");
                    scoreP2++;
                }
            }
        }
    }

    private void showScore(int player,int score ,FontText scoreText,int posX)
    {
        scoreText.setText("Jugador "+player+": "+ score);
        addObject(scoreText,posX,390);
    } 

    private void endSequence()
    {
        timeOver.imageText("images/Backgrounds/timeOver.png");
        addObject(timeOver,300,200);
        addObject(changeScreenTimer,300,200);
        if(changeScreenTimer.getTimer() <= 0)
        {
            p1.score += scoreP1;
            p2.score += scoreP2;
            Greenfoot.setWorld(new Results("AimGame",p1,p2,scoreP1,scoreP2));
        }
    }

}
