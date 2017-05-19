import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.Insets;
import java.awt.event.KeyEvent;
public class Game extends JFrame {

    private static final long serialVersionUID = 3669983212511282912L;
    private boolean running = false; 
    private final long fps = 60;
    public static final int WINDOW_WIDTH = 640;
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
    if (input.isKeyDown(KeyEvent.VK_D)) {
        player.x += 2;
    } 
    
    if (input.isKeyDown(KeyEvent.VK_A)) {
    player.x -= 2;
    }
        if (input.isKeyDown(KeyEvent.VK_S)) {
       player.y += 2;
    } 
    
    if (input.isKeyDown(KeyEvent.VK_W)) {
   player.y -= 2;
    }
    if (player.x< 0)
    player.x = 0;
    if (player.y < 0) 
   player.y = 0;
    if (player.x> WINDOW_WIDTH - 20)
    player.x = WINDOW_WIDTH - 20;
    if (player.y > WINDOW_HEIGHT - 20) 
   player.y = WINDOW_HEIGHT - 20;
    }

public void draw() {

Graphics g = getGraphics(); 

Graphics bbg = backBuffer.getGraphics();

bbg.setColor(Color.white);
bbg.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

bbg.setColor(Color.black);
bbg.drawOval(player.x, player.y, 20, 20);

g.drawImage(backBuffer, insets.left, insets.top, this); 
}
}