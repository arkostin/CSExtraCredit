import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Room {
	public int R_HEIGHT;
	public int R_WIDTH;
	public int R_X;
	public int R_Y;
	public Color borderColor = Color.GRAY;
	public Color blockColor = Color.LIGHT_GRAY;
	
	ArrayList<Block> blocks = new ArrayList<Block>();
	
	public Room(int x, int y, int ayy, int lmao){
		R_HEIGHT = lmao;
		R_WIDTH = ayy;
		R_X = x;
		R_Y = y;
	}
	
	public void addObstacle(int a, int b, int c, int d){
		blocks.add(new Block(a, b, c, d));
	}
	
	public void drawRoom(Graphics g){
		g.setColor(borderColor);
		g.fillRect(0, 0, R_X, (R_HEIGHT + R_Y));
		g.fillRect(0, 0, (R_WIDTH + R_X), R_Y);
		g.fillRect(R_WIDTH + R_X, 0, R_X, R_HEIGHT + R_Y * 2);
		g.fillRect(0, R_HEIGHT + R_Y, R_WIDTH + R_X * 2, R_Y);
		
		for(int i = 0; i < blocks.size(); i++){
			//System.out.println("Checking");
			blocks.get(i).drawBlock(blockColor, g);
		}
	}
	
	public void checkCollidingPlayer(){
		if(Player.x < R_X){
			Player.leftallowed = false;
		}else{
			Player.leftallowed = true;
		}
		if(Player.x + Player.width > R_X + R_WIDTH){
			Player.rightallowed = false;
		}else{
			Player.rightallowed = true;
		}
		if(Player.y < R_Y){
			Player.upallowed = false;
		}else{
			Player.upallowed = true;
		}
		if(Player.y + Player.height > R_Y + R_HEIGHT){
			Player.downallowed = false;
		}else{
			Player.downallowed = true;
		}
		for(int i = 0; i < blocks.size(); i++){
			//System.out.println("Checking");
			blocks.get(i).checkColliding(Player.x, Player.y, Player.width, Player.height);
		}
	}
}
