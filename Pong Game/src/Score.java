import java.awt.*;

public class Score extends Rectangle{

	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1;
	int player2;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_HEIGHT = GAME_HEIGHT;
	}
	public void draw_1(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Garamond",Font.PLAIN,60));
		
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-100,70);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+50, 70);
	}
	
	public void draw_2(Graphics g) {
	
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.white);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
	
	}

}
