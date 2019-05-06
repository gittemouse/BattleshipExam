package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

public class Battleship extends Ship {

    public Battleship(Point pPixel1, Point pPixel2) {
        super();
        size = 4;
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage(".png");
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
    }
    
}