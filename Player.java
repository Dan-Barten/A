 package school.game;
 

import java.awt.Rectangle;
import java.util.ArrayList;

public class Player extends GameObject
{     	   ArrayList<Projectile> bullets = new ArrayList<>();

   public Player() 
   { 
	   width = 25;
   	height = 25;
    health = Config.playerHP;
       x = (Game.WINDOW_WIDTH - width) / 2;
       y = (Game.WINDOW_HEIGHT - height) / 2;
       
   }
   public void fire (int xSpeed, int ySpeed) {
	   bullets.add(new Projectile(x, y, 10, 10, xSpeed, ySpeed ));
		   }
	   
   }
   

		

