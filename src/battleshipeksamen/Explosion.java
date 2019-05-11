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
public class Explosion  extends SpriteAnimation{


   
    Explosion(Point pPixel1, Point pPixel2){
        super(pPixel1, pPixel2);
        spriteImage = Toolkit.getDefaultToolkit().getImage("explosion.png");
        fileSizeX = 320;
        fileSizeY = 320;
        durationMillis = 1000;
        rows = 5;
        cols = 5;
        scalingConstant = 10;
    }

}
