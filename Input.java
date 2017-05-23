package school.game;

import java.awt.Component;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener
{
   private boolean[] keys = new  boolean[256];
   private boolean[] mouse = new boolean[3];
   private boolean[]justPressed = new boolean[256], cantPress = new boolean[256];
   public Input(Component c) {
    c.addKeyListener(this);
    c.addMouseListener(this);
    }
    
    public void update() {
        for (int i = 0; i < keys.length; i++) {
        if (cantPress[i] && !keys[i]) {
            cantPress[i] = false;
        }
        else if (justPressed[i]) {
        cantPress[i] = true;
        justPressed[i] = false;
        }
        if (!cantPress[i] && keys[i]) {
        justPressed[i] = true;
        }
        }
        
    }
    
    public boolean keyJustPressed(int keyCode) {
        if (keyCode < 0 || keyCode >= justPressed.length)
            return false;
        return justPressed[keyCode];
    }
    
    public boolean isKeyDown (int key) {
        if (key > 0 && key < 256) {
            return keys[key];
        }
        return false;
    }
    
    public void keyPressed (KeyEvent e) {
          if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
                {
                        keys[e.getKeyCode()] = true;
                }
    }
    
    public void keyReleased (KeyEvent e) {
        if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
        keys[e.getKeyCode()] = false;
        }
    }
    //Overwritten abstact method inherited from KeyListener, else class will not compile
    public void keyTyped (KeyEvent e) {
    }
    //Mouse Listener Methods
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
        System.out.println("clicked");
        mouse[0] = true;
        }
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e) {
    
    }
    
    public void mouseEntered(MouseEvent e) {}
    
    public void mouseExited(MouseEvent e) {}
}
