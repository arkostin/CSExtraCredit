
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener 
{
	public int player_x = 0;
	public int player_y = 0;
    private Timer timer;
    private Player player;
    private Enemy enemy;
    private final int DELAY = 10;
    public final int MAP_WIDTH = 5;
    public final int MAP_HEIGHT = 5;
    
    public Room[][] map = new Room[MAP_WIDTH][MAP_HEIGHT];

    public Board() {

        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        player = new Player();
        enemy = new Enemy();
        
        makeMap();
        
        timer = new Timer(DELAY, this);
        timer.start();        
    }
    
    private void makeMap(){
    	for(int i = 0;i < MAP_WIDTH;i++){
        	for(int j = 0;j < MAP_HEIGHT;j++){
        		map[i][j] = new Room(40, 40, 800, 600);
        	}
        }
    	
    	map[0][0].addObstacle(200, 200, 400, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        doDrawing(g);
        

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        map[player_x][player_y].drawRoom(g);
        g.setColor(Color.WHITE);
        g.drawString("Hello", Player.getX(), Player.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        map[player_x][player_y].checkCollidingPlayer();
    	
        player.move();
        enemy.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
            enemy.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            enemy.keyPressed(e);
        }
    }
    
    public void checkCollisions() 
    {
    	Rectangle p = player.getBounds();
    	Rectangle e = enemy.getBounds();
    	
    	if (p.intersects(e)) {
    		System.out.println("Collision");
    	}
}
    
    
    
    
}