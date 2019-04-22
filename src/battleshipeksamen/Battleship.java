/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author bruger
 */
public class Battleship {
    private int[][] shipMatrix = new int[10][10];
    private ArrayList<Drawable> drawableObjects = new ArrayList<Drawable>();

    public ArrayList<Drawable> getDrawableObjects() {
        return drawableObjects;
    }
    
    
    
    Battleship(){
        for(int[] row : shipMatrix){
            Arrays.fill(row, -1);
        }
            
    }

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
        System.out.print(py);
        System.out.println("--- " + m[px][py]);
        return m[px][py];
    }
    public void drawSymbol(Point p, Dimension d){
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) p.x;
        double py = (float) p.y;
        
        
        
        int x1 = (int) ((dwidth / 10) * px);
        int y1 = (int) ((dheight / 10) * py);
        int x2 = (int) ((dwidth / 10) * (px+1));
        int y2 = (int) ((dheight / 10) * (py+1));
        
        if(checkSquare(p, shipMatrix) == -1){
            System.out.println("Space is empty");
            shipMatrix[p.x][p.y] = -2 ;
            drawableObjects.add(new Cross(x1,y1,x2,y2));
            System.out.print(x1 + " ");
            System.out.print(y1 + ": ");
            System.out.print(x2 + " ");
            System.out.print(y2 + " ");
        }
        else{
            System.out.println("Space is taken");
        }
    }
    
}
