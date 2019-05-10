package battleshipeksamen;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {

    public static File Splash = new File("waterSplash.WAV");


    public void Play() {

        PlaySound(Splash);


    }

     static void PlaySound(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();

            //Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {

        }
    }
}
