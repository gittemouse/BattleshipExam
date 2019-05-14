package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;

public class Circle implements Drawable {

    //cx og xy er koordinater til øverst venstre hjørne.
    //b og h er diameteren på cirklen, altså højde og bredde.
    private int cx = 0; 
    private int cy = 0;
    private int b = 0;
    private int h = 0;
    private Point matrixPoint; //Punkt i matricen

    
    /**
     * Cirklens parametre sættes lig variablerne i klassen
     * point pIndex er punkt i matricen
     * @param x1 x1=cx og er det samme som pPixel1.x
     * @param y1 y1=cy og er det samme som pPixel1.y
     * @param x2 Bruges til at finde bredde af cirklen og er det samme som pPixel2.x
     * @param y2 Bruges til at finde højden af cirklen og er det samme som pPixel2.2
     * @param pIndex 
     */
    public Circle(int x1, int y1, int x2, int y2, Point pIndex) {
        cx = x1;
        cy = y1;
        b = (x2 - x1);
        h = (y2 - y1);
        matrixPoint = pIndex;
    }
    
    /**
     * Hvor i matricen cirklen sættes
     * @param pPixel1 er punktet oppe i højre hjørne
     * @param pPixel2 er punktet nede i venstre hjørne
     * @param pIndex punkt i matricen
     */
    public Circle(Point pPixel1, Point pPixel2, Point pIndex) {
        cx = pPixel1.x; //pPixel1's koordinater splittet i x og y
        cy = pPixel1.y;
        b = pPixel2.x - pPixel1.x; //For at få bredde bliver x koordinaterne trukket fra hinanden
        h = pPixel2.y - pPixel1.y; //For at få højden bliver y koordinaterne trukket fra hinanden
        matrixPoint = pIndex;
    }
    
    /**
     * Cirklen tegnes
     * @param g er vores Graphics
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //Graphics2D bruges for at kunne ændre på tykkelsen
        g2.setStroke(new BasicStroke(3)); //Tykkelsen på cirklen
        g2.setColor(Color.RED); //Rød farve
        g2.drawOval(cx, cy, b, h); //Cirklens koordinater
        //Der skal bruges koordinater til øverst venstre hjørn. Int længde til bredde og højde.
    }
    
    
    /**
     * Cirklens koordinater sættes
     * @param pPixel1 punkt oppe i højre hjørne
     * @param pPixel2 punkt nede i venstre hjørne
     */
    @Override
    public void setPosition(Point pPixel1, Point pPixel2) {
        cx = pPixel1.x; //pPixel1's koordinater splittet på i x og y
        cy = pPixel1.y;
        b = pPixel2.x - pPixel1.x; //For at få bredde bliver x koordinaterne trukket fra hinanden
        h = pPixel2.y - pPixel1.y; //For at få højden bliver y koordinaterne trukket fra hinanden
    }

    /**
     * Giver punkt i matricen
     * @return returnere punkt i matricen
     */
    public Point getMatrixPoint() {
        return matrixPoint;
    }
}
