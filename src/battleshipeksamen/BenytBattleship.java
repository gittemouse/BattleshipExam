package battleshipeksamen;

import java.awt.CardLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BenytBattleship {

    public static void setFullScreen(JFrame frame) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice dev = env.getDefaultScreenDevice();
        frame.setName("Batteship Game");
        frame.setTitle("Battleship Game");
        frame.setUndecorated(true);
        dev.setFullScreenWindow(frame);
    }

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("BattleShip (alpha v. 1.2)");
        JPanel parentPanel = new JPanel();
        CardLayout card = new CardLayout();

        parentPanel.setLayout(card);
        GamePanel game = new GamePanel(parentPanel);
        NextPlayer next = new NextPlayer(parentPanel);
        WinnerPanel winner = new WinnerPanel(parentPanel);
        //setFullScreen(mainWindow);

        parentPanel.add(game, "game");
        parentPanel.add(next, "next");

        mainWindow.add(parentPanel);

        //mainWindow.add(game);
        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //mainWindow.setSize(1080, 800);
        mainWindow.setVisible(true);
        // card.show(parentPanel, "next");

        Player p1 = new Player();
        Player p2 = new Player();
        Sounds lyd = new Sounds();

        BattleshipGame spillet = new BattleshipGame();
        spillet.p1 = p1;
        spillet.p2 = p2;
        spillet.lyd = lyd;
        game.spil = spillet;
        next.spil = spillet;
        winner.spil = spillet;

    }

}
