
package battleshipeksamen;

import java.awt.*;
import javax.swing.JPanel;


public class NextPlayer extends javax.swing.JPanel {
    Image NextPlayerPic = Toolkit.getDefaultToolkit().getImage("NextPlayerPic.jpg");
    CardLayout cardLayout;
    JPanel parentPanel;
    BattleshipGame spil2;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(NextPlayerPic, 0, 0, getWidth(), getHeight(), this);
        
    }
    public NextPlayer(JPanel p) {
        initComponents();
        this.parentPanel = p;
        cardLayout = (CardLayout) parentPanel.getLayout();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nextButton = new javax.swing.JButton();

        nextButton.setBackground(new java.awt.Color(255, 255, 255));
        nextButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nextButton.setText("Next player");
        nextButton.setToolTipText("");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(nextButton)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
         cardLayout.show(parentPanel,"game");
        System.out.println("You have clicked the button for next player");
        if (spil2.getPlayer1Turn()== true) {
            spil2.setPlayer1Turn(false);
        }
        else {
            spil2.setPlayer1Turn(true);
        }
    }//GEN-LAST:event_nextButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton nextButton;
    // End of variables declaration//GEN-END:variables
}
