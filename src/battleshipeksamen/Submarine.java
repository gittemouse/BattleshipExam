package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Submarine extends Ship {
    int size = 3;
    public Submarine(Point pPixel1, Point pPixel2) {
        super();
        
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
        
    }
    
}