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
        showCoordenates();
        colorFloor(p1);
        colorFloor(p2);
        wallsMaker();
    }

    private void wallsMaker()
    {
        ArrayList<horWall> wallH = new ArrayList<>();
        ArrayList<vertWall> wallV = new ArrayList<>();
        for(int i=0 ; i<15;i++)
        {
            wallH.add(new horWall());
            wallH.get(i).getImage().setTransparency(0);
            wallV.add(new vertWall());
            wallV.get(i).getImage().setTransparency(0);
        }
        
        addObject(wallH.get(0),0,0);
        addObject(wallH.get(1),100,0);
        addObject(wallH.get(2),200,0);
        addObject(wallH.get(3),300,0);
        addObject(wallH.get(4),400,0);
        addObject(wallH.get(5),500,0);
        addObject(wallH.get(6),600,0);
        addObject(wallH.get(7),0,362);
        addObject(wallH.get(8),100,362);
        addObject(wallH.get(9),200,362);
        addObject(wallH.get(10),300,362);
        addObject(wallH.get(11),400,362);
        addObject(wallH.get(12),500,362);
        addObject(wallH.get(13),600,362);
        
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
    
    private void locatePlayers()
    {
        p1.setGameMode(1,2);
        p2.setGameMode(1,2);
        p1.showAnimation(6);
        p2.showAnimation(6); 
        addObject(p1,22,35);
        addObject(p2,570,325);

    }

    private void showCoordenates()
    {
        showText("P1 ="+ scoreP1,300,20);
        showText("P2 ="+scoreP2,300,350);
        //showText("P1 ="+String.valueOf(p1.getX())+","+String.valueOf(p1.getY()),300,20);
        //showText("P2 ="+String.valueOf(p2.getX())+","+String.valueOf(p2.getY()),300,350);
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
                        scoreP2 --;
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
                        scoreP1 --;
                    } 
                    floor.changeColor("RED");
                    scoreP2++;
                }
            }
        }
    }
}
