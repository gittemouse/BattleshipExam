package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Destroyer extends Ship {
    int size = 2;
    public Destroyer(Point pPixel1, Point pPixel2) {
        super();
        
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
    }
    
}