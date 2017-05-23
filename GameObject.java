 package school.game;
 import java.awt.Rectangle;
public abstract class GameObject
{
	 public Rectangle getBounds() {
			return new Rectangle(x, y, width, height);
	 }
   public int health;
   public int x;
   public int y;
   public int width;
   public int height;
   public int horVelc;
   public int vertVelc;
}
