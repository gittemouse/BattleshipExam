package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Destroyer extends Ship {

    public Destroyer(Point pPixel) {
        super();
        size = 4;
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates = pPixel;
    }
    
}