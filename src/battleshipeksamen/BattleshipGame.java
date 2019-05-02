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
public class BattleshipGame {
    private int[][] shipMatrix = new int[10][10];
    private ArrayList<Drawable> drawableObjects = new ArrayList<Drawable>();

    public ArrayList<Drawable> getDrawableObjects() {
        return drawableObjects;
    }
    
    
    
    BattleshipGame(){
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
    public Point matrixCoordinateOfClick(Point pPixel, Dimension d){
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) pPixel.x;
        double py = (float) pPixel.y;
        Point pt = new Point(0,0);
        
        pt.x = (int) ((px / dwidth) * 10);
        pt.y = (int) ((py / dheight) * 10);
        
        return pt;
    }
    
    public int checkSquare(Point pIndex, int[][] m){
        int px = pIndex.x;
        int py = pIndex.y;
        System.out.print(px + " ");
        System.out.print(py);
        System.out.println("--- " + m[px][py]);
        return m[px][py];
    }
    public int [] matrixIndexToPixelCoordinate(Point pIndex,Point offset, Dimension d){
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) pIndex.x;
        double py = (float) pIndex.y;
        
        int[] result = new int[4];
        
        int x1 = (int) ((dwidth / 10) * px) + offset.x;
        int y1 = (int) ((dheight / 10) * py) + offset.y;
        int x2 = (int) ((dwidth / 10) * (px+1)) + offset.x;
        int y2 = (int) ((dheight / 10) * (py+1)) + offset.y;
        
        result[0] = x1;
        result[1] = y1;
        result[2] = x2;
        result[3] = y2;
        
        return result;
    }
    public void drawSymbol(Point pIndex,Point offset, Dimension d){
        /*
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) p.x;
        double py = (float) p.y;

        
        int x1 = (int) ((dwidth / 10) * px) + offset.x;
        int y1 = (int) ((dheight / 10) * py) + offset.y;
        int x2 = (int) ((dwidth / 10) * (px+1)) + offset.x;
        int y2 = (int) ((dheight / 10) * (py+1)) + offset.y;
    */
        int A[] = matrixIndexToPixelCoordinate(pIndex, offset, d);
        
        if(checkSquare(pIndex, shipMatrix) == -1){
            System.out.println("Space is empty");
            shipMatrix[pIndex.x][pIndex.y] = -2 ;
            drawableObjects.add(new Cross(A[0],A[1],A[2],A[3]));
            System.out.print(A[0] + " ");
            System.out.print(A[1] + ": ");
            System.out.print(A[2] + " ");
            System.out.print(A[3] + " ");
        }
        else{
            System.out.println("Space is taken");
        }
    }
    
}
