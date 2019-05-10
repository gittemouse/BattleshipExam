package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class Destroyer extends Ship {
    int size = 2;
    public Destroyer(Point pPixel1, Point pPixel2) {
        super();
        
        horizontal = true;
        sprite = Toolkit.getDefaultToolkit().getImage("ArleighBurkeClassDestroyer.png");
        pixelCoordinates1 = pPixel1;
        pixelCoordinates2 = pPixel2;
    }
    
    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform transform = g2.getTransform();
        System.out.println(transform.getTranslateX() + " " + pixelCoordinates1.x);
        transform.setToTranslation((double) pixelCoordinates1.x, (double) pixelCoordinates1.y);
        
        transform.rotate(-System.currentTimeMillis()/(140*Math.PI), (pixelCoordinates2.x-pixelCoordinates1.x)/2, (pixelCoordinates2.y-pixelCoordinates1.y)/2);
        transform.scale(0.042*size,0.34);
        //transform.rotate(System.currentTimeMillis()*Math.PI/2000);
        g2.drawImage(sprite, transform, null);
        //g2.drawImage(sprite, pixelCoordinates1.x, pixelCoordinates1.y, pixelCoordinates2.x-pixelCoordinates1.x, pixelCoordinates2.y-pixelCoordinates1.y, null);
        
    }  
}