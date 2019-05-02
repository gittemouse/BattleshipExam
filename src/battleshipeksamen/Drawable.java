/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author bruger
 */
public interface Drawable {
    public void setPosition(Point pPixel);
    public void draw(Graphics g);
}
