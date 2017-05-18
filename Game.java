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
    private final int windowWidth = 640;
    private final int windowHeight = windowWidth / 12 * 9;
    public BufferedImage backBuffer;    
    Insets insets;
    public int x = 0;
    public int y = 0;
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
            setSize(windowWidth, windowHeight); 
            setResizable(false); 
            setDefaultCloseOperation(EXIT_ON_CLOSE); 
            setVisible(true); 
            running = true;
            backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
            insets = getInsets();
            setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);
            input = new Input (this);
    }
public void update() {
    if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
        x += 2;
    } 
    
    if (input.isKeyDown(KeyEvent.VK_LEFT)) {
    x -= 2;
    }
        if (input.isKeyDown(KeyEvent.VK_DOWN)) {
        y += 2;
    } 
    
    if (input.isKeyDown(KeyEvent.VK_UP)) {
    y -= 2;
    }
    if (x < 0)
    x = 0;
    if (y < 0) 
    y = 0;
    if (x > windowWidth - 20)
    x = windowWidth - 20;
    if (y > windowHeight - 20) 
    y = windowHeight - 20;
    }

public void draw() {

Graphics g = getGraphics(); 

Graphics bbg = backBuffer.getGraphics();

bbg.setColor(Color.white);
bbg.fillRect(0, 0, windowWidth, windowHeight);

bbg.setColor(Color.black);
bbg.drawOval(x, y, 20, 20);

g.drawImage(backBuffer, insets.left, insets.top, this); 
}
}