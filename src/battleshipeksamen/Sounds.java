
package battleshipeksamen;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Sounds {
    String clickCross;
    SoundEffect se=new SoundEffect();
    


public void Sound(){
clickCross=".//waterSplash.wav";
}

public class SoundEffect{
    Clip clip;

public void setFile(String soundFileName){
    try{
        File file=new File(soundFileName);
        AudioInputStream sound = AudioSystem.getAudioInputStream(file);	
	clip = AudioSystem.getClip();
	clip.open(sound);
    }
    catch(Exception e){
        
    }
}
public void play(){
clip.setFramePosition(0);
clip.start();
		}
public void action(){
se.setFile(clickCross);
se.play();
}
}
}