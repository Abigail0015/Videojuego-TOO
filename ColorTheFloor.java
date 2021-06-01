import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
