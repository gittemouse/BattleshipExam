
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle implements Drawable {
  
    private int cx = 0;
    private int cy = 0;
    private int b=0;
    private int h=0;
    
    Circle(int x1, int y1, int x2, int y2){
        cx=x1;
        cy=y1;
        b=(x2-x1);
        h=(y2-y1);
        
    }
    
    public Circle(Point pPixel1, Point pPixel2){
        cx = pPixel1.x;
        cy = pPixel1.y;
        b = pPixel2.x-pPixel1.x;
        h = pPixel2.y-pPixel1.y;
                
                
                
    }
    
    @Override
    public void draw(Graphics g) {
        System.out.print("GG: " + cx);
        System.out.print(" " + cy);
        System.out.print(" " + b);
        System.out.println(" " + h);
        g.setColor(Color.RED);
        g.drawOval(cx, cy, b, h);
                //g.drawOval(100, 100, 200,300);

    }
    @Override
    public void setPosition(Point pPixel){
            
    }

} 
