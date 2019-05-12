/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipeksamen;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author bruger
 */
public class GamePanel extends javax.swing.JPanel {

    /**
     * Creates new form GamePanel
     */
    BattleshipGame spil;
    Image backgroundIMG = Toolkit.getDefaultToolkit().getImage("InstrumentPanel.png");
    CardLayout cardLayout;
    JPanel parentPanel;

    public GamePanel(JPanel p) {
        initComponents();
        boardPanel1.setOpaque(false);
        this.parentPanel = p;
        cardLayout = (CardLayout) parentPanel.getLayout();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundIMG, 0, 0, this.getParent().getWidth(), this.getParent().getHeight(), this);

        g.setColor(Color.cyan);
        g.fillRect(boardPanel1.getX(), boardPanel1.getY(), boardPanel1.getWidth(), boardPanel1.getHeight());

        if (spil.getPlayer1Turn() == true) {
            for (Ship s : spil.p1.getShips()) {
                s.draw(g);
            }
            for (Drawable d : spil.p1.getDrawableObjects()) {
                d.draw(g);
            }
        } else {
            for (Ship s : spil.p2.getShips()) {
                s.draw(g);
            }
            for (Drawable d : spil.p2.getDrawableObjects()) {
                d.draw(g);
            }
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
        helpButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        boardPanel2 = new battleshipeksamen.BoardPanel();
        statsTitle = new javax.swing.JLabel();
        allShots = new javax.swing.JLabel();
        allHits = new javax.swing.JLabel();
        allMiss = new javax.swing.JLabel();
        allAcc = new javax.swing.JLabel();

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
            .addGap(0, 339, Short.MAX_VALUE)
        );
        boardPanel1Layout.setVerticalGroup(
            boardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        helpButton.setBackground(new java.awt.Color(255, 255, 255));
        helpButton.setText("Help!");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setLabel("Next player!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        boardPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boardPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout boardPanel2Layout = new javax.swing.GroupLayout(boardPanel2);
        boardPanel2.setLayout(boardPanel2Layout);
        boardPanel2Layout.setHorizontalGroup(
            boardPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        boardPanel2Layout.setVerticalGroup(
            boardPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        statsTitle.setBackground(new java.awt.Color(255, 255, 255));
        statsTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        statsTitle.setText("Stats");
        statsTitle.setName(""); // NOI18N

        allShots.setBackground(new java.awt.Color(255, 255, 255));
        allShots.setText("Shots:");

        allHits.setBackground(new java.awt.Color(255, 255, 255));
        allHits.setText("Hits:");

        allMiss.setBackground(new java.awt.Color(255, 255, 255));
        allMiss.setText("Miss:");

        allAcc.setBackground(new java.awt.Color(255, 255, 255));
        allAcc.setText("Acc:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(helpButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(278, 278, 278))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boardPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(allShots)
                                .addGap(18, 18, 18)
                                .addComponent(allHits)
                                .addGap(18, 18, 18)
                                .addComponent(allMiss)
                                .addGap(18, 18, 18)
                                .addComponent(allAcc))
                            .addComponent(statsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(helpButton)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boardPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(statsTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(allShots)
                            .addComponent(allHits)
                            .addComponent(allMiss)
                            .addComponent(allAcc))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );

        jButton1.getAccessibleContext().setAccessibleName("nextPlayerButton");
    }// </editor-fold>//GEN-END:initComponents

    private void boardPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardPanel1MousePressed

        Point p = spil.matrixCoordinateOfClick(evt.getPoint(), boardPanel1.getSize()); //Finder ud af hvilken plads i matrixen der klikkes
        if (spil.getPlayer1Turn() == true) {
            spil.checkSquare(p, spil.p1.getShipMatrix());
            if (spil.getPlayer1PlaceShips() == true) {
                spil.placeShip(p, boardPanel1.getLocation(), boardPanel1.getSize());
            } else {
                try {
                    spil.drawSymbol(p, boardPanel1.getLocation(), boardPanel1.getSize());
                    allHits.setText("Hits: " + spil.p1.getShotHit());
                    allShots.setText("Shots: " + spil.p1.getAllShots());
                    allMiss.setText("Missed: " + spil.p1.getShotMissed());
                    allAcc.setText("Acc: " + spil.p1.getAllAcc() + "%");
                } catch (InterruptedException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            spil.checkSquare(p, spil.p2.getShipMatrix());
            if (spil.getPlayer2PlaceShips() == true) {
                spil.placeShip(p, boardPanel1.getLocation(), boardPanel1.getSize());
            } else {
                try {
                    spil.drawSymbol(p, boardPanel1.getLocation(), boardPanel1.getSize());
                } catch (InterruptedException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_boardPanel1MousePressed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        Sounds.PlaySound(Sounds.click);
        spil.showHelp();
    }//GEN-LAST:event_helpButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Sounds.PlaySound(Sounds.click);
        cardLayout.show(parentPanel, "next");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boardPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardPanel2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_boardPanel2MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allAcc;
    private javax.swing.JLabel allHits;
    private javax.swing.JLabel allMiss;
    private javax.swing.JLabel allShots;
    private battleshipeksamen.BoardPanel boardPanel1;
    private battleshipeksamen.BoardPanel boardPanel2;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel statsTitle;
    // End of variables declaration//GEN-END:variables
}
