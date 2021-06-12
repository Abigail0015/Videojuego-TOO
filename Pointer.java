import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends Actor
{
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
        
        if(Greenfoot.isKeyDown("up")==true && state !=0 && getY() >= 160 )
        {
            state--;
            setLocation(x,y-50);
        }
        if( Greenfoot.isKeyDown("down") == true && state !=2 && getY()<260 )
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
                    //Greenfoot.setWorld(new Instruction());
                    break;
                case 2:
                    Greenfoot.stop();
                    break;
            }
        }
    }
}





