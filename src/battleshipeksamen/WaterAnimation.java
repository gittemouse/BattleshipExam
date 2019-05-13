/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author bruger
 */
public class WaterAnimation extends SpriteAnimation{
    WaterAnimation(Point pPixel1, Point pPixel2){
        super(pPixel1, pPixel2);
        rows = 2;
        cols = 3;
        durationMillis = 2000;
        isContinuous = true;
        spriteImage = Toolkit.getDefaultToolkit().getImage("2x3WaterSprite.png");
        fileSizeX = 768;
        fileSizeY = 527;
        
    }
}
