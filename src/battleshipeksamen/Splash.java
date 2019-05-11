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
public class Splash extends SpriteAnimation{
    Splash(Point pPixel1, Point pPixel2){
        super(pPixel1, pPixel2);
        spriteImage = Toolkit.getDefaultToolkit().getImage("Splash.png");
        rows = 6;
        cols = 5;
        durationMillis = 400;
        fileSizeX = 736;
        fileSizeY = 883;
        scalingConstant = 3;
    }
}
