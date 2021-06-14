import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class RecordsScreen extends World
{
    int counter = 10;
    Record data = new Record();
    String records[] = new String[6];
    FontText R1 = new FontText();
    FontText R2 = new FontText();
    FontText R3 = new FontText();
    
    public RecordsScreen()
    {   
        super(600, 400, 1);
        addObject(new Background(11),300,200);
        showRecords();
        
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("enter")==true)
        {
            if(counter == 0)
            Greenfoot.setWorld(new MenuScreen());
            counter =(counter + 1) % 60;
        }
        else
        {
            counter = 0;
        }
    }
    private void readRecords()
    {
        for(int counter = 0; counter < 6; counter ++)
        {
            records[counter] = data.getRecord(counter);
            
        }
    }
    
    private void showRecords()
    {
        readRecords();
        R1.setText(records[0]+"-"+records[1]);
        R2.setText(records[2]+"-"+records[3]);
        R3.setText(records[4]+"-"+records[5]);
        
        addObject(R1,300,208);
        addObject(R2,300,258);
        addObject(R3,300,308);
    }
}
