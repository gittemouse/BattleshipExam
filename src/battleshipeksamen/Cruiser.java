package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class Cruiser extends Ship {

    int size = 4;

    public Cruiser(Point pPixel1, Point pPixel2, Point pIndex, Boolean horiz) {
        super(pPixel1, pPixel2, pIndex, horiz);
        horizontal = horiz;
        sprite = Toolkit.getDefaultToolkit().getImage("TicondarogaClassCruiser.png");
        hp = size;
    }
    
    public Cruiser(Point pPixel1, Point pPixel2) {
        super(pPixel1, pPixel2);     
        sprite = Toolkit.getDefaultToolkit().getImage("TicondarogaClassCruiser.png");
        hp = size;
    }

    /**
     * Tegner skibet
     * @param g Grafik objekt
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //type casting af g til typpen Graphics2D
        AffineTransform transform = g2.getTransform(); //opretter en ny AffineTransform (position ,retning og skala)
        transform.setToTranslation((double) pixelCoordinates1.x, (double) pixelCoordinates1.y); //sætter transforms position
        
        if(horizontal){
            transform.scale(0.065 * size, 0.5); //sætte transformens skala
            g2.drawImage(sprite, transform, null); //tegner skibet grafisk ud fra den transform der er givet
        }
        else{
            transform.rotate(Math.PI/2, (pixelCoordinates2.x-pixelCoordinates1.x)/2, (pixelCoordinates2.y-pixelCoordinates1.y)/2); //roterer transformen 90 grader (pi/2 radianer)
            transform.scale(0.065 * size, 0.5); //sætter skala på transformen
            g2.drawImage(sprite, transform, null); //tegner skibet graftisk ud fra den roterede transform
        }
    }
}
