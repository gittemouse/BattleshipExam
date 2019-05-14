package battleshipeksamen;

import java.awt.*;
import javax.swing.JOptionPane;

public class BattleshipGame {

    Player p1;
    Player p2;
    Sounds lyd;

    /**
     * Omregner et Point i pixel til et Point i matricen
     * @param pPixel Pixel koordianat som laves om til matrixkoordianat
     * @param d størrelsen på boardPanel
     * @return koordinat i matricen
     */
    public Point pixelPointToMatrixPoint(Point pPixel, Dimension d) {
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) pPixel.x;
        double py = (float) pPixel.y;
        Point pIndex = new Point(0, 0);

        pIndex.x = (int) ((px / dwidth) * 10);
        pIndex.y = (int) ((py / dheight) * 10);

        return pIndex;
    }
    
/**
 * Tjekker værdien af et Point i matricen
 * @param pIndex Point som skal tjekkes i matricen 
 * @param m Matrix der skal tjekkes
 * @return værdiren af matricen ved det givne punkt
 */
    public int checkMatrixValue(Point pIndex, int[][] m) {
        int px = pIndex.x;
        int py = pIndex.y;

        return m[px][py];
    }

    /**
     * Omregner et Point i matricen til et Punkt i pixel koordianter
     * @param pIndex Point som skal tjekkes i matricen
     * @param offset er boardPanel's koordinater
     * @param d størrelsen på boardPanel
     * @return Et array med 2 Points hvor pPixel 1 er øverste venstre hjørnes koordianter, og pPixel 2 er nederste hjørne hjørnes koordianter
     * i det det som svares til matrix punktet.
     */
    public Point[] matrixPointToPixelPoint(Point pIndex, Point offset, Dimension d) {
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) pIndex.x;
        double py = (float) pIndex.y;

        Point[] pixelPoints = new Point[2];

        Point pPixel1 = new Point((int) ((dwidth / 10) * px) + offset.x, (int) ((dheight / 10) * py) + offset.y);
        Point pPixel2 = new Point((int) ((dwidth / 10) * (px + 1)) + offset.x, (int) ((dheight / 10) * (py + 1)) + offset.y);

        pixelPoints[0] = pPixel1;
        pixelPoints[1] = pPixel2;

        return pixelPoints;
    }

    /**
     * Skyder efter modstanderen, og tjekker omr rammes eller ej
     * @param pIndex Point som skal tjekkes i matricen
     * @param offset boardPanel's koordinater
     * @param d størrelsen på boardPanel
     * @param opponent spilleren der skydes imod
     * @param attacker  spilleren som skyder
     */
    public void Shoot(Point pIndex, Point offset, Dimension d, Player opponent, Player attacker) {

        Point pixelPoint[] = matrixPointToPixelPoint(pIndex, offset, d);

        if (checkMatrixValue(pIndex, opponent.getBoardMatrix()) == -1) {    // Tjekker om feltet tomt
            opponent.setBoardMatrix(pIndex, -2);                            // markerer at felt er ramt
            attacker.setDrawableObjects(pixelPoint[0], pixelPoint[1], pIndex, Player.symbolType.CROSS);
            attacker.setAnimations(pixelPoint[0], pixelPoint[1], Player.animationType.SPLASH);
            Sounds.PlaySound(Sounds.splash);
            attacker.setPlayerTurnUsed(true);
            attacker.setShotMissed();
            attacker.setTotalShots();
        }
        if (checkMatrixValue(pIndex, opponent.getBoardMatrix()) >= 0) {     // Tjekker om der ligger et skib
            opponent.getShips().get(checkMatrixValue(pIndex, opponent.getBoardMatrix())).decrementHP(); //Find the ship that has been hin and decrement its HP
            opponent.setBoardMatrix(pIndex, -2);    // Markerer at felt er ramt
            attacker.setAnimations(pixelPoint[0], pixelPoint[1], Player.animationType.EXPLOSION); // MODSATTE PLAYER
            attacker.setDrawableObjects(pixelPoint[0], pixelPoint[1], pIndex, Player.symbolType.CIRCLE); // MODSATTE PLAYER
            Sounds.PlaySound(Sounds.explosion);
            attacker.setPlayerTurnUsed(true);
            attacker.setShotHit();
            attacker.setTotalShots();
        }
    }

    /**
     * Placerer spillerens egne skibe på boardPanel
     * @param pIndex Point i matricen hvor skibet bliver placeret fra
     * @param offset boardPanel's koordinater
     * @param d størrelsen på boardPanel
     * @param x spilleren som placerer skibet
     */
    public void placeShip(Point pIndex, Point offset, Dimension d, Player x) {

        Point[] pixelPoint = matrixPointToPixelPoint(pIndex, offset, d);

        if ((x.getPlayerTurn() == true) && (x.getPlaceShips() == true)) {   // Tjekker om det er spillerens tur og om spilleren ikke har placeret alle skibene
            int sizeOfCurrentShip = x.getShips().size() + 2; // sætter sizeOfCurrentShip lig med størrelsen af spillerens "ships" arrayliste + 2 da det svarer til størrelsen på det skib der skal placerers
            Boolean spaceClear = true;

            try {
                for (int i = 0; i < sizeOfCurrentShip; i++) { // for-lykken tjækker om pladserne i matricen, der hvor skibet skal placerers, er frit.
                    if (x.getHorizontal()) { // hvis horizontal er true så tjæk vandret...
                        if (x.getBoardMatrix()[pIndex.x + i][pIndex.y] != -1) {
                            spaceClear = false;
                            break;
                        }
                    } else { // ...ellers tjæk lodret
                        if (x.getBoardMatrix()[pIndex.x][pIndex.y + i] != -1) {
                            spaceClear = false;
                            break;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) { // hvis skibet ville blive placeret uden for matricen vil løkken given en indexOutOfBounds exception. denne catches her
                e.printStackTrace();
                System.out.println("The entire ship must be INSIDE the board");
                spaceClear = false;
            }

            switch (sizeOfCurrentShip) { //en switch der placerer skibe efter hvilken størrelse der er givet
                case 2:
                    if (spaceClear == true) { // hvis vi har tjækket at der er fri bane, placer skibet
                        if (x.getHorizontal()) { // player.horizontal = true, placer skibet vandret...
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.DESTROYER, x.getHorizontal());
                            x.setNextShip(new Submarine(new Point(0, 0), new Point(0, 0)));
                        } else { // ...ellers placer det lodret
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.DESTROYER, x.getHorizontal());
                            x.setNextShip(new Submarine(new Point(0, 0), new Point(0, 0)));
                        }
                    }

                    break;
                case 3:
                    if (spaceClear == true) { // hvis vi har tjækket at der er fri bane, placer skibet
                        if (x.getHorizontal()) { // player.horizontal = true, placer skibet vandret...
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.SUBMARINE, x.getHorizontal());
                            x.setNextShip(new Cruiser(new Point(0, 0), new Point(0, 0)));
                        } else { // ...ellers tjæk lodret
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.SUBMARINE, x.getHorizontal());
                            x.setNextShip(new Cruiser(new Point(0, 0), new Point(0, 0)));
                        }
                    }
                    break;
                case 4:
                    if (spaceClear == true) { // hvis vi har tjækket at der er fri bane, placer skibet
                        if (x.getHorizontal()) { // player.horizontal = true, placer skibet vandret...
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.CRUISER, x.getHorizontal());
                            x.setNextShip(new Battleship(new Point(0, 0), new Point(0, 0)));
                        } else { // ...ellers tjæk lodret
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.CRUISER, x.getHorizontal());
                            x.setNextShip(new Battleship(new Point(0, 0), new Point(0, 0)));
                        }
                    }
                    break;
                case 5:
                    if (spaceClear == true) { // hvis vi har tjækket at der er fri bane, placer skibet
                        if (x.getHorizontal()) { // player.horizontal = true, placer skibet vandret...
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.BATTLESHIP, x.getHorizontal());
                            x.setNextShip(new Carrier(new Point(0, 0), new Point(0, 0)));
                        } else { // ...ellers tjæk lodret
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.BATTLESHIP, x.getHorizontal());
                            x.setNextShip(new Carrier(new Point(0, 0), new Point(0, 0)));
                        }
                    }
                    break;
                case 6:
                    if (spaceClear == true) { // hvis vi har tjækket at der er fri bane, placer skibet
                        if (x.getHorizontal()) { // player.horizontal = true, placer skibet vandret...
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.CARRIER, x.getHorizontal());
                            x.setNextShip(new Ship(new Point(0, 0), new Point(0, 0)));
                        } else { // ...ellers tjæk lodret
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setBoardMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(pixelPoint[0], pixelPoint[1], pIndex, Player.shipType.CARRIER, x.getHorizontal());
                            x.setNextShip(new Ship(new Point(0, 0), new Point(0, 0)));
                        }
                    }
                    break;
            }
            if (x.getShips().size() == 5) { // Tjekker om alle skibene er blevet placeret
                x.setPlaceShips(false); // fjerner mulighed for at placere skibe
            }
        }
    }

    /**
     * 
     * @return om alle skibene er blevet placeret for begge spillere 
     */
    public boolean checkAllShipsPlaced() {
        boolean checkAllShipsPlaced = true;
        if (p1.getPlayerTurn() == true && p1.getPlaceShips() == true) {
            JOptionPane.showMessageDialog(null, "Please place all your ships");
            checkAllShipsPlaced = false;
        } else {
            if (p1.getPlayerTurn() == false && p2.getPlaceShips() == true) {
                JOptionPane.showMessageDialog(null, "Please place all your ships");
                checkAllShipsPlaced = false;
            }
        }
        return checkAllShipsPlaced;
    }
    
/**
 * Help knap i GUI
 */
    public void showHelp() {
        JOptionPane.showMessageDialog(null, "RULES" + "\n"
                + "\n"
                + "1. Place your ships" + "\n"
                + "2. Start guessing where your opponent have placed their ships" + "\n"
                + "3. Sink your oppenent's ships before they sink yours" + "\n"
                + "\n"
                + "You click with the mouse to use any buttons or guess on the board when it's your turn" + "\n"
                + "You can see your score at the bottom of the board" + "\n"
                + "\n"
                + "GOOD LUCK!" + "\n"
                + "Your fleet depends on you!", "Help", JOptionPane.INFORMATION_MESSAGE);
    }

}
