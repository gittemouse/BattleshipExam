package battleshipeksamen;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private int[][] shipMatrix = new int[10][10];
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    private ArrayList<Drawable> drawableObjects = new ArrayList<Drawable>();
    private ArrayList<SpriteAnimation> animations = new ArrayList<SpriteAnimation>();
    private Boolean placeShips = true;
    private Boolean playerTurn = true;
    private Boolean playerTurnUsed = false;
    private Boolean horizontal = true;
    private Ship nextShip = new Destroyer(new Point(0, 0), new Point(0, 0));

    private float shotHit = 0;
    private float shotMissed = 0;
    private float totalShots = 0;
    private float totalAccuracy = 0;

    public Boolean getPlayerTurnUsed() {
        return playerTurnUsed;
    }

    public void setPlayerTurnUsed(Boolean playerTurnUsed) {
        this.playerTurnUsed = playerTurnUsed;
    }

    public Boolean getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Boolean getPlaceShips() {
        return placeShips;
    }

    public void setPlaceShips(Boolean PlaceShips) {
        placeShips = PlaceShips;
    }

    public void setTotalShots() {
        totalShots = shotHit + shotMissed;
    }

    public float getTotalShots() {
        return totalShots;
    }

    public void setShotHit() {
        shotHit = shotHit + 1;
    }

    public float getShotHit() {
        return shotHit;
    }

    public float getShotMissed() {
        return shotMissed;
    }

    public void setShotMissed() {
        shotMissed = shotMissed + 1;
    }

    public float getTotalAccuracy() {
        if (totalShots > 0) {
            totalAccuracy = (shotHit / totalShots) * 100;
        }
        return totalAccuracy;
    }

    public Player() {
        for (int[] row : shipMatrix) {
            Arrays.fill(row, -1);
        }
    }

    public int[][] getShipMatrix() {
        return shipMatrix;
    }

    public void setShipMatrix(Point pIndex, int value) {
        shipMatrix[pIndex.x][pIndex.y] = value;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public ArrayList<Drawable> getDrawableObjects() {
        return drawableObjects;
    }

    public int totalHPRemaining() {
        int result = 0;
        for (Ship s : ships) {
            result += s.hp;
        }
        return result;
    }

    public enum symbolType {
        CROSS, CIRCLE
    }

    public enum animationType {
        EXPLOSION, SPLASH
    }

    public void setDrawableObjects(Point pPixel1, Point pPixel2, Point pIndex, symbolType symbol) {
        switch (symbol) {
            case CROSS:
                this.drawableObjects.add(new Cross(pPixel1, pPixel2, pIndex));
                break;
            case CIRCLE:
                this.drawableObjects.add(new Circle(pPixel1, pPixel2, pIndex));
                break;
        }
    }

    public enum shipType {
        DESTROYER, SUBMARINE, CRUISER, BATTLESHIP, CARRIER
    }

    public void setShips(Point pPixel1, Point pPixel2, Point pIndex, shipType ship, Boolean horiz) {
        switch (ship) {
            case DESTROYER:
                this.ships.add(new Destroyer(pPixel1, pPixel2, pIndex, horiz));
                break;
            case SUBMARINE:
                this.ships.add(new Submarine(pPixel1, pPixel2, pIndex, horiz));
                break;
            case CRUISER:
                this.ships.add(new Cruiser(pPixel1, pPixel2, pIndex, horiz));
                break;
            case BATTLESHIP:
                this.ships.add(new Battleship(pPixel1, pPixel2, pIndex, horiz));
                break;
            case CARRIER:
                this.ships.add(new Carrier(pPixel1, pPixel2, pIndex, horiz));
                break;
        }
    }

    public void setAnimations(Point pPixel1, Point pPixel2, animationType animation) {
        switch (animation) {
            case EXPLOSION:
                animations.add(new Explosion(pPixel1, pPixel2));
                break;
            case SPLASH:
                animations.add(new Splash(pPixel1, pPixel2));
        }
    }

    public ArrayList<SpriteAnimation> getAnimations() {
        return animations;
    }

    public void removeAnimation(SpriteAnimation a) {
        animations.remove(a);
    }

    public Boolean getHorizontal() {
        return horizontal;
    }

    public void toggleHorizontal() {
        horizontal = !horizontal;
    }

    public Ship getNextShip() {
        return nextShip;
    }

    public void setNextShipPos(Point pPixel1, Point pPixel2, Boolean horiz) {
        nextShip.setPosition(pPixel1, pPixel2, horiz);
    }

    public void setNextShip(Ship nextShip) {
        this.nextShip = nextShip;
    }
}
