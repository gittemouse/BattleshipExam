package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Cruiser extends Ship {

    public Cruiser(Point pPixel) {
        super();
        size = 3;
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates = pPixel;
    }
    
}