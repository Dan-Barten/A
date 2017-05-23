package school.game;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
public abstract class Enemy extends GameObject
{
    public Enemy(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public Rectangle getBounds() {
  		return new Rectangle(x, y, width, height);
  		}
    public boolean collisionCheck(GameObject obj) {
    	return obj.getBounds().intersects(getBounds());
    	
    }

    	
   public abstract void update ();
   
   public abstract void draw (Graphics g);
   
   public abstract void search();
   public abstract void search(Player player);
}
