package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Submarine extends Ship {

    public Submarine(Point pPixel) {
        super();
        size = 3;
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates = pPixel;
    }
    
}