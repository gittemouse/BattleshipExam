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
        //transform.translate(pixelCoordinates1.y, pixelCoordinates1.x);
        //transform.rotate(System.currentTimeMillis()*Math.PI/2000, pixelCoordinates1.y, pixelCoordinates1.x);
        System.out.println((pixelCoordinates2.x-pixelCoordinates1.x) + " " + (pixelCoordinates2.y-pixelCoordinates1.y));
        //g2.drawImage(sprite, transform, null);
        g2.drawImage(sprite, pixelCoordinates1.x, pixelCoordinates1.y, pixelCoordinates2.x-pixelCoordinates1.x, pixelCoordinates2.y-pixelCoordinates1.y, null);
        
    }  
}
