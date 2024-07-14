import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Game_Start_Sound extends Pong_Game {
	
	
	{

	
try {	
	
	
	File file = new File("Game_Start.wav");
	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	Clip clip = AudioSystem.getClip();
	clip.open(audioStream);
    clip.start();
 
    
 } 	catch (UnsupportedAudioFileException e) {
    	e.printStackTrace();
 } 	catch (IOException e) {
	 	e.printStackTrace();
 } 	catch (LineUnavailableException e) {
	 	e.printStackTrace();
 }

	
}
}



