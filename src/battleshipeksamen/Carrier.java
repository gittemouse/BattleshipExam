package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Carrier extends Ship {

    public Carrier(Point pPixel) {
        super();
        size = 5;
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates = pPixel;
    }
    
}
