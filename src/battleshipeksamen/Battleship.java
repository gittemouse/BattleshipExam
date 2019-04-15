/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.*;

/**
 *
 * @author bruger
 */
public class Battleship {
    private int[][] shipMatrix = new int[10][10];

    public void setShipMatrix(int[][] gameMatrix) {
        this.shipMatrix = gameMatrix;
    }

    public int[][] getShipMatrix() {
        return shipMatrix;
    }
    public Point matrixCoordinateOfClick(Point p, Dimension d){
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) p.x;
        double py = (float) p.y;
        Point pt = new Point(0,0);
        
        pt.x = (int) ((px / dwidth) * 10);
        pt.y = (int) ((py / dheight) * 10);
        
        return pt;
    }
    
    public int checkSquare(Point p, int[][] m){
        int px = p.x;
        int py = p.y;
        System.out.print(px + " ");
        System.out.println(py);
        return m[px][py];
    }
}
