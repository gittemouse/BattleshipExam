/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author bruger
 */
public class Cross implements Drawable {
    private int bx = 0;
    private int by = 0;
    private int ex = 0;
    private int ey = 0;
    
    Cross(int x1, int y1, int x2, int y2){
        bx = x1;
        by = y1;
        ex = x2;
        ey = y2;
    }
    
    @Override
    public void draw(Graphics g){
     g.setColor(Color.BLACK);
     g.drawLine(bx, by, ex, ey);
     g.drawLine(bx, ey, ex, by);
     
     
    }
    
    @Override
    public void setPosition(int x, int y){
     
    }
}
