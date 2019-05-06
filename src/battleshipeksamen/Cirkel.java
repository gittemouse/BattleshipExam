
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cirkel implements Drawable {
  
    private int cx = 0;
    private int cy = 0;
    private int b=0;
    private int h=0;
    
    Cirkel(int x1, int y1, int x2, int y2){
        cx=x1;
        cy=y1;
        b=(x2-x1);
        h=(y1-y2);
        
    }
    
    @Override
    public void draw(Graphics g) {
        System.out.println("GG: " + cx +cy +b +h);
        g.setColor(Color.PINK);
        g.drawOval(cx, cy, b, h);
                //g.drawOval(100, 100, 200,300);

    }
    @Override
    public void setPosition(Point pPixel){
            
    }

} 
