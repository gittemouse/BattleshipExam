package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;


/**
 * Nedarvning af SpriteAnimation.
 * Tegner en flot explosion.
 * @author bruger
 */
public class Splash extends SpriteAnimation{
    
   /**
     * Initialiserer splashet med korrekt varighed og størrelse.
     * @param pPixel1 Koordinater for øverste hjørne af animationen.
     * @param pPixel2 Koordinater for nederste venstre hjørne af animationen.
     */
   public Splash(Point pPixel1, Point pPixel2){
        super(pPixel1, pPixel2);
        spriteImage = Toolkit.getDefaultToolkit().getImage("Splash.png");
        rows = 6;
        cols = 5;
        durationMillis = 700;
        fileSizeX = 736;
        fileSizeY = 883;
        scalingConstant = 3;
    }
}
