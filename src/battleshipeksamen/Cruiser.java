package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Cruiser extends Ship {
    int size = 4;
    public Cruiser(Point pPixel1, Point pPixel2) {
        super();
        
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
    }
    
}