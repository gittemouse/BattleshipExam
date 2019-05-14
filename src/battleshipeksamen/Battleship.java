package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class Battleship extends Ship {

    int size = 5;

    /**
     * Konstruktør til placering af skibet
     * @param pPixel1 Øverste vestste hjørne punkt i pixel koordinater
     * @param pPixel2 Nederste højre hjørne punkt i pixel koordianter
     * @param pIndex punktet i matricen i matrix koordianter
     * @param horiz skibets regning når det placeres
     */
    public Battleship(Point pPixel1, Point pPixel2, Point pIndex, Boolean horiz) {
        super(pPixel1, pPixel2, pIndex, horiz);
        hp = size;
        horizontal = horiz;
        sprite = Toolkit.getDefaultToolkit().getImage("KirovClassBattleship.png");
    }

    /**
     * Konstruktør til oprettelse af skib
     * @param pPixel1 Øverste vestste hjørne punkt i pixel koordinater
     * @param pPixel2 Nederste højre hjørne punkt i pixel koordianter
     */
    public Battleship(Point pPixel1, Point pPixel2) {
        super(pPixel1, pPixel2);
        sprite = Toolkit.getDefaultToolkit().getImage("KirovClassBattleship.png");
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

        if (horizontal) {
            transform.scale(0.053 * size, 0.34);    //sætte transformens skala
            g2.drawImage(sprite, transform, null);  //tegner skibet grafisk ud fra den transform der er givet
        } else {
            transform.rotate(Math.PI / 2, (pixelCoordinates2.x - pixelCoordinates1.x) / 2, (pixelCoordinates2.y - pixelCoordinates1.y) / 2); //roterer transformen 90 grader (pi/2 radianer)
            transform.scale(0.053 * size, 0.34); //sætter skala på transformen
            g2.drawImage(sprite, transform, null); //tegner skibet graftisk ud fra den roterede transform
        }
    }
}
