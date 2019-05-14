package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class WaterAnimation extends SpriteAnimation {

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
