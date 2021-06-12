import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    String text;
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Text(String text)
    {
        this.text = text;
    }
    public void act() 
    {
        drawText();
    } 
    
    private void drawText()
    {
        setTextTimer(text);
    }
    
    private void setTextTimer(String text)
    {
        GreenfootImage img = new GreenfootImage(181,41);
        img.setColor(new Color(54,41,19));
        img.setFont(new Font("Consolas",true, false , 30));
        img.drawString(text, 15, 23);
        setImage(img);

    }  
    
}