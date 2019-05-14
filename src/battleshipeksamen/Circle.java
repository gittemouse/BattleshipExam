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
    private Point matrixPoint;

    /**
     * Cirklens parametre
    */
    public Circle(int x1, int y1, int x2, int y2, Point pIndex) {
        cx = x1;
        cy = y1;
        b = (x2 - x1);
        h = (y2 - y1);
        matrixPoint = pIndex;
    }

    
    /**
     * Hvor i matricen ciklen sættes
    */
    public Circle(Point pPixel1, Point pPixel2, Point pIndex) {
        cx = pPixel1.x;
        cy = pPixel1.y;
        b = pPixel2.x - pPixel1.x;
        h = pPixel2.y - pPixel1.y;
        matrixPoint = pIndex;
    }

    /**
     * Cirklen tegnes
    */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3)); //Tykkelsen på cirklen
        g2.setColor(Color.RED); //Rød farve
        g2.drawOval(cx, cy, b, h); //Cirklens koordinater
        //Der skal bruges koordinater til øverst venstre hjørn. Int længde til bredde og højde.
    }

    /**
     * Cirklens koordinater sættes
    */
    @Override
    public void setPosition(Point pPixel1, Point pPixel2) {
        cx = pPixel1.x;
        cy = pPixel1.y;
        b = pPixel2.x - pPixel1.x;
        h = pPixel2.y - pPixel1.y;
    }

    public Point getMatrixPoint() {
        return matrixPoint;
    }
}
