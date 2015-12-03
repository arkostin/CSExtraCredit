
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {

    private int dx;
    private int dy;
    static int x;
    static int y;
    private Image image;
    private int speed = 10;
    static int width;
    static int height;
    
    private static boolean downpress = false;
    private static boolean uppress = false;
    private static boolean leftpress = false;
    private static boolean rightpress = false;
    
    public static boolean downallowed = true;
    public static boolean upallowed = true;
    public static boolean leftallowed = true;
    public static boolean rightallowed = true;

    public Player() {
        
        initPlayer();
    }
    
    private void initPlayer() {
        
        ImageIcon ii = new ImageIcon("player.png.gif");
        image = ii.getImage();
        width = ii.getIconWidth();
        height = ii.getIconHeight();
        x = 40;
        y = 60;        
    }
    
    public void getPlayerDimensions() {
    	
    	width = image.getWidth(null);
    	height = image.getHeight(null);
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(x, y, width, height);
    }

    public void move() {
    	if(leftpress){
    		dx = -speed;
    	}
    	if(rightpress){
    		dx = speed;
    	}
    	if(uppress){
    		dy = -speed;
    	}
    	if(downpress){
    		dy = speed;
    	}
    	if(!leftallowed && dx == -speed){
    		dx = 0;
    	}
    	if(!rightallowed && dx == speed){
    		dx = 0;
    	}
    	if(!upallowed && dy == -speed){
    		dy = 0;
    	}
    	if(!downallowed && dy == speed){
    		dy = 0;
    	}
        x += dx;
        y += dy;
        /*
        if (x < 1) {
        	x = 1;
        }
        
        if (x > Main.B_WIDTH - width) {
        	x = Main.B_WIDTH - width;
        }
        
        if (y < 1) {
        	y = 1;
        }
        
        if (y > Main.B_HEIGHT - height) {
        	y = Main.B_HEIGHT - height;
        }*/
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = -speed;
            leftpress = true;
        }

        if (key == KeyEvent.VK_D) {
            dx = speed;
            rightpress = true;
        }

        if (key == KeyEvent.VK_W) {
            dy = -speed;
            uppress = true;
        }

        if (key == KeyEvent.VK_S) {
            dy = speed;
            downpress = true;
        }
        
        if (key == KeyEvent.VK_SPACE) {
        	
        }
        
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = 0;
            leftpress = false;
            if(rightpress){
            	dx = speed;
            }
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
            rightpress = false;
            if(leftpress){
            	dx = -speed;
            }
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
            uppress = false;
            if(downpress){
            	dy = speed;
            }
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
            downpress = false;
            if(uppress){
            	dy = -speed;
            }
        }
    }
}