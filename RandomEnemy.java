
import java.awt.*;

public class RandomEnemy extends Enemy
{
    public RandomEnemy(int x, int y) {
        super(x, y, 20, 20);
    }
    
    public void update() {
        if (x < 0 || x + width >= Game.WINDOW_WIDTH){
            horVelc = -horVelc;
        }
        x += horVelc;
        
        if (y < 0 || y + height >= Game.WINDOW_HEIGHT){
            vertVelc = -vertVelc;
        }
        y += vertVelc;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.black);
        
        g.fillOval(x, y, width, height);
    }
    
    public void search() {
    }
}
