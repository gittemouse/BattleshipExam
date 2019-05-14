package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Explosion extends SpriteAnimation {

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
