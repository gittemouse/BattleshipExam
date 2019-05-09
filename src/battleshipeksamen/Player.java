package battleshipeksamen;

import java.awt.Point;
import java.util.ArrayList;

public class Player {

    private int[][] shipMatrix = new int[10][10];
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    private ArrayList<Drawable> drawableObjects = new ArrayList<Drawable>();

    public int[][] getShipMatrix() {
        return shipMatrix;
    }

    public void setShipMatrix(Point pIndex, int value) {
        
        shipMatrix[pIndex.x][pIndex.y] = value;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

}
