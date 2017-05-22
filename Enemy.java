
import java.awt.Graphics;
public abstract class Enemy extends GameObject
{
    public Enemy(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
   public abstract void update ();
   
   public abstract void draw(Graphics g);
   
   public abstract void search();
}
