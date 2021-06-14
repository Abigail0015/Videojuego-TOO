import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This function create Turn Image Level
 * 
 * @author (Abigail Espinoza Ibarra, Cristopher Pineda Martínez) 
 * @version (14 / 06 / 21)
 */
public class TurnImage extends World
{
    Player1 p1;
    Player2 p2;
    int scoreP1 = 0;
    int scoreP2 = 0;
    int sig = 0;
    double counter1;
    double counter2;
    Timer changeScreenTimer = new Timer(4,false);
    FontText timeOver = new FontText();
    Turn set1 = new Turn(1,90);
    Turn set2 = new Turn(2,270);
    Turn set3 = new Turn(3,270);
    Turn set4 = new Turn(4,90);
    Marcador sett1 = new Marcador();
    Marcador sett2 = new Marcador();
    Turn set5 = new Turn(5,180);
    Turn set6 = new Turn(6,270);
    Turn set7 = new Turn(7,270);
    Turn set8 = new Turn(8,180);
    String difficulty;

    /**
     * Constructor for objects of class turnImage.
     * 
     */
    public TurnImage(Player1 p1,Player2 p2,String difficulty)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setPaintOrder(FontText.class,Player.class,Enemie.class, Floor.class);
        addObject(new Background(8),300,200);
        this.p1 = p1;
        this.p2 = p2;
        locatePlayers();
        wallsCreator();
    }

    public void act()
    {

        if( Greenfoot.isKeyDown("q")== true ){turnImage1();}
        else{counter1 = 0;}
        if( Greenfoot.isKeyDown("p")== true ){turnImage2();}
        else{counter2 = 0;}
        setSignal();
        setSignal2();
        checkPoints();
        
        if(scoreP1 == 4 || scoreP2 == 4)
        {
            p1.setGameMode("motionless",2);
            p2.setGameMode("motionless",2);
            endSequence();
        }
    }

    public void setSignal()
    {
        if( p1.getX() < 55  )
        {
            sig = 1;
            sett1.setMovement(sig,1);    
        }
        if( p1.getX() > 105  )
        {
            sig = 2;
            sett1.setMovement(sig,1);
        }
        if( p1.getY() < 250  )
        {
            sig= 3;
            sett1.setMovement(sig,1);
        }
        if( p1.getY() > 290  )
        {
            sig = 4;
            sett1.setMovement(sig,1);
        }
        else{sig = 5;}
        sett1.setMovement(sig,1);
    }

    public void setSignal2()
    {
        if( p2.getX() < 505  )
        {
            sig = 1;
            sett2.setMovement(sig,2);     
        }
        if( p2.getX() > 525 )
        {
            sig = 2;
            sett2.setMovement(sig,2); 
        }
        if( p2.getY() < 75  )
        {
            sig= 3;
            sett2.setMovement(sig,2);
        }
        if( p2.getY() > 110 )
        {
            sig = 4;
            sett2.setMovement(sig,2);
        }
        else{sig = 5;}
        sett2.setMovement(sig,2);
    }

    public void turnImage1()
    {   
        int status = sett1.getCoord();
        switch(status)
        {
            case 1:
             if (counter1 == 0)  
            { 
                set1.setRotation(set1.getRotation()-90);
            }counter1 =(counter1 + 1) % 6;
            //90
            break;
            case 2:
             if (counter1 == 0)  
            { 
                set2.setRotation(set2.getRotation()-90);
            }counter1 =(counter1 + 1) % 6;
            //-90
            break;
            case 3:
             if (counter1 == 0)  
            { 
                set3.setRotation(set3.getRotation()-90);
            }counter1 =(counter1 + 1) % 6;
            //-90
            break;
            case 4:
             if (counter1 == 0)  
            { 
                set4.setRotation(set4.getRotation()-90);
            }counter1 =(counter1 + 1) % 6;
            //-90
            break;
        }
    }
    
    public void turnImage2()
    {   
        int status = sett2.getCoord();
        switch(status)
        {
            case 1:
            if (counter2 == 0)  
            { 
                set5.setRotation(set5.getRotation()-90);
            }counter2 =(counter2 + 1) % 6;
            //180
            break;
            case 2:
            if (counter2 == 0)  
            { 
                set6.setRotation(set6.getRotation()-90);
            }counter2 =(counter2 + 1) % 6;
            //-90
            break;
            case 3:
            if (counter2 == 0)  
            { 
                set7.setRotation(set7.getRotation()-90);
            }counter2 =(counter2 + 1) % 6;
            //-90
            break;
            case 4:
            if (counter2 == 0)  
            { 
                set8.setRotation(set8.getRotation()-90);
            }counter2 =(counter2 + 1) % 6;
            //180
            break;
        }
    }
    
    private void checkPoints()
    {
        scoreP1 = set1.checkRotation() + set2.checkRotation() + set3.checkRotation() +set4.checkRotation();
        scoreP2 = set5.checkRotation() + set6.checkRotation() + set7.checkRotation() +set8.checkRotation();
    }
    
    public void wallsCreator()
    {
        addObject(new horWall(),15,240);
        addObject(new horWall(),15,305);
        addObject(new horWall(),145,240);
        addObject(new horWall(),145,305);
        addObject(new horWall(),115,335);
        addObject(new horWall(),115,215);
        //Vertical walls 
        addObject(new vertWall(),128,260);
        addObject(new vertWall(),35,260);
        addObject(new vertWall(),60,215);
        addObject(new vertWall(),60,345);
        addObject(new vertWall(),100,215);
        addObject(new vertWall(),100,345);

        addObject(new horWall(),450,65);
        addObject(new horWall(),580,65);
        addObject(new horWall(),450,130);
        addObject(new horWall(),580,130);
        addObject(new horWall(),500,30);
        addObject(new horWall(),500,160);
        //Vertical walls 
        addObject(new vertWall(),495,45);
        addObject(new vertWall(),535,45);
        addObject(new vertWall(),495,165);
        addObject(new vertWall(),535,165);
        addObject(new vertWall(),475,100);
        addObject(new vertWall(),555,100);
    }

    public void locatePlayers()
    {
        p1.setGameMode("fourDirections",2);
        p2.setGameMode("fourDirections",2);
        p1.showAnimation(6);
        p2.showAnimation(6);
        addObject(p1,55,265);
        addObject(p2,545,95);
        addObject(sett1,245,190);
        addObject(sett2,430,270);
        addObject(set1,175,130);
        addObject(set2,240,130);
        addObject(set3,175,190);
        addObject(set4,240,190);
        addObject(set5,355,220);
        addObject(set6,420,220);
        addObject(set7,355,275);
        addObject(set8,420,275);
    }

    private void endSequence()
    {
        timeOver.imageText("images/Backgrounds/timeOver.png");
        addObject(timeOver,300,200);
        addObject(changeScreenTimer,600,400);
        if(changeScreenTimer.getTimer() <= 0)
        {
            p1.score += scoreP1;
            p2.score += scoreP2;
            Greenfoot.setWorld(new Results("ScoreScreen",p1,p2,scoreP1,scoreP2,difficulty));
        }
    }

    private void showScore(int player,int score ,FontText scoreText,int posX)
    {
        scoreText.setText("Jugador "+player+": "+ score);
        addObject(scoreText,posX,390);
    } 
}
