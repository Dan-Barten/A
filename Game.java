package school.game;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Game extends JFrame {

	private static final long serialVersionUID = 3669983212511282912L;
	private boolean running = false; 
	private final long fps = 60;
	private final int windowWidth = 640;
	private final int windowHeight = windowWidth / 12 * 9;
	public int x = 0;
	public static void main(String[] args) {
		Game game = new Game();
		game.tick();
		System.exit(0);

	}
	
	public void tick() {
		if (!running) {
			intialize();
		tick();
		}
		else 
			while(running) {
		long time = System.currentTimeMillis();
				
				update();
				draw();
				
				//delay for each frame
				time = (1000/ fps) - (System.currentTimeMillis() - time);
				
				if (time > 0 ){
					try {
						Thread.sleep(time);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
			}
		setVisible(false);
	}
	
	
	public void intialize() {
		 setTitle("G A M I N G"); 
	        setSize(windowWidth, windowHeight); 
	        setResizable(false); 
	        setDefaultCloseOperation(EXIT_ON_CLOSE); 
	        setVisible(true); 
	        running = true;
		
	}
public void update() {
		x++;
	}

public void draw() {

Graphics g = getGraphics(); 

g.setColor(Color.WHITE); 
g.fillRect(0, 0, windowWidth, windowHeight); 

g.setColor(Color.BLACK); 
g.drawOval(x, 10, 20, 20); 
	
}

}
