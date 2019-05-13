package battleshipeksamen;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private int[][] shipMatrix = new int[10][10];
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    private ArrayList<Drawable> drawableObjects = new ArrayList<Drawable>();
    private ArrayList<SpriteAnimation> animations = new ArrayList<SpriteAnimation>();
    private Boolean PlaceShips = true;
    private Boolean playerTurn = true;
    private float shotHit = 0;
    private float shotMissed = 0;
    private float allShots = 0;
    private float allAcc = 0;

    public Boolean getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Boolean getPlaceShips() {
        return PlaceShips;
    }

    public void setPlaceShips(Boolean PlaceShips) {
        this.PlaceShips = PlaceShips;
    }

    public void setAllShots() {
        allShots = shotHit + shotMissed;
    }

    public float getAllShots() {
        return allShots;
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

    public void setAllAcc() {
        allAcc = (shotHit / allShots) * 100;
    }

    public float getAllAcc() {
        allAcc = (shotHit / allShots) * 100;
        return allAcc;
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

    public enum symbolType {
        CROSS, CIRCLE
    }
    
    public enum animationType{
        EXPLOSION, SPLASH
    }

    public void setDrawableObjects(Point A, Point B, symbolType S) {
        switch (S) {
            case CROSS:
                this.drawableObjects.add(new Cross(A, B));
                break;
            case CIRCLE:
                this.drawableObjects.add(new Circle(A, B));
                break;
            
        }
    }

    public enum shipType {
        DESTROYER, SUBMARINE, CRUISER, BATTLESHIP, CARRIER
    }

    public void setShips(Point A, Point B, Point C, shipType K) {
        switch (K) {
            case DESTROYER:
                this.ships.add(new Destroyer(A, B, C));
                break;
            case SUBMARINE:
                this.ships.add(new Submarine(A, B, C));
                break;
            case CRUISER:
                this.ships.add(new Cruiser(A, B, C));
                break;
            case BATTLESHIP:
                this.ships.add(new Battleship(A, B, C));
                break;
            case CARRIER:
                this.ships.add(new Carrier(A, B, C));
                break;
        }
    }
    
    public void setAnimations(Point pPixel1, Point pPixel2, animationType a){
        switch(a){
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
    
    public void removeAnimation(SpriteAnimation a){
        animations.remove(a);
    }

}
