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
    protected Point pixelCoordinates;
    
    public Ship(Point pPixel, int size, Boolean orientation){
    
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(size, size, size, size);
    }
    
    @Override
    public void setPosition(int x, int y){
        
    }
}
