package battleshipeksamen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
    
    //Ligger filen ind i fil navn
    public static File splash;
    public static File explosion;
    public static File click;

    public static void initSounds(){
        splash  = new File("waterSplash.wav");
        explosion = new File("shipExplosion.wav");
        click = new File("click.wav");
    
    }
    //Afspiller filen
     static void PlaySound(File sound) {
         if (sound == null) initSounds();
        try {
            //sætter clip lig med de højtalere der er installeret
            //på systemet/PC'en
            //AudioSystem og getClip() er begge indbyggede metoder
            //getClip() er en metode der bruges til at afspille en lydfil
            Clip audio = AudioSystem.getClip();
            //Her der åbnes hvilken lyd der skal afspilles
            audio.open(AudioSystem.getAudioInputStream(sound));
            //Lyden afspilles
            audio.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 