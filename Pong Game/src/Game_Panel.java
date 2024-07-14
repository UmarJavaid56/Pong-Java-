import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game_Panel extends JPanel implements Runnable{
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.60));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 20;
	
	
	int PADDLE_HEIGHT_P1 = 100; 
	int PADDLE_HEIGHT_P2 = 100;
	int Powerup;
	int player1_ActiveStreak;
	int player2_ActiveStreak;
	int speed;
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
	
	Game_Panel panel;

	
	Game_Panel(){
		
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		gameThread = new Thread(this);
		gameThread.start();
		new Game_Start_Sound();
	}	
		
	
	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}		
	public void newPaddles() {
		paddle1 = new Paddle(25,(GAME_HEIGHT/2)-(PADDLE_HEIGHT_P1/2),PADDLE_WIDTH,PADDLE_HEIGHT_P1,1);
		paddle2 = new Paddle(950,(GAME_HEIGHT/2)-(PADDLE_HEIGHT_P2/2),PADDLE_WIDTH,PADDLE_HEIGHT_P2,2);	
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw_1(g);
		score.draw_2(g);
		
	}
	public void checkCollision() {
		
	//  bounce ball off top & bottom window edges
		
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		//bounce ball off paddles
		if(ball.intersects(paddle1)) {
			new Sound_effects();
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.intersects(paddle2)) {
			new Sound_effects();
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		
		//stops paddles at window edges
		
		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT_P1))
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT_P1;
		if(paddle2.y<=0)
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT_P2))
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT_P2;
		
		
		if (ball.x <=0) {
			newPaddles();
			newBall();
			score.player2++;
			System.out.println(" Player 2 is the Winner! " + "Score = " + score.player2);
			player2_ActiveStreak++;
			player1_ActiveStreak = 0;
		
			if (player2_ActiveStreak == 3) {
				new Game_Start_Sound();
				PADDLE_HEIGHT_P1 = 75;
				PADDLE_HEIGHT_P2 = 115;
				newPaddles();
				
	
			
		}
		}
		
		
		if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
			newPaddles();
			newBall();
			score.player1++;
			System.out.println(" Player 1 is the Winner! " + "Score = " + score.player1);
			player1_ActiveStreak++;
			player2_ActiveStreak = 0;
			
			if (player1_ActiveStreak == 3) {
				new Game_Start_Sound();
				PADDLE_HEIGHT_P1 = 115; 
				PADDLE_HEIGHT_P2 = 75;
				newPaddles();
		
				
				}
			}
	if (score.player1 == 10) {
		
		PADDLE_HEIGHT_P1 = 100; 
	    PADDLE_HEIGHT_P2 = 100;
	    newPaddles();
	    ball.xVelocity = 0;
	    ball.yVelocity = 0;
	    paddle1.speed = 0;
	    paddle2.speed = 0;
	
	}
		
	if (score.player2 == 10) {
		
		PADDLE_HEIGHT_P1 = 100; 
	    PADDLE_HEIGHT_P2 = 100;
	    newPaddles();
	    ball.xVelocity = 0;
	    ball.yVelocity = 0;
	    paddle1.speed = 0;
	    paddle2.speed = 0;

	}
	}
	

	public void draw_Winner1(Graphics g) {
		while (score.player1 != 10) {
			
		
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.white);
		g.setFont(new Font("Garamond",Font.PLAIN,60));
		g.drawString("Winner", 650, 300);
	
		
		}
		}	

	
	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
		
	
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountofTicks = 60.0;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				repaint();
				delta--;	
				
			}
		}
		
	}
	private void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
	}

	public class AL extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void  keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		
	}
}
}
