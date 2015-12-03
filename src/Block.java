import java.awt.Color;
import java.awt.Graphics;

public class Block {
	public int X;
	public int Y;
	public int HEIGHT;
	public int WIDTH;
	

	
	public Block(int a, int b, int c, int d){
		X = a;
		Y = b;
		HEIGHT = c;
		WIDTH = d;
		System.out.println(WIDTH + X);
	}
	
	public void drawBlock(Color couleur, Graphics g){
		g.setColor(couleur);
		g.fillRect(X, Y, WIDTH, HEIGHT);
	}
	
	public void checkColliding(int O_X, int O_Y, int O_WIDTH, int O_HEIGHT){
		boolean above = false;
		boolean below = false;
		boolean left = false;
		boolean right = false;
		
		int A = X + WIDTH;
		int B = Y + HEIGHT;
		
		int O_A = (O_X + O_WIDTH);
		int O_B = (O_Y + O_HEIGHT);
		
		int X_DIF = 0;
		int Y_DIF = 0;

		if((((O_A) > X && O_X < X) || ((O_A) > A && O_X < A)) || ((O_X + (O_WIDTH / 2) > X) && (O_X + (O_WIDTH / 2) < A))){
			if(O_Y + (O_HEIGHT / 2) < Y + (HEIGHT / 2)){
				above = true;
			}else{
				below = true;
			}
			if((((O_B) > Y && O_Y < Y) || ((O_B) > B && O_Y < B)) || ((O_Y + (O_HEIGHT / 2) > Y) && (O_Y + (O_HEIGHT / 2) < B))){
				System.out.println("Here?");
				if(O_X + (O_WIDTH / 2) < X + (WIDTH / 2)){
					left = true;
				}else{
					right = true;
				}
				
				if(Math.abs(O_A - X) > Math.abs(A - O_X)){
					X_DIF = Math.abs(A - O_X);
				}else{
					X_DIF = Math.abs(O_A - X);
				}
				
				if(Math.abs(O_B - Y) > Math.abs(B - O_Y)){
					Y_DIF = Math.abs(B - O_Y);
					System.out.println("Here?");
				}else{
					Y_DIF = Math.abs(O_B - Y);
					System.out.println("Here?");
				}
				
				
				if(above && right){
					if(Y_DIF > X_DIF){
						Player.leftallowed = false;
					}else{
						System.out.println("down is false");
						Player.downallowed = false;
					}
					
					Player.rightallowed = true;
					Player.upallowed = true;
				}else if(above && left){
					if(Y_DIF > X_DIF){
						Player.rightallowed = false;
					}else{
						Player.downallowed = false;
					}
					
					Player.upallowed = true;
					Player.leftallowed = true;
				}else if(below && right){
					if(Y_DIF > X_DIF){
						Player.leftallowed = false;
					}else{
						Player.upallowed = false;
					}
					
					Player.rightallowed = true;
					Player.downallowed = true;
				}else if(below && left){
					if(Y_DIF > X_DIF){
						Player.rightallowed = false;
					}else{
						Player.upallowed = false;
					}
					
					Player.downallowed = true;
					Player.leftallowed = true;
				}
			}
		}
		
		/*System.out.println("+===+");
		//String based = "isn't";
		boolean left = false;
		boolean right = false;
		boolean above = false;
		boolean below = false;
		System.out.println("directions are false");
		
		if(Player.free_hor && ((O_X + O_WIDTH) > X && O_X < X) || ((O_X + O_WIDTH) > X + WIDTH && O_X < X + WIDTH)){
			if(O_Y + (O_HEIGHT / 2) < Y + (HEIGHT / 2)){
				above = true;
				System.out.println("above is true");
			}else{
				below = true;
				System.out.println("below is true");
			}
			Player.free_ver = false;
			System.out.println("VERTICAL IS FALSE");
		}
		
		if(Player.free_ver && ((O_Y + O_HEIGHT) > Y && O_Y < Y) || ((O_Y + O_HEIGHT) > Y + HEIGHT && O_Y < Y + HEIGHT)){
			if(O_X + (O_WIDTH / 2) < X + (WIDTH / 2)){
				left = true;
				System.out.println("left is true");
			}else{
				right = true;
				System.out.println("right is true");
			}
			Player.free_hor = false;
			System.out.println("HORIZONTAL IS FALSE");
		}
		
		if(((O_X + O_WIDTH) > X && O_X < X) || ((O_X + O_WIDTH) > X + WIDTH && O_X < X + WIDTH)){
			if(right){
				System.out.println("rightNOTALLOWED");
				Player.leftallowed = false;
			}else if(left){
				System.out.println("leftNOTALLOWED");
				Player.rightallowed = false;
			}
		}
		
		if(((O_Y + O_HEIGHT) > Y && O_Y < Y) || ((O_Y + O_HEIGHT) > Y + HEIGHT && O_Y < Y + HEIGHT)){
			if(above){
				System.out.println("downNOTALLOWED");
				Player.downallowed = false;
			}else if(below){
				System.out.println("upNOTALLOWED");
				Player.upallowed = false;
			}
		}
		
		if(!above && !below){
			Player.free_ver = true;
			System.out.println("VERTICAL IS TRUE");
		}
		if(!right && !left){
			Player.free_hor = true;
			System.out.println("HORIZONTAL IS TRUE");
		}
		/*
		/*int xdif = 0;
		int ydif = 0;
		
		if((O_X + O_WIDTH) > X_LOC && O_X < (X_LOC + WIDTH)){
			if((O_X + O_WIDTH) - X_LOC > (X_LOC + WIDTH) - O_X){
				xdif = (X_LOC + WIDTH) - O_X;
			}else{
				xdif = (O_X + O_WIDTH) - X_LOC;
			}
			
			if((O_X + O_WIDTH) > X_LOC && O_X < (X_LOC + WIDTH)){
				if((O_Y + O_HEIGHT) > Y_LOC && O_Y < (Y_LOC + HEIGHT)){
					ydif = (Y_LOC + HEIGHT) - O_Y;
				}else{
					ydif = (O_Y + O_HEIGHT) - Y_LOC;
				}
				
				if(xdif > ydif){
					if(O_Y + O_HEIGHT > Y_LOC){
						if(O_Y < Y_LOC + HEIGHT){
							Player.upallowed = false;
							System.out.println("UP IS BLOCKED");
						}else if(O_Y < Y_LOC){
							Player.downallowed = false;
							System.out.println("DOWN IS BLOCKED");
						}
					}
				}else{
					if(O_X + O_WIDTH > X_LOC){
						if(O_X < X_LOC + WIDTH){
							Player.rightallowed = false;
							System.out.println("RIGHT IS BLOCKED");
						}else if(O_X < X_LOC){
							Player.leftallowed = false;
							System.out.println("LEFT IS BLOCKED");
						}
					}
				}
			}
			
		}*/
		//return based;
	}
}
