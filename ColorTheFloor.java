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

    public ColorTheFloor(Player1 p1, Player2 p2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setPaintOrder(Player.class, Floor.class);
        this.p1 = p1;
        this.p2 = p2;
        createFloor();
        locatePlayers();

    }

    public void act()
    {
        wallsMaker();
    }

    public void wallsMaker()
    {
        ArrayList<horWall> wallH = new ArrayList<horWall>();
        for(int i=0;i<20;i++)
        {
            wallH.add(new horWall());
            wallH.get(i).getImage().setTransparency(0);
        }
        addObject(wallH.get(0),0,5);
        addObject(wallH.get(1),100,5);
        addObject(wallH.get(2),200,5);
        addObject(wallH.get(3),300,5);
        addObject(wallH.get(4),400,5);
        addObject(wallH.get(5),500,5);
        addObject(wallH.get(6),600,5);
        addObject(wallH.get(7),0,360);
        addObject(wallH.get(8),100,360);
        addObject(wallH.get(9),200,360);
        addObject(wallH.get(10),300,360);
        addObject(wallH.get(11),400,360);
        addObject(wallH.get(12),500,360);
        addObject(wallH.get(13),600,360);
        
        ArrayList<vertWall> wallV = new ArrayList<vertWall>();
        for(int i=0;i<14;i++)
        {
            wallV.add(new vertWall());
            wallV.get(i).getImage().setTransparency(0);
        }
        
        addObject(wallV.get(0),10,0);
        addObject(wallV.get(1),10,100);
        addObject(wallV.get(2),10,200);
        addObject(wallV.get(3),10,300);
        addObject(wallV.get(4),10,400);
        addObject(wallV.get(5),10,500);
        addObject(wallV.get(6),10,600);
        addObject(wallV.get(7),590,0);
        addObject(wallV.get(8),590,100);
        addObject(wallV.get(9),590,200);
        addObject(wallV.get(10),590,300);
        addObject(wallV.get(11),590,400);
        addObject(wallV.get(12),590,500);
        addObject(wallV.get(13),590,600);
    }
    private void locatePlayers()
    {
        p1.setGameMode(1,2);
        p2.setGameMode(1,2);
        p1.showAnimation(6);
        p2.showAnimation(6); 
        addObject(p1,22,35);
        addObject(p2,570,325);

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
}
