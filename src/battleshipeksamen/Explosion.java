/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
/**
 *
 * @author bruger
 */
public class Explosion implements Drawable{
    Image spriteImage = Toolkit.getDefaultToolkit().getImage("explosion.png");
    Point pixelPoint1;
    Point pixelPoint2;
    int durationMillis = 1000;
    long initTime;
    int frameX;
    int frameY;

   
    Explosion(Point pPixel1, Point pPixel2){
        initTime = System.currentTimeMillis();
        pixelPoint1 = pPixel1;
        pixelPoint2 = pPixel2;
    }
    
    @Override
    public void draw(Graphics g){
        double deltaTime = System.currentTimeMillis() - initTime;
        frameX = (int) ((5*deltaTime / durationMillis) % 6);
        frameY = (int) ((deltaTime / durationMillis)*5);
        g.drawImage(spriteImage, pixelPoint1.x, pixelPoint1.y, pixelPoint2.x, pixelPoint2.y, 64*frameX, 64*frameY, 64*(frameX+1), 64*(frameY+1), null);
        System.out.println(pixelPoint1.x + " " + pixelPoint1.y);
        if(deltaTime > durationMillis){}
    }
    
    @Override
    public void setPosition(Point p){
        
    }
}
