package battleshipeksamen;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {

    public static File splash = new File("waterSplash.WAV");
    public static File explosion = new File("shipExplosion.WAV");
    public static File click = new File("click.WAV");
    public static File hit = new File("bombaway.WAV");

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
