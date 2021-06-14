import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends Actor
{
    Player1 p1 = new Player1(5,"fourDirections",7);
    /**
     * Act - do whatever the Pointer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pointer(){
        setImage("pointer.png");
        GreenfootImage image = getImage();
        image.scale(80,20);
    }
    
    public void act() 
    {
        selector();
    }  
    int state=0;
    public void selector()
    {
        int x = getX();
        int y = getY();
        Greenfoot.delay(20);
        if(Greenfoot.isKeyDown("up")==true && state !=0 && y >= 160 )
        {
            state--;
            setLocation(x,y-50);
        }
        if( Greenfoot.isKeyDown("down") == true && state !=3 && y <310 )
        {
            state++;
            setLocation(x,y+50);
        }
        if( Greenfoot.isKeyDown("enter") == true )
        {
            switch(state){
                case 0: 
                    Greenfoot.setWorld(new ChooseCharacter());
                    break;
                case 1:
                    Greenfoot.setWorld(new Instructions1(p1));
                    break;
                case 2:
                    //Greenfoot.setWorld(new ScoreScreen());
                    break;
                case 3:
                    Greenfoot.setWorld(new TitleScreen());
                    Greenfoot.stop();
                    break;
            }
        }
    }
}





