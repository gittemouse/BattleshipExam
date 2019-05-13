
package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Point;

public interface Drawable {
    public void setPosition(Point pPixel1, Point pPixel2);
    public void draw(Graphics g);
    public Point getMatrixPoint();
}
