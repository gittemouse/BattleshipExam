/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author bruger
 */
public class Cross implements Drawable {
    private int bx = 0;
    private int by = 0;
    private int ex = 0;
    private int ey = 0;
    
    public Cross(int x1, int y1, int x2, int y2){
        bx = x1;
        by = y1;
        ex = x2;
        ey = y2;
    }
    
    public Cross(Point pPixel1, Point pPixel2){
        bx = pPixel1.x;
        by = pPixel1.y;
        ex = pPixel2.x;
        ey = pPixel2.y;
                
                
                
    }
    
    @Override
    public void draw(Graphics g){
     g.setColor(Color.BLACK);
     g.drawLine(bx, by, ex, ey);
     g.drawLine(bx, ey, ex, by);
     
     
    }
    
    @Override
    public void setPosition(Point pPixel){
     
    }
}
