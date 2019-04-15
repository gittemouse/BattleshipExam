
package battleshipeksamen;

import javax.swing.JFrame;

public class BenytBattleship {

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame();
        GamePanel game = new GamePanel();
        mainWindow.add(game);
        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainWindow.setSize(1000, 1000);
        mainWindow.setVisible(true);
    }
    
}
