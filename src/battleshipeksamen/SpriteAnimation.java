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
    Point pixelPoint1;
    Point pixelPoint2;
    int durationMillis = 800;
    Boolean isContinuous = false;
    int scalingConstant = 0;
    int rows = 5;
    int cols = 5;
    private long initTime;
    int fileSizeX;
    int fileSizeY;
    private int frameX;
    private int frameY;
    private double deltaTime = 0;

   
    SpriteAnimation(Point pPixel1, Point pPixel2){
        initTime = System.currentTimeMillis();
        pixelPoint1 = pPixel1;
        pixelPoint2 = pPixel2;
    }
    
    public Boolean isDone(){
        if((isContinuous == false) && (deltaTime > durationMillis)){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public void draw(Graphics g){
        deltaTime = System.currentTimeMillis() - initTime;
        frameX = (int) (((deltaTime / durationMillis)*rows*cols) % cols);
        frameY = (int) ((deltaTime / durationMillis)*cols) % rows;
        g.drawImage(spriteImage, pixelPoint1.x-scalingConstant, pixelPoint1.y-scalingConstant, pixelPoint2.x+scalingConstant, pixelPoint2.y+scalingConstant, (fileSizeX/cols)*frameX, (fileSizeY/rows)*frameY, (fileSizeX/cols)*(frameX+1), (fileSizeY/rows)*(frameY+1), null);
        System.out.println(pixelPoint1.x + " " + pixelPoint1.y);
        if(deltaTime > durationMillis){}
    }
    
    @Override
    public void setPosition(Point pPixel1, Point pPixel2){
        pixelPoint1 = pPixel1;
        pixelPoint2 = pPixel2;
    }
    
    @Override
    public Point getMatrixPoint(){
        return null;
    }
}
