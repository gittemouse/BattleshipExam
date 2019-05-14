package battleshipeksamen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

public class SpriteAnimation implements Drawable {

    Image spriteImage = Toolkit.getDefaultToolkit().getImage("explosion.png");  //Spritesheet
    Point pixelPoint1;  //Det øverste højre hjørne hvorfra animationen tegnes
    Point pixelPoint2;  //Det nederste venstre hjørne hvorfra animationen tegnes
    int durationMillis = 800;   //animationens varighed i millisekunder
    Boolean isContinuous = false;   //afgører om animationen skal kører i ring
    int scalingConstant = 0;    //En konstant der lægges til pixelPoint1 og trækkes fra pixelPoint2 for at justerer størrelse
    int rows = 5;               //Antallet af rækker i spritesheet billedet
    int cols = 5;               //Antallet af collonner i spritesheet billedet
    private long initTime;      //Systemtiden i millisekunder hvor animationen bliver initialiseret
    int fileSizeX;              //Spritesheetets bredde i pixels
    int fileSizeY;              //Spritesheetets højde i pixels
    private int frameX;         //Den kollonne i spritesheetet hvorfra billedet klippes ud i øjeblikket
    private int frameY;         //Den række i spritesheetet hvorfra billedet klippes ud i øjeblikket
    private double deltaTime = 0;   //forskellem mellem system tiden ved initialisering og øjeblikket (Hvor længe animationen har været i live)

    public SpriteAnimation(Point pPixel1, Point pPixel2) {
        initTime = System.currentTimeMillis();
        pixelPoint1 = pPixel1;
        pixelPoint2 = pPixel2;
    }

    public Boolean isDone() {

        if ((isContinuous == false) && (deltaTime > durationMillis)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param g Graphics object
     */
    @Override
    public void draw(Graphics g) {
        deltaTime = System.currentTimeMillis() - initTime;
        frameX = (int) (((deltaTime / durationMillis) * rows * cols) % cols); //Linear interpulation
        frameY = (int) ((deltaTime / durationMillis) * cols) % rows;    //Linear interpulation
        g.drawImage(spriteImage, pixelPoint1.x - scalingConstant, pixelPoint1.y - scalingConstant, //billed og xy koordinater for højre hjørne
                pixelPoint2.x + scalingConstant, pixelPoint2.y + scalingConstant,   // xy koordinater for venstre hjørne
                (fileSizeX / cols) * frameX, (fileSizeY / rows) * frameY, (fileSizeX / cols) * (frameX + 1), (fileSizeY / rows) * (frameY + 1), null);
    }

    /**
     * Sætter pixel koordinater for animationens øverste højre hjørne
     * og nederste venstre hjørne
     * @param pPixel1 Øverste højre hjørne
     * @param pPixel2 Nederste venstre hjørne
     */
    @Override
    public void setPosition(Point pPixel1, Point pPixel2) {
        pixelPoint1 = pPixel1;
        pixelPoint2 = pPixel2;
    }

    @Override
    public Point getMatrixPoint() {
        return null;
    }
}
