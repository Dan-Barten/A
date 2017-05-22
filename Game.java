package school.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Insets;
import java.awt.event.KeyEvent;
public class Game extends JFrame {

    private static final long serialVersionUID = 3669983212511282912L;
    private boolean running = false; 
    private final long fps = 60;
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 12 * 9;
    public BufferedImage backBuffer;    	
    Insets insets;
    private Player player;
   
    Input input;
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
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT); 
            setResizable(false); 
            setDefaultCloseOperation(EXIT_ON_CLOSE); 
            setVisible(true); 
            running = true;
            backBuffer = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
            insets = getInsets();
            setSize(insets.left + WINDOW_WIDTH + insets.right, insets.top + WINDOW_HEIGHT + insets.bottom);
            input = new Input (this);
            player = new Player();

    }
public void update() {
	for (Projectile bullet : player.bullets) {
		bullet.x += bullet.horVelc;
		bullet.y += bullet.vertVelc;
		
	} 
    if (input.isKeyDown(KeyEvent.VK_D)) {
        player.x += Config.playerSpeed;
    } 
    
    if (input.isKeyDown(KeyEvent.VK_A)) {
    player.x -= Config.playerSpeed;
    }
        if (input.isKeyDown(KeyEvent.VK_S)) {
       player.y += Config.playerSpeed;
    } 
    
    if (input.isKeyDown(KeyEvent.VK_W)) {
   player.y -= Config.playerSpeed;
   
   
   if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
	   player.fire(10, 0);
   } 
   
   if (input.isKeyDown(KeyEvent.VK_LEFT)) {
	   player.fire(-10, 0);
   }
       if (input.isKeyDown(KeyEvent.VK_DOWN)) {
    	   player.fire(0, 10);
   } 
   
   if (input.isKeyDown(KeyEvent.VK_UP)) {
	   player.fire(0, -10);
	   
    }
   
    if (player.x< 0)
    player.x = 0;
    if (player.y < 0) 
   player.y = 0;
    
    if (player.x> WINDOW_WIDTH - player.width)
    player.x = WINDOW_WIDTH - player.width;
    
    if (player.y > WINDOW_HEIGHT - player.height) 
   player.y = WINDOW_HEIGHT - player.height;
    }
    }

public void draw() {

Graphics g = getGraphics(); 

Graphics bbg = backBuffer.getGraphics();

bbg.setColor(Color.black);
bbg.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

bbg.setColor(Color.blue);
for (Projectile bullet : player.bullets)
	{
	bbg.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
	}

bbg.setColor(Color.green);
bbg.fillOval(player.x, player.y, player.width, player.height);


g.drawImage(backBuffer, insets.left, insets.top, this); 
}
}