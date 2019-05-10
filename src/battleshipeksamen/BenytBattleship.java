package battleshipeksamen;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

public class BenytBattleship {
    
    public static void setFullScreen(JFrame frame){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice dev = env.getDefaultScreenDevice();
		frame.setName("Batteship Game");
                frame.setTitle("Battleship Game");
                frame.setUndecorated(true);
		dev.setFullScreenWindow(frame);
    }

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame();
        GamePanel game = new GamePanel();
        setFullScreen(mainWindow);
        mainWindow.add(game);
        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //mainWindow.setSize(1080, 800);
        mainWindow.setVisible(true);

        Player p1 = new Player();
        Player p2 = new Player();

        BattleshipGame spillet = new BattleshipGame();
        spillet.p1 = p1;
        spillet.p2 = p2;
        game.spil = spillet;

    }

}
