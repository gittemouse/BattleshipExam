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
import java.awt.Point;
import java.awt.Toolkit;
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
    WaterAnimation water1;
    //WaterAnimation water2;

    public GamePanel(JPanel p) {
        initComponents();
        boardPanelLeft.setOpaque(false);
        boardPanelRight.setOpaque(false);
        this.parentPanel = p;
        cardLayout = (CardLayout) parentPanel.getLayout();
        water1 = new WaterAnimation(new Point(boardPanelLeft.getLocation().x, boardPanelLeft.getLocation().y), new Point(boardPanelLeft.getX() + boardPanelLeft.getWidth(), boardPanelLeft.getY() + boardPanelLeft.getHeight()));
        //water2 = new WaterAnimation(new Point(boardPanelRight.getLocation().x ,boardPanelRight.getLocation().y), new Point(boardPanelRight.getX()+boardPanelRight.getWidth(), boardPanelRight.getY()+boardPanelRight.getHeight()));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundIMG, 0, 0, this.getParent().getWidth(), this.getParent().getHeight(), this);

        g.setColor(Color.cyan);
        g.fillRect(boardPanelLeft.getX(), boardPanelLeft.getY(), boardPanelLeft.getWidth(), boardPanelLeft.getHeight());
        g.fillRect(boardPanelRight.getX(), boardPanelRight.getY(), boardPanelRight.getWidth(), boardPanelRight.getHeight());
        water1.setPosition(new Point(boardPanelLeft.getLocation().x, boardPanelLeft.getLocation().y), new Point(boardPanelLeft.getX() + boardPanelLeft.getWidth(), boardPanelLeft.getY() + boardPanelLeft.getHeight()));
        //water2.setPosition(new Point(boardPanelRight.getLocation().x,boardPanelRight.getLocation().y), new Point(boardPanelRight.getX()+boardPanelRight.getWidth(), boardPanelRight.getY()+boardPanelRight.getHeight()));
        water1.draw(g);

        if (spil.p1.getPlayerTurn() == true) {
            for (Ship s : spil.p1.getShips()) {
                s.setPosition(spil.matrixIndexToPixelCoordinate(s.getMatrixPoint(), boardPanelLeft.getLocation(), boardPanelLeft.getSize())[0],
                        spil.matrixIndexToPixelCoordinate(s.getMatrixPoint(), boardPanelLeft.getLocation(), boardPanelLeft.getSize())[1]);
                s.draw(g);
            }
            for (Drawable d : spil.p1.getDrawableObjects()) {
                d.setPosition(spil.matrixIndexToPixelCoordinate(d.getMatrixPoint(), boardPanelRight.getLocation(), boardPanelRight.getSize())[0],
                        spil.matrixIndexToPixelCoordinate(d.getMatrixPoint(), boardPanelRight.getLocation(), boardPanelRight.getSize())[1]);
                d.draw(g);
            }
            for (Drawable d : spil.p2.getDrawableObjects()) {
                d.setPosition(spil.matrixIndexToPixelCoordinate(d.getMatrixPoint(), boardPanelLeft.getLocation(), boardPanelLeft.getSize())[0],
                        spil.matrixIndexToPixelCoordinate(d.getMatrixPoint(), boardPanelLeft.getLocation(), boardPanelLeft.getSize())[1]);
                d.draw(g);
            }

            for (SpriteAnimation a : spil.p1.getAnimations()) {
                if (a.isDone()) {
                    spil.p1.removeAnimation(a);
                    this.repaint(10);
                } else {
                    a.draw(g);
                }
            }
        }
        if (spil.p2.getPlayerTurn() == true) {
            for (Ship s : spil.p2.getShips()) {
                s.setPosition(spil.matrixIndexToPixelCoordinate(s.getMatrixPoint(), boardPanelLeft.getLocation(), boardPanelLeft.getSize())[0],
                        spil.matrixIndexToPixelCoordinate(s.getMatrixPoint(), boardPanelLeft.getLocation(), boardPanelLeft.getSize())[1]);
                s.draw(g);
            }

            for (Drawable d : spil.p2.getDrawableObjects()) {
                d.setPosition(spil.matrixIndexToPixelCoordinate(d.getMatrixPoint(), boardPanelRight.getLocation(), boardPanelRight.getSize())[0],
                        spil.matrixIndexToPixelCoordinate(d.getMatrixPoint(), boardPanelRight.getLocation(), boardPanelRight.getSize())[1]);
                d.draw(g);
            }
            for (Drawable d : spil.p1.getDrawableObjects()) {
                d.setPosition(spil.matrixIndexToPixelCoordinate(d.getMatrixPoint(), boardPanelLeft.getLocation(), boardPanelLeft.getSize())[0],
                        spil.matrixIndexToPixelCoordinate(d.getMatrixPoint(), boardPanelLeft.getLocation(), boardPanelLeft.getSize())[1]);
                d.draw(g);
            }

            for (SpriteAnimation a : spil.p2.getAnimations()) {
                if (a.isDone()) {
                    spil.p2.removeAnimation(a);
                    this.repaint(10);
                } else {
                    a.draw(g);
                }
            }
        }

        this.repaint(10);
    }

    public void showPlayerTurn() {
        labelPlayerTurn.setForeground(Color.RED);
        if (spil.p1.getPlayerTurn() == true) {
            labelPlayerTurn.setText("PLAYER 1 TURN");
        } else {
            labelPlayerTurn.setText("PLAYER 2 TURN");
        }
    }

    public void updateLabels(Player x) {
        labelAllHits.setText("Hits: " + x.getShotHit());
        labelAllShots.setText("Shots: " + x.getAllShots());
        labelAllMiss.setText("Missed: " + x.getShotMissed());
        labelAllAccuracy.setText("Acc: " + x.getAllAcc() + "%");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boardPanelLeft = new battleshipeksamen.BoardPanel();
        buttonHelp = new javax.swing.JButton();
        buttonNextPlayer = new javax.swing.JButton();
        boardPanelRight = new battleshipeksamen.BoardPanel();
        statsTitle = new javax.swing.JLabel();
        labelAllShots = new javax.swing.JLabel();
        labelAllHits = new javax.swing.JLabel();
        labelAllMiss = new javax.swing.JLabel();
        labelAllAccuracy = new javax.swing.JLabel();
        labelPlayerTurn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 153, 0));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        boardPanelLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boardPanelLeftMousePressed(evt);
            }
        });

        javax.swing.GroupLayout boardPanelLeftLayout = new javax.swing.GroupLayout(boardPanelLeft);
        boardPanelLeft.setLayout(boardPanelLeftLayout);
        boardPanelLeftLayout.setHorizontalGroup(
            boardPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        boardPanelLeftLayout.setVerticalGroup(
            boardPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        buttonHelp.setBackground(new java.awt.Color(255, 255, 255));
        buttonHelp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonHelp.setText("Help!");
        buttonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHelpActionPerformed(evt);
            }
        });

        buttonNextPlayer.setBackground(new java.awt.Color(255, 255, 255));
        buttonNextPlayer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonNextPlayer.setLabel("Next player!");
        buttonNextPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextPlayerActionPerformed(evt);
            }
        });

        boardPanelRight.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                boardPanelRightAncestorResized(evt);
            }
        });
        boardPanelRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boardPanelRightMousePressed(evt);
            }
        });

        javax.swing.GroupLayout boardPanelRightLayout = new javax.swing.GroupLayout(boardPanelRight);
        boardPanelRight.setLayout(boardPanelRightLayout);
        boardPanelRightLayout.setHorizontalGroup(
            boardPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        boardPanelRightLayout.setVerticalGroup(
            boardPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        statsTitle.setBackground(new java.awt.Color(255, 255, 255));
        statsTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        statsTitle.setText("Stats");
        statsTitle.setName(""); // NOI18N

        labelAllShots.setBackground(new java.awt.Color(255, 255, 255));
        labelAllShots.setText("Shots:");

        labelAllHits.setBackground(new java.awt.Color(255, 255, 255));
        labelAllHits.setText("Hits:");

        labelAllMiss.setBackground(new java.awt.Color(255, 255, 255));
        labelAllMiss.setText("Miss:");

        labelAllAccuracy.setBackground(new java.awt.Color(255, 255, 255));
        labelAllAccuracy.setText("Acc:");

        labelPlayerTurn.setText("HEJ HEJ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(boardPanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonNextPlayer)
                    .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(boardPanelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(616, 616, 616)
                        .addComponent(labelPlayerTurn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelAllShots)
                                .addGap(18, 18, 18)
                                .addComponent(labelAllHits)
                                .addGap(18, 18, 18)
                                .addComponent(labelAllMiss)
                                .addGap(18, 18, 18)
                                .addComponent(labelAllAccuracy))
                            .addComponent(statsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelPlayerTurn)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boardPanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buttonNextPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boardPanelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(statsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAllShots)
                    .addComponent(labelAllHits)
                    .addComponent(labelAllMiss)
                    .addComponent(labelAllAccuracy))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        buttonNextPlayer.getAccessibleContext().setAccessibleName("nextPlayerButton");
    }// </editor-fold>//GEN-END:initComponents

    private void boardPanelLeftMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardPanelLeftMousePressed

        Point p = spil.matrixCoordinateOfClick(evt.getPoint(), boardPanelLeft.getSize()); //Finder ud af hvilken plads i matrixen der klikkes
        if (spil.p1.getPlayerTurn() == true) {
            // spil.checkSquare(p, spil.p1.getShipMatrix());
            if (spil.p1.getPlaceShips() == true) {
                spil.placeShip(p, boardPanelLeft.getLocation(), boardPanelLeft.getSize(), spil.p1);
            }
        } else {
            spil.checkSquare(p, spil.p2.getShipMatrix());
            if (spil.p2.getPlaceShips() == true) {
                spil.placeShip(p, boardPanelLeft.getLocation(), boardPanelLeft.getSize(), spil.p2);
            }
        }
    }//GEN-LAST:event_boardPanelLeftMousePressed

    private void buttonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        Sounds.PlaySound(Sounds.click);
        spil.showHelp();
    }//GEN-LAST:event_buttonHelpActionPerformed

    private void buttonNextPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextPlayerActionPerformed
        Sounds.PlaySound(Sounds.click);
        cardLayout.show(parentPanel, "next");
    }//GEN-LAST:event_buttonNextPlayerActionPerformed

    private void boardPanelRightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boardPanelRightMousePressed
        Point p = spil.matrixCoordinateOfClick(evt.getPoint(), boardPanelRight.getSize()); //Finder ud af hvilken plads i matrixen der klikkes
        if (spil.p1.getPlayerTurn() == true && spil.p1.getPlayerTurnUsed() == false) {
            //spil.checkSquare(p, spil.p1.getShipMatrix());
            if (spil.p1.getPlaceShips() == false && spil.p2.getPlaceShips() == false) {
                spil.drawSymbol(p, boardPanelRight.getLocation(), boardPanelRight.getSize(), spil.p2, spil.p1);
                updateLabels(spil.p1);
            }
        } else {
            //spil.checkSquare(p, spil.p2.getShipMatrix());
            if (spil.p2.getPlaceShips() == false && spil.p1.getPlaceShips() == false && spil.p2.getPlayerTurnUsed() == false) {
                spil.drawSymbol(p, boardPanelRight.getLocation(), boardPanelRight.getSize(), spil.p1, spil.p2);
                updateLabels(spil.p2);
            }
        }

        if ((spil.p1.totalHPRemaining() == 0 && spil.p1.getPlaceShips()== false) || (spil.p2.totalHPRemaining() == 0&& spil.p2.getPlaceShips()== false)) {
            cardLayout.show(parentPanel, "winner");
        }

    }//GEN-LAST:event_boardPanelRightMousePressed

    private void boardPanelRightAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_boardPanelRightAncestorResized
        System.out.println("battleshipeksamen.GamePanel.boardPanel2AncestorResized()");// TODO add your handling code here:
    }//GEN-LAST:event_boardPanelRightAncestorResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private battleshipeksamen.BoardPanel boardPanelLeft;
    private battleshipeksamen.BoardPanel boardPanelRight;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonNextPlayer;
    private javax.swing.JLabel labelAllAccuracy;
    private javax.swing.JLabel labelAllHits;
    private javax.swing.JLabel labelAllMiss;
    private javax.swing.JLabel labelAllShots;
    private javax.swing.JLabel labelPlayerTurn;
    private javax.swing.JLabel statsTitle;
    // End of variables declaration//GEN-END:variables
}
