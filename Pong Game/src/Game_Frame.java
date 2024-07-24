import java.awt.*;
import javax.swing.*;

public class Game_Frame extends JFrame{

	Game_Panel panel;
	
	
	Game_Frame(){
		

	panel = new Game_Panel();	
	this.add(panel);
	this.setTitle("Pong Game");
	this.setBackground(Color.black);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setVisible(true);
	this.setLocationRelativeTo(null);

	
	}

	}
