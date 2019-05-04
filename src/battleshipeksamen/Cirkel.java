
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cirkel implements Drawable {
  
    private int cx = 0;
    private int cy = 0;
    private int b=0;
    private int h=0;
    
    Cirkel(int c1, int c2, int bredde, int højde){
        cx=c1;
        cy=c2;
        b=bredde;
        h=højde;
        
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        g.drawOval(cx, cy, b, h);
    }
    @Override
    public void setPosition(Point pPixel){
            
    }

} 
