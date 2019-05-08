package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class Carrier extends Ship {

    public Carrier(Point pPixel1, Point pPixel2) {
        super();
        size = 5;
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage("QueenElizabethClassCarrier.png");
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
        
    }
    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform transform = g2.getTransform();
        System.out.println(" WOLOLOLO " + transform.toString());
        g2.drawImage(sprite, transform, null);
    }  
}
