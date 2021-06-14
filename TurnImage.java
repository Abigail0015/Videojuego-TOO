import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class turnImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurnImage extends World
{
    Player1 p1;
    Player2 p2;
    int scoreP1 = 0;
    int scoreP2 = 0;
    int sig = 0;
    int win1 = 0;
    int win2 = 0;
    Turn set1 = new Turn(1);
    Turn set2 = new Turn(2);
    Turn set3 = new Turn(3);
    Turn set4 = new Turn(4);
    Marcador sett1 = new Marcador();
    Marcador sett2 = new Marcador();
    Turn set5 = new Turn(5);
    Turn set6 = new Turn(6);
    Turn set7 = new Turn(7);
    Turn set8 = new Turn(8);
    /**
     * Constructor for objects of class turnImage.
     * 
     */
    public TurnImage(Player1 p1,Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(8),300,200);
        this.p1 = p1;
        this.p2 = p2;
        locatePlayers();
        wallsCreator();
    }
    
    public void act()
    {
        if( Greenfoot.isKeyDown("q")== true ){turnImage1();}
        if( Greenfoot.isKeyDown("p")== true ){turnImage2();}
        setSignal();
        setSignal2();
        /*showText("P1: "+scoreP1,100,20);
        showText("set 1 rotation value: "+set1.getRotation(),100,50);
        showText("set 2 rotation value: "+set2.getRotation(),100,80);
        showText("set 3 rotation value: "+set3.getRotation(),100,120);
        showText("set 4 rotation value: "+set4.getRotation(),100,150);*/
        if(win1 == 4 || win2 == 4)
        {
            Greenfoot.setWorld(new Results("ScoreScreen",p1,p2,win1,win2));
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
                set1.setRotation(+90);
                if(set1.getRotation() == 90){scoreP1+=10;}
                break;
            case 2:
                set2.setRotation(-90);
                if(set2.getRotation() == 270){scoreP1+=10;}
                break;
            case 3:
                set3.setRotation(-90);
                if(set3.getRotation() == 270){scoreP1+=10;}
                break;
            case 4:
                set4.setRotation(+90);
                if(set4.getRotation() == 90){scoreP1+=10;}
                break;
        }
    }
    public void turnImage2()
    {   
        int status = sett2.getCoord();
        switch(status)
        {
            case 1:
                set5.setRotation(-180);
                break;
            case 2:
                set6.setRotation(-90);
                break;
            case 3:
                set7.setRotation(-90);
                break;
            case 4:
                set8.setRotation(+180);
                break;
        }
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
}
