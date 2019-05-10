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
    protected Boolean horizontal;
    protected Image sprite;
    protected Point pixelCoordinates1;
    protected Point pixelCoordinates2;
    protected int width;
    protected int height;
    protected int hp;
    
    public Ship(Point pPixel, Point pPixel2){
        pixelCoordinates1 = pPixel;
        pixelCoordinates2 = pPixel2;
    }
    
    public Ship(){    
    }


    @Override
    public void draw(Graphics g){
    
    }
    
    @Override
    public void setPosition(Point pPixel){
        
        
    }
}
