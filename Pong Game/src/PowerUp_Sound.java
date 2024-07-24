import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class PowerUp_Sound extends Pong_Game {
	
	
	{

	
try {	
	
	File file = new File("pong/Pong-Java-/Pong Game/src/PowerUp.Wav");
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



