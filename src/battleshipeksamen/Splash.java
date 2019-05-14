package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Splash extends SpriteAnimation{
    
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
