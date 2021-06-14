
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreScreen extends World
{
    Player1 p1;
    Player2 p2;
    FontText text = new FontText();
    FontText p1Text = new FontText();
    FontText p2Text = new FontText();
    int records[] = new int[5];
    String names[] = new String[]{"","","","P1","P2"};
    String total[] = new String[6];
    int iBand = 0;
    Record data = new Record();
    public ScoreScreen(Player1 p1,Player2 p2)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Background(10),300,200);
        this.p1 = p1;
        this.p2 = p2;
        checkRecords();

    }

    public void act()
    {
        showScore();
    }

    public void showScore()
    {

        p1Text.setText("Jugador 1: "+p1.score);
        addObject(p1Text,300,208);
        p2Text.setText("Jugador 2: "+p2.score);
        addObject(p2Text,300,258);
        showWinner();
        if(Greenfoot.isKeyDown("enter") == true && iBand == 0)
        {
            iBand = 1;
        }
        if(Greenfoot.isKeyDown("enter") == true && iBand == 1)
        {
            Greenfoot.setWorld(new MenuScreen());
        }
    }

    public void showWinner()
    {
        if(p1.getScore()> p2.getScore())
        {
            addObject(new Winner(),180,208);

        }
        else if(p1.getScore() < p2.getScore())
        {
            addObject(new Winner(),180,258);

        }
    }

    private void checkRecords()
    {

        int namesCounter = 0;
        int recordsCounter = 0;
        for(int counter = 0; counter < 6; counter ++)
        {
            if(counter % 2 == 0)
            {
                names[namesCounter] = data.getRecord(counter);

                namesCounter++;

            }
            else
            {
                records[recordsCounter] =Integer.valueOf( data.getRecord(counter));

                recordsCounter++;

            }

        }
        records[3] = p1.getScore();
        records[4] = p2.getScore();

        organizeRecords(records,names);
        namesCounter = 0;
        recordsCounter = 0;

        for(int counter = 0; counter < 6; counter++)
        {
            if(counter % 2 == 0)
            {
                total[counter] = names[namesCounter];
                namesCounter++;
            }
            else
            {
                total[counter] = Integer.toString(records[recordsCounter]);
                recordsCounter++;
            }
        }
        
        data.writeRecords(total);
    }

    private void organizeRecords(int records[], String names[])
    { 

        for(int i = 0; i < records.length - 1; i++)
        {
            for(int j = 0; j < records.length - 1; j++)
            {
                if (records[j] < records[j + 1])
                {
                   int tmp = records[j+1];
                   records[j+1] = records[j];
                    records[j] = tmp;
                   String tmpStr = names[j+1];
                   names[j+1] = names[j];
                    names[j] = tmpStr;
                }
            }
        }
    }
}

