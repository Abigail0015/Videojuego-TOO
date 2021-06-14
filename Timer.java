import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    int counter;
    int timer;
    boolean showTimer; 
    public Timer(int timer, boolean showTimer)
    {
        this.timer = timer;
        this.showTimer = showTimer;
    }
    public void act() 
    {
        subtractTimer();
        
    } 
    
    private void subtractTimer()
    {
        if(counter == 0)
        {
            if(showTimer == true && timer != 0)
                setTextTimer(">>TIEMPO: "+ (timer - 1)+ "<<");

            if(timer > 0)
            {
                timer --;
            }
        }
        counter =(counter + 1) % 60;
    }
    
    private void setTextTimer(String text)
    {

        GreenfootImage img = new GreenfootImage(181,41);
        img.setColor(new Color(224, 188, 145  ));
        img.setFont(new Font("Consolas",true, false , 20));
        img.drawString(text, 15, 23);
        setImage(img);

    }  
    
    public int getTimer()
    {
        return(timer);
    }
    
}
