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
public class SpriteAnimation implements Drawable{
    Image spriteImage = Toolkit.getDefaultToolkit().getImage("explosion.png");
    private Point pixelPoint1;
    protected Point pixelPoint2;
    protected int durationMillis = 800;
    protected int scalingConstant = 10;
    protected int rows = 5;
    protected int cols = 5;
    private long initTime;
    protected int fileSizeX;
    protected int fileSizeY;
    private int frameX;
    private int frameY;

   
    SpriteAnimation(Point pPixel1, Point pPixel2){
        initTime = System.currentTimeMillis();
        pixelPoint1 = pPixel1;
        pixelPoint2 = pPixel2;
    }
    
    @Override
    public void draw(Graphics g){
        double deltaTime = System.currentTimeMillis() - initTime;
        frameX = (int) (((deltaTime / durationMillis)*rows*cols) % cols);
        frameY = (int) ((deltaTime / durationMillis)*cols);
        g.drawImage(spriteImage, pixelPoint1.x-scalingConstant, pixelPoint1.y-scalingConstant, pixelPoint2.x+scalingConstant, pixelPoint2.y+scalingConstant, (fileSizeX/cols)*frameX, (fileSizeY/rows)*frameY, (fileSizeX/cols)*(frameX+1), (fileSizeY/rows)*(frameY+1), null);
        System.out.println(pixelPoint1.x + " " + pixelPoint1.y);
        if(deltaTime > durationMillis){}
    }
    
    @Override
    public void setPosition(Point p){
        
    }
}
