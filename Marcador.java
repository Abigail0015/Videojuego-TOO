import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Marcador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Marcador extends Actor
{
    int signal=0;
    Player1 p1;
    Player2 p2;
    /**
     * Act - do whatever the Marcador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Marcador()
    {
        setImage("images/Turning/marcador.png");
        GreenfootImage img = getImage();
        img.scale(60,60);
    }
    public void act() 
    {
        getCoord();
    } 
    public int getCoord()
    {
        int x = this.getX();
        int y = this.getY();
        int state=0;
        if ( x == 170 && y == 135 ){state = 1;}
        if ( x == 245 && y == 135 ){state = 2;}
        if ( x == 170 && y == 190 ){state = 3;}
        if ( x == 245 && y == 190 ){state = 4;}
        
        if ( x == 355 && y == 215 ){state = 1;}
        if ( x == 430 && y == 215 ){state = 2;}
        if ( x == 355 && y == 270 ){state = 3;}
        if ( x == 430 && y == 270 ){state = 4;}
        return state;
    }
    public void setMovement( int sig,int type)
    {
        int x = this.getX();
        int y = this.getY();
        if( sig == 1)
        {
            setLocation(x-75,y);
            if(type == 1){checkerH("left");}
            if(type == 2){checker2("left");}
        }
        if( sig == 2 )
        {
            setLocation(x+75,y);
            if(type == 1){checkerH("right");}
            if(type == 2){checker2("right");}
        }
        if( sig == 3 )
        {
            setLocation(x,y-55);
            if(type == 1){checkerH("up");}
            if(type == 2){checker2("up");}
        }
        if( sig == 4 )
        {
            setLocation(x,y+55);
            if(type == 1){checkerH("down");}
            if(type == 2){checker2("down");}
        }
    }
    void checkerH(String sides){
        int x = this.getX();
        int y = this.getY();
        switch(sides){
            
            case "right":
            if( x > 245 ){
                setLocation(x-75,y);
            }
            break;
            
            case "left":
            if( x < 170 ){
                setLocation(x+75,y);
            }
            break;

            case "up":
            if( y < 135 ){
                setLocation(x,y+55);
            }
            break;

            case "down":
            if( y > 190 ){
                setLocation(x,y-55);
            }
            break; 
        }
    }
    void checker2(String sides){
        int x = this.getX();
        int y = this.getY();
        switch(sides){
            
            case "right":
            if( x > 430 ){
                setLocation(x-75,y);
            }
            break;
            
            case "left":
            if( x < 355 ){
                setLocation(x+75,y);
            }
            break;

            case "up":
            if( y < 215 ){
                setLocation(x,y+55);
            }
            break;

            case "down":
            if( y > 270 ){
                setLocation(x,y-55);
            }
            break;
        }
    }
}