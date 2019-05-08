/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 *
 * @author bruger
 */
public class GamePanel extends javax.swing.JPanel {

    /**
     * Creates new form GamePanel
     */
    BattleshipGame spil;
    
    public GamePanel() {
        initComponents();
        boardPanel1.setOpaque(false);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.cyan);
        g.fillRect(boardPanel1.getX(), boardPanel1.getY(), boardPanel1.getWidth(), boardPanel1.getHeight());
        for (Drawable d: spil.getDrawableObjects()){
            d.draw(g);
        }
        for (Ship s: spil.getP1Ships()){
            s.draw(g);
        }
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boardPanel1 = new battleshipeksamen.BoardPanel();

        setBackground(new java.awt.Color(102, 153, 0));

        boardPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boardPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout boardPanel1Layout = new javax.swing.GroupLayout(boardPanel1);
        boardPanel1.setLayout(boardPanel1Layout);
        boardPanel1Layout.setHorizontalGroup(
            boardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        boardPanel1Layout.setVerticalGroup(
            boardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boardPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardPanel1MousePressed

        Point p = spil.matrixCoordinateOfClick(evt.getPoint(), boardPanel1.getSize()); //Laver finder ud af hvilken plads i matrixen der klikkes
        spil.checkSquare(p, spil.getShipMatrix());
        //spil.placeShip(p,boardPanel1.getLocation(), boardPanel1.getSize());
        spil.drawSymbol(p,boardPanel1.getLocation(), boardPanel1.getSize());
    }//GEN-LAST:event_boardPanel1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private battleshipeksamen.BoardPanel boardPanel1;
    // End of variables declaration//GEN-END:variables
}
