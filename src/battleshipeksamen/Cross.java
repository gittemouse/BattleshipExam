
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;

public class Cross implements Drawable {
    private int bx = 0;
    private int by = 0;
    private int ex = 0;
    private int ey = 0;
    private Point matrixPoint;
    
    public Cross(int x1, int y1, int x2, int y2, Point pIndex){
        bx = x1;
        by = y1;
        ex = x2;
        ey = y2;
        matrixPoint = pIndex;
    }
    
    public Cross(Point pPixel1, Point pPixel2, Point pIndex){
        bx = pPixel1.x;
        by = pPixel1.y;
        ex = pPixel2.x;
        ey = pPixel2.y;
        matrixPoint = pIndex;
                
                
                
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.BLACK);
        g2.drawLine(bx, by, ex, ey);
        g2.drawLine(bx, ey, ex, by);
      }
    
    public Point getMatrixPoint(){
        return matrixPoint;
    }
    
    @Override
    public void setPosition(Point pPixel1, Point pPixel2){
        bx = pPixel1.x;
        by = pPixel1.y;
        ex = pPixel2.x;
        ey = pPixel2.y;
    }
}
