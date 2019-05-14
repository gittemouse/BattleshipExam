package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public class Ship implements Drawable {

    Boolean horizontal;
    Image sprite;
    Point pixelCoordinates1;
    Point pixelCoordinates2;
    Point matrixCoordinates;
    int width;
    int height;
    int hp;

    /**
     * 
     * @param pPixel pixel koordinaterne for det øverste venstre hjørne
     * @param pPixel2 pixel koordinaterne for det nederste højre hjørne
     * @param pIndex skibets plads i den logiske matrice
     * @param horiz Den vej skibet skal vælge
     */
    public Ship(Point pPixel, Point pPixel2, Point pIndex, Boolean horiz) {
        pixelCoordinates1 = pPixel;
        pixelCoordinates2 = pPixel2;
        matrixCoordinates = pIndex;
        horizontal = horiz;
    }

    /**
     * Construktør for skibobjekter
     * @param pPixel1 pixel koordinaterne for det øverste venstre hjørne hvor skibet skal tegnes
     * @param pPixel2 pixel koordinaterne for det nederste højre hjørne hvor skibet skal tegnes
     */
    public Ship(Point pPixel1, Point pPixel2) {
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
    }

    /**
     * Tom draw funktion. Kun denne klasses nedarvninger skal tegnes.
     * @param g Graphics object
     */
    @Override
    public void draw(Graphics g) {

    }
    
    /**
     * sætter skibets position
     * @param pPixel1 pixel koordinaterne for det øverste venstre hjørne
     * @param pPixel2 pixel koordinaterne for det nederste højre hjørne
     */
    @Override
    public void setPosition(Point pPixel1, Point pPixel2) {
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;

    }

    /**
     * sætter skibets position og retning
     * @param pPixel1 pixel koordinaterne for det øverste venstre hjørne
     * @param pPixel2 pixel koordinaterne for det nederste højre hjørne
     * @param horiz  skibets retning
     */
    public void setPosition(Point pPixel1, Point pPixel2, Boolean horiz) {
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
        horizontal = horiz;
    }

    /**
     * Returnerer getterfunktion for de to pixelkoordinater
     * @return et array der indeholder to Point objekter med koordinater
     */
    public Point[] getPixelPoints() {
        Point[] result = new Point[2];
        result[0] = pixelCoordinates1;
        result[1] = pixelCoordinates2;
        return result;
    }

    /**
     * Returnerer skibets logiske koordinater (i matricen)
     * @return 
     */
    @Override
    public Point getMatrixPoint() {
        return matrixCoordinates;
    }

    /**
     * returnerer skibets restererne hp (Health Points)
     * @return 
     */
    public int getHP() {
        return hp;
    }

    /**
     * trækker 1 fra skibets HP (liv)
     */
    public void decrementHP() {
        hp--;
    }
}
