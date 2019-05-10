package battleshipeksamen;

import javax.swing.JFrame;

public class BenytBattleship {

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame();
        GamePanel game = new GamePanel();
        mainWindow.add(game);
        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainWindow.setSize(1080, 800);
        mainWindow.setVisible(true);

        Player p1 = new Player();
        Player p2 = new Player();
        Sounds lyd=new Sounds();

        BattleshipGame spillet = new BattleshipGame();
        spillet.p1 = p1;
        spillet.p2 = p2;
        spillet.lyd=lyd;
        game.spil = spillet;

    }

}
