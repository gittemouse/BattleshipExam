
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;

public class Circle implements Drawable {
  
    private int cx = 0;
    private int cy = 0;
    private int b=0;
    private int h=0;
    private Point matrixPoint;
    
    Circle(int x1, int y1, int x2, int y2, Point pIndex){
        cx=x1;
        cy=y1;
        b=(x2-x1);
        h=(y2-y1);
        matrixPoint = pIndex;
        
    }
    
    public Circle(Point pPixel1, Point pPixel2, Point pIndex){
        cx = pPixel1.x;
        cy = pPixel1.y;
        b = pPixel2.x-pPixel1.x;
        h = pPixel2.y-pPixel1.y;
        matrixPoint = pIndex;
                
                
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        System.out.print("GG: " + cx);
        System.out.print(" " + cy);
        System.out.print(" " + b);
        System.out.println(" " + h);
        g2.setColor(Color.RED);
        g2.drawOval(cx, cy, b, h);
                //g.drawOval(100, 100, 200,300);

    }
    @Override
    public void setPosition(Point pPixel1, Point pPixel2){
        cx = pPixel1.x;
        cy = pPixel1.y;
        b = pPixel2.x-pPixel1.x;
        h = pPixel2.y-pPixel1.y;
    }

    public Point getMatrixPoint() {
        return matrixPoint;
    }
    
    

} 
