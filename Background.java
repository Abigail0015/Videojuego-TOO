import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Background(int background)
    {
        getImages(background);
        GreenfootImage back = getImage();
        back.scale(600,400);
    }

    public void act() 
    {
        // Add your action code here.
    }    

    public void getImages(int x)
    {
        switch(x)
        {
            case 0: 
            setImage("images/Backgrounds/titleScreen.png");
            break;
            case 1: 
            setImage("images/Backgrounds/menu.png");
            break;
            case 2:
            setImage("images/Backgrounds/chooseCharacterScreen.png");
            break;
            case 3:
            setImage("images/Backgrounds/Instructions1.jpg");
            break;
            case 4: 
            setImage("images/Backgrounds/Instructions2.jpg");
            break;
            case 5: 
            setImage("images/Backgrounds/colorTheFloor.png");
            break;
            case 6:
            setImage("images/Backgrounds/aimGame.png");
            break;
            case 7:
            setImage("images/Backgrounds/HoneyCatch2.png");
            break;
            case 8: 
            setImage("images/Backgrounds/prueba.png");
            break;
            case 9: 
            setImage("images/Backgrounds/results.png");
            break;
            case 10: 
            setImage("images/Backgrounds/final.png");
            break;
            case 11: 
            setImage("images/Backgrounds/records.png");
            break;
            case 12: 
            setImage("images/Backgrounds/dificultad.png");
            break;
           
        }
    }
}
