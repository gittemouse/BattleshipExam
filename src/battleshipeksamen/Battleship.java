package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class Battleship extends Ship {

    int size = 5;

    public Battleship(Point pPixel1, Point pPixel2, Point pIndex, Boolean horiz) {
        super(pPixel1, pPixel2, pIndex, horiz);
        hp = size;
        horizontal = horiz;
        sprite = Toolkit.getDefaultToolkit().getImage("KirovClassBattleship.png");
    }

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
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform transform = g2.getTransform();
        transform.setToTranslation((double) pixelCoordinates1.x, (double) pixelCoordinates1.y);

        if (horizontal) {
            transform.scale(0.053 * size, 0.34);
            g2.drawImage(sprite, transform, null);
        } else {
            transform.rotate(Math.PI / 2, (pixelCoordinates2.x - pixelCoordinates1.x) / 2, (pixelCoordinates2.y - pixelCoordinates1.y) / 2);
            transform.scale(0.053 * size, 0.34);
            g2.drawImage(sprite, transform, null);
        }
    }
}
