import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemie extends Actor
{

    int counter = 0;
    int currentImage = 0;
    int looking;
    GreenfootImage image;
    int imageDirection = 1;
    int direction;
    int steps;
    String sprites[] = new String[4];
    Characters enemie = new Characters("images/Enemies/enemieImages.txt");

    public Enemie()
    {
        readSprites();
    }

    public void act() 
    {   
        checkImageDirection();
        if(steps == 0)
        {
            movementData();
       
        }
        else
        {
            showMovement();
            walkAnimation();
        }
    } 

    private void readSprites()
    {
        for(int counter = 0; counter < 4; counter++)
        {
            sprites[counter] = enemie.getSprites(counter);
        }
    }

    private void movementData()
    {

        direction = Greenfoot.getRandomNumber(4);
        steps = Greenfoot.getRandomNumber(300-250+1);

    }

    private void showMovement()
    {
        int band =0;
        if(band == 0)
        {
            handleDirection();
            steps --;
        }
        band =(band + 1) % 6;
        
    }

    private void walkAnimation()
    {
        
        if(counter == 0)
        {
            if(currentImage == 0)
            {
                image = new GreenfootImage(sprites[0]);
            } 
            else if (currentImage == 1)
            {
                image = new GreenfootImage(sprites[1]);
            }
            else if(currentImage == 2)
            {
                image = new GreenfootImage(sprites[2]);
            }
            else if(currentImage == 3)
            {
                image = new GreenfootImage(sprites[3]);
            }

            currentImage = (currentImage + 1) % 4;
            image.scale(image.getWidth() * 2, image.getHeight() * 2);
            setImage(image);

            if(looking == 2)
            {
                getImage().mirrorHorizontally();

            }

        }
        counter =(counter + 1) % 6;

    }

    public void handleDirection()
    {

        switch(direction)
        {
            case 0:  checkerH("right");
            setLocation(getX() + 3, getY()) ;
            imageDirection = 1;
            break;

            case 1:
            checkerH("left");
            setLocation(getX() - 3, getY()) ;
            imageDirection = 2;
            break;
            case 2:
            checkerH("down");
            setLocation(getX(), getY() + 3) ;
            break;
            case 3:
            checkerH("up");
            setLocation(getX(), getY() - 3) ;
            break;
        }

    }

    private void checkImageDirection()
    {

        if(looking != imageDirection && (imageDirection == 1 || imageDirection == 2))
        {
            looking = imageDirection;
        }

    }

    private void checkerH(String sides){
        int Xwall = this.getX();
        int Ywall = this.getY();

        switch(sides){
            case "right":

            if( getWorld().getObjectsAt( (Xwall+12),Ywall,Walls.class).size() != 0){
                setLocation(Xwall - 3, Ywall);
               movementData();
            }
            break;

            case "left":
            if(getWorld().getObjectsAt( (Xwall-12),Ywall,Walls.class).size() != 0){
                setLocation(Xwall + 3, Ywall);
               movementData();
            }

            break;

            case "up":
            if(getWorld().getObjectsAt( Xwall,(Ywall-27),Walls.class).size() != 0){
                setLocation(Xwall, Ywall + 3);
                movementData();
            }
            break;

            case "down":
            if(getWorld().getObjectsAt( Xwall,(Ywall+27),Walls.class).size() != 0){
                setLocation(Xwall, Ywall - 3);
               movementData();
            }
            break; 
        }
    }
    
}