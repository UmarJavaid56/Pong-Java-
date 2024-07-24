import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Game_End_Sounds extends Pong_Game {
	
	
	{

	
try {	
        
	File file = new File("Pong-Java-/Pong Game/src/GameOver.wav");
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



