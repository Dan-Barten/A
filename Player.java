
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends GameObject
{
   public Player() 
   {
       //health = Config.playerHP;
       x = (Game.WINDOW_WIDTH - width) / 2;
       y = (Game.WINDOW_HEIGHT - height) / 2;
   }
}
