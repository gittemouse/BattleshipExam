package battleshipeksamen;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BenytBattleship {

    public static void main(String[] args) {

        JFrame mainWindow = new JFrame("BattleShip");
        JPanel parentPanel = new JPanel();
        CardLayout card = new CardLayout();

        parentPanel.setLayout(card);
        GamePanel game = new GamePanel(parentPanel);
        NextPlayer next = new NextPlayer(parentPanel);
        WinnerPanel winner = new WinnerPanel(parentPanel);

        parentPanel.add(game, "game");
        parentPanel.add(next, "next");
        parentPanel.add(winner, "winner");

        mainWindow.add(parentPanel);

        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainWindow.setPreferredSize(new Dimension(1280, 720));
        mainWindow.pack();
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);

        Player p1 = new Player();
        Player p2 = new Player();
        Sounds lyd = new Sounds();
        Sounds.initSounds();

        BattleshipGame spillet = new BattleshipGame();
        spillet.p1 = p1;
        spillet.p2 = p2;
        spillet.lyd = lyd;
        game.spil = spillet;
        next.spil = spillet;
        winner.spil = spillet;
    }
}
