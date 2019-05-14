/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author bruger
 */
public class Ship implements Drawable {

    Boolean horizontal;
    Image sprite;
    Point pixelCoordinates1;
    Point pixelCoordinates2;
    Point matrixCoordinates;
    int width;
    int height;
    int hp;

    public Ship(Point pPixel, Point pPixel2, Point pIndex, Boolean horiz) {
        pixelCoordinates1 = pPixel;
        pixelCoordinates2 = pPixel2;
        matrixCoordinates = pIndex;
        horizontal = horiz;
    }

    public Ship() {
    }

    Ship(Point pPixel1, Point pPixel2) {
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void setPosition(Point pPixel1, Point pPixel2) {
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;

    }
    public void setPosition(Point pPixel1, Point pPixel2, Boolean horiz){
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
        horizontal = horiz;
    }

    public Point[] getPixelPoints() {
        Point[] result = new Point[2];
        result[0] = pixelCoordinates1;
        result[1] = pixelCoordinates2;
        return result;
    }

    public Point getMatrixPoint() {
        return matrixCoordinates;
    }

    public int getHP() {
        return hp;
    }

    public void decrementHP() {
        hp--;
    }
}
