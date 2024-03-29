import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int player;
    String sprites[] = new String [9];
    Characters character = new Characters();
    int numberCharacter = 0;
    GreenfootImage image;
    int direction;
    int currentImage;
    int currentImageIdle;
    int counter;
    int counterIdle;
    int looking;
    int score = 0;
    int plus;
    int counterSelector;
    int checked = 0;
    public String gameMode;
    String directions;
    int size = 7;
    double lastShot;
    boolean activeShoot = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player()
    {
        readSprites();
    }

    public void act() 
    {

    }    

    public void getPlayer(int player)
    {
        this.player = player;
    }

    public void getActiveShoot(boolean mode)
    {
        activeShoot = mode;
    }

    public int setPlayer()
    {
        return(player);
    }

    public int getChecked()
    {
        return(checked);
    }

    public int getScore()
    {
        return(score);
    }
    public void setScore(int score)
    {
        this.score += score;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setGameMode(String gameMode,int size)
    {
        this.gameMode = gameMode;
        this.size = size;
    }

    private void readSprites()
    {
        for(int counter = 0; counter < 9; counter++)
        {
            sprites[counter] = character.getSprites(counter);
        }
    }

    public void changeCharacter(int button)
    {
        if(counterSelector == 0)
        {
            if(button == 1 &&numberCharacter < 4)
                numberCharacter++;
            else if(button == 1)
                numberCharacter = 0;
            if(button == 2 && numberCharacter > 0)
                numberCharacter--;
            else if(button == 2)
                numberCharacter = 4;
            else if (button == 5 && checked == 0)
                checked = 1;
            else if( button == 5 && checked == 1)
                checked = 0;
        }counterSelector =(counterSelector + 1) % 10;
        if(button == 6)
        {
            counterSelector = 5;
        }

        character.setNumbercharacter(numberCharacter);
        readSprites();

    }

    public void showAnimation(int direction)
    {
        checkDirection();
        //System.out.println(checked);
        if(direction < 5)
            walkAnimation();
        else if(checked == 1 && gameMode == "chooseCharacter")
        {
            image = new GreenfootImage("images/Backgrounds/checked.png");
            setImage(image);
        }
        else if (direction == 6 || checked == 1 && gameMode != "chooseCharacter")
            idleAnimation();
    }

    private void idleAnimation()
    {
        if(counterIdle == 0)
        {
            if(currentImageIdle == 0)
            {
                image = new GreenfootImage(sprites[1]);
            } 
            else if (currentImageIdle == 1)
            {
                image = new GreenfootImage(sprites[2]);
            }
            else if(currentImageIdle == 2)
            {
                image = new GreenfootImage(sprites[3]);
            }

            currentImageIdle = (currentImageIdle + 1) % 3;
            image.scale(image.getWidth() * size, image.getHeight() * size);
            setImage(image);

            if(looking == 2)
            {
                getImage().mirrorHorizontally();

            }

        }
        counterIdle =(counterIdle + 1) % 12;
    }

    private void walkAnimation()
    {
        if(counter == 0)
        {
            if(currentImage == 0)
            {
                image = new GreenfootImage(sprites[5]);
            } 
            else if (currentImage == 1)
            {
                image = new GreenfootImage(sprites[6]);
            }
            else if(currentImage == 2)
            {
                image = new GreenfootImage(sprites[7]);
            }
            else if(currentImage == 3)
            {
                image = new GreenfootImage(sprites[8]);
            }

            currentImage = (currentImage + 1) % 4;
            image.scale(image.getWidth() * size, image.getHeight() * size);
            setImage(image);

            if(looking == 2)
            {
                getImage().mirrorHorizontally();

            }

        }
        counter =(counter + 1) % 6;

    }

    private void checkDirection()
    {

        if(looking != direction && (direction == 1 || direction == 2))
        {
            looking = direction;
        }

    }

    void checkerH(String sides){
        int Xwall = this.getX();
        int Ywall = this.getY();

        switch(sides){
            case "right":

            if( getWorld().getObjectsAt( (Xwall+12),Ywall,Walls.class).size() != 0){
                setLocation(Xwall - 5, Ywall);
            }
            break;

            case "left":
            if(getWorld().getObjectsAt( (Xwall-12),Ywall,Walls.class).size() != 0){
                setLocation(Xwall + 5, Ywall);
            }

            break;

            case "up":
            if(getWorld().getObjectsAt( Xwall,(Ywall-27),Walls.class).size() != 0){
                setLocation(Xwall, Ywall + 5);
            }
            break;

            case "down":
            if(getWorld().getObjectsAt( Xwall,(Ywall+27),Walls.class).size() != 0){
                setLocation(Xwall, Ywall - 5);
            }
            break; 
        }
    }

    public int checkHoney()
    {
        int x = this.getX();
        int y = this.getY();
        Honey honey =(Honey) this.getOneIntersectingObject(Honey.class);
        Bee bee = (Bee) this.getOneIntersectingObject(Bee.class);
        if( honey != null )
        {
            this.plus+=1;
            this.getWorld().removeObject(honey);
            HoneyCatch game = (HoneyCatch) getWorld();
            game.lessHoney();
        }
        if( bee != null )
        {
            this.plus-=1;
            this.getWorld().removeObject(bee);
        }
        return plus;
    }

    public Floor intersectFloor()
    {
        Floor floor = (Floor)getOneObjectAtOffset(0,20,Floor.class);
        return(floor);
    }

    public Enemie intersectEnemie()
    {
        Enemie enemie = (Enemie)getOneObjectAtOffset(0,20,Enemie.class);
        return(enemie);
    }

    public void shootArrow(int number)
    {
        if (System.currentTimeMillis()>lastShot+600)  
        {  
            Arrow arrow = new Arrow(number);
            getWorld().addObject(arrow, getX(),getY());
            lastShot = System.currentTimeMillis();
        }  
    }

}
