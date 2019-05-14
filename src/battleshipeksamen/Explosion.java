package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

/**
 * Nedarvning af SpriteAnimation.
 * Tegner en flot explosion.
 * @author bruger
 */
public class Explosion extends SpriteAnimation {

    /**
     * Initialiserer explosionen med korrekt varighed og størrelse.
     * @param pPixel1 Koordinater for øverste hjørne af animationen.
     * @param pPixel2 Koordinater for nederste venstre hjørne af animationen.
     */
    public Explosion(Point pPixel1, Point pPixel2) {
        super(pPixel1, pPixel2);
        spriteImage = Toolkit.getDefaultToolkit().getImage("explosion.png");
        fileSizeX = 320;
        fileSizeY = 320;
        durationMillis = 1000;
        rows = 5;
        cols = 5;
        scalingConstant = 10;
    }
}
