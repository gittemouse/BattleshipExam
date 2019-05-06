package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Submarine extends Ship {

    public Submarine(Point pPixel1, Point pPixel2) {
        super();
        size = 3;
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
        
    }
    
}