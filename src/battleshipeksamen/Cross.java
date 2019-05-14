
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;

public class Cross implements Drawable {
    //beginx, beginy, endx og endy
    private int bx = 0;
    private int by = 0;
    private int ex = 0;
    private int ey = 0;
    private Point matrixPoint;
    
    //Krydsets parametre
    
    /**
     * Linjernes parametre sættes lig variablerne i klassen
     * point pIndex er punkt i matricen
     * @param x1 x1=bx og er det samme som pPixel1.x
     * @param y1 y1=by og er det samme som pPixel1.y
     * @param x2 x2=ex og det er det samme som pPixel2.x
     * @param y2 y2=ey og det er det samme som pPixel2.y
     * @param pIndex 
     */
    public Cross(int x1, int y1, int x2, int y2, Point pIndex){
        bx = x1;
        by = y1;
        ex = x2;
        ey = y2;
        matrixPoint = pIndex;
    }
    
    /**
     * Hvor i matricen krydset (to linjer) sættes
     * @param pPixel1 er punktet oppe i højre hjørne
     * @param pPixel2 er punktet nede i venstre hjørne
     * @param pIndex punkt i matricen
     */
    public Cross(Point pPixel1, Point pPixel2, Point pIndex){
        bx = pPixel1.x;//pPixel1's koordinater splittet i x og y
        by = pPixel1.y;
        ex = pPixel2.x; //pPixel2's koordinater splittet i x og y
        ey = pPixel2.y;
        matrixPoint = pIndex;            
    }

  
    /**
     * Linjerne(krydset) tegnes
     * @param g er vores Graphics
     */
    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3)); //Tykkelsen på krydset
        g2.setColor(Color.BLACK); //Farven er sort
        g2.drawLine(bx, by, ex, ey); //1 linje
        g2.drawLine(bx, ey, ex, by); //2 linje
      }
    
    /**
     * Giver punkt i matricen
     * @return returnere punkt i matricen
     */
    public Point getMatrixPoint(){
        return matrixPoint;
    }

    /**
     * De to punkters koordinater sættes
     * @param pPixel1 punkt oppe i højre hjørne
     * @param pPixel2 punkt nede i venstre hjørne
     */
    @Override
    public void setPosition(Point pPixel1, Point pPixel2){
        bx = pPixel1.x; //pPixel1's koordinater splittet på i x og y
        by = pPixel1.y;
        ex = pPixel2.x; //pPixel2's koordinater splittet på i x og y
        ey = pPixel2.y;
    }
}
