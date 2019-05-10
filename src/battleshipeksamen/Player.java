package battleshipeksamen;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private int[][] shipMatrix = new int[10][10];
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    private ArrayList<Drawable> drawableObjects = new ArrayList<Drawable>();
    private int shotHit = 0;
    private int shotMissed = 0;

    public void setShotHit() {
        shotHit = shotHit + 1;
    }

    public void setShotMissed() {
        shotMissed = shotMissed + 1;
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
    

    public void setShips(Point A, Point B, shipType K) {
        switch (K) {
            case DESTROYER:
                this.ships.add(new Destroyer(A, B));
                break;
            case SUBMARINE:
                this.ships.add(new Submarine(A, B));
                break;
            case CRUISER:
                this.ships.add(new Cruiser(A, B));
                break;
            case BATTLESHIP:
                this.ships.add(new Battleship(A, B));
                break;
            case CARRIER:
                this.ships.add(new Carrier(A, B));
                break;
        }
    }

}
