package battleshipeksamen;
import java.awt.*;

public class BoardPanel extends javax.swing.JPanel {

    Image gridImg = Toolkit.getDefaultToolkit().getImage("10x10grid.png");
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(gridImg, 0, 0, getWidth(), getHeight(), this);    // Tegner 10x10 graid
    }
      
    public BoardPanel() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
