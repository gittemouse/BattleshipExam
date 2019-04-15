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
    private int[][] gameMatrix = new int[9][9];

    public void setGameMatrix(int[][] gameMatrix) {
        this.gameMatrix = gameMatrix;
    }

    public int[][] getGameMatrix() {
        return gameMatrix;
    }
    
    public int checkSquare(Point p, Dimension d){
        System.out.println(p);
        System.out.println(d);
        return 0;
    }
}
