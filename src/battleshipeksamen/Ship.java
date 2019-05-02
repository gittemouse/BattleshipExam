/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author bruger
 */
public class Ship implements Drawable {
    protected int size;
    protected Boolean horizontal;
    protected Image sprite;
    protected Point pixelCoordinates1;
    protected Point pixelCoordinates2;
    
    
    public Ship(Point pPixel){
        pixelCoordinates1 = pPixel;
    }
    
    public Ship(){    
    }


    @Override
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(pixelCoordinates1.y, pixelCoordinates1.x, 22, 15);
    }
    
    @Override
    public void setPosition(Point pPixel){
        
        
    }
}
