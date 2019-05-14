package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

/**
 * nedarvning af SpriteAnimation
 * @author bruger
 */
public class WaterAnimation extends SpriteAnimation {

    /**
     * sætter de korekte variable for at animationen tegnes.
     * @param pPixel1 pixelkoordinaterne for animationens øverste venstre hjørne
     * @param pPixel2 pixelkoordinaterne for animationens nederste højre hjørne
     */
    public WaterAnimation(Point pPixel1, Point pPixel2) {
        super(pPixel1, pPixel2);
        rows = 2;
        cols = 3;
        durationMillis = 1000;
        isContinuous = true;
        spriteImage = Toolkit.getDefaultToolkit().getImage("2x3WaterSprite.png");
        fileSizeX = 768;
        fileSizeY = 527;
        scalingConstant = 0;
    }
}
