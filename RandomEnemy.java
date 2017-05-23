package school.game;
import java.awt.*;
import java.util.Random;
public class RandomEnemy extends Enemy
{
	int waitFrames = 0;
	Random generator = new Random();
	boolean goingUp, goingRight, goingDown, goingLeft;
    public RandomEnemy(int x, int y) {
        super(x, y, 20, 20);
        
    }
    
    public void update() {
    	goingUp = generator.nextBoolean();
    	goingRight = generator.nextBoolean(); 
    	goingDown = generator.nextBoolean();
    	goingLeft = generator.nextBoolean();
    	if (waitFrames == 30) {
    	search();
    	waitFrames = 0;
    	}
    	else {
    		waitFrames++;		
    	}
        if (x < 0 || x + width >= Game.WINDOW_WIDTH){
            horVelc -= horVelc;
        }
        x += horVelc;
        
        if (y < 0 || y + height >= Game.WINDOW_HEIGHT){
            vertVelc -= vertVelc;
        }
        y += vertVelc;
  
     
    }
    public void draw(Graphics g) {
    	g.setColor(Color.black);
    	
    	g.fillRect(x, y, width, height);
    	
    }
    
    public void search() {
        horVelc = 0;
        vertVelc = 0;
    	if  (goingUp == true) {
    		vertVelc -= 2;
    		
    	}
    	if (goingDown == true) {
    		vertVelc +=2;
    	}
    	if (goingRight == true) {
    		horVelc += 2;
    		
    	}
    	if (goingLeft == true) {
    		horVelc -= 2;
    	}
    }

	@Override
	public void search(Player player) {
		// TODO Auto-generated method stub
		
	}
}
