import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Font here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FontText extends Actor
{
    

    public FontText() 
    {

    }

    public void setText(String text)
    {

        GreenfootImage img = new GreenfootImage("images/Backgrounds/sign.png");
        //img.setColor(Color.BLACK);
        //img.fill();
        img.setColor(new Color(54,41,19));
        img.setFont(new Font("Consolas", false, false , 20));
        img.drawString(text, 15, 23);
        setImage(img);

    }  
    public void imageText(String location)
    {

        GreenfootImage img = new GreenfootImage(location);
        setImage(img);

    }  
    

}
