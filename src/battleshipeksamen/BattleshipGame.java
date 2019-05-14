package battleshipeksamen;

import java.awt.*;
import javax.swing.JOptionPane;

public class BattleshipGame {

    Player p1;
    Player p2;
    Sounds lyd;

    public Point matrixCoordinateOfClick(Point pPixel, Dimension d) {
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) pPixel.x;
        double py = (float) pPixel.y;
        Point pt = new Point(0, 0);

        pt.x = (int) ((px / dwidth) * 10);
        pt.y = (int) ((py / dheight) * 10);

        return pt;
    }

    public int checkSquare(Point pIndex, int[][] m) {
        int px = pIndex.x;
        int py = pIndex.y;
        System.out.print(px + " ");
        System.out.print(py);
        System.out.println("--- " + m[px][py]);
        return m[px][py];
    }

    public Point[] matrixIndexToPixelCoordinate(Point pIndex, Point offset, Dimension d) {
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) pIndex.x;
        double py = (float) pIndex.y;

        Point[] result = new Point[2];

        Point pPixel1 = new Point((int) ((dwidth / 10) * px) + offset.x, (int) ((dheight / 10) * py) + offset.y);
        Point pPixel2 = new Point((int) ((dwidth / 10) * (px + 1)) + offset.x, (int) ((dheight / 10) * (py + 1)) + offset.y);

        result[0] = pPixel1;
        result[1] = pPixel2;

        return result;
    }

    public void drawSymbol(Point pIndex, Point offset, Dimension d, Player x, Player y) {

        Point A[] = matrixIndexToPixelCoordinate(pIndex, offset, d);

        if (checkSquare(pIndex, x.getShipMatrix()) == -1) {
            System.out.println("Space is empty");
            x.setShipMatrix(pIndex, -2);
            y.setDrawableObjects(A[0], A[1], pIndex, Player.symbolType.CROSS); // MODSATTE PLAYER
            y.setAnimations(A[0], A[1], Player.animationType.SPLASH); // MODSATTE PLAYER
            Sounds.PlaySound(Sounds.splash);
            y.setPlayerTurnUsed(true);
            y.setShotMissed();
            y.setAllShots();            
        }
        if (checkSquare(pIndex, x.getShipMatrix()) >= 0) {
            System.out.println("Ship here");
            x.getShips().get(checkSquare(pIndex, x.getShipMatrix())).decrementHP(); //Find the ship that has been hin and decrement its HP
            x.setShipMatrix(pIndex, -2);
            Sounds.PlaySound(Sounds.explosion);
            y.setAnimations(A[0], A[1], Player.animationType.EXPLOSION); // MODSATTE PLAYER
            y.setDrawableObjects(A[0], A[1], pIndex, Player.symbolType.CIRCLE); // MODSATTE PLAYER
            y.setPlayerTurnUsed(true);
            y.setShotHit();
            y.setAllShots();
        }
    }

    public void placeShip(Point pIndex, Point offset, Dimension d, Player x) {
        Point[] A = matrixIndexToPixelCoordinate(pIndex, offset, d);

        if ((x.getPlayerTurn() == true) && (x.getPlaceShips() == true)) {
            int sizeOfCurrentShip = x.getShips().size() + 2;
            Boolean spaceClear = true;

            try {
                for (int i = 0; i < sizeOfCurrentShip; i++) {
                    if(x.getHorizontal()){
                        if (x.getShipMatrix()[pIndex.x + i][pIndex.y] != -1) {
                            spaceClear = false;
                            break;
                        }
                    }
                    else{
                        if (x.getShipMatrix()[pIndex.x][pIndex.y + i] != -1) {
                            spaceClear = false;
                            break;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("The entire ship must be INSIDE the board");
                spaceClear = false;
            }

            switch (sizeOfCurrentShip) {
                case 2:
                    if (spaceClear == true) {
                        if(x.getHorizontal()){    
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.DESTROYER, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                        else{
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.DESTROYER, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                    }

                    break;
                case 3:
                    if (spaceClear == true) {
                        if(x.getHorizontal()){    
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.SUBMARINE, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                        else{
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.SUBMARINE, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                    }
                    break;
                case 4:
                    if (spaceClear == true) {
                        if(x.getHorizontal()){    
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.CRUISER, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                        else{
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.CRUISER, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                    }
                    break;
                case 5:
                    if (spaceClear == true) {
                        if(x.getHorizontal()){    
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.BATTLESHIP, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                        else{
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.BATTLESHIP, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                    }
                    break;
                case 6:
                    if (spaceClear == true) {
                        if(x.getHorizontal()){    
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.CARRIER, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                        else{
                            for (int i = 0; i < sizeOfCurrentShip; i++) {
                                x.setShipMatrix(new Point(pIndex.x, pIndex.y + i), sizeOfCurrentShip - 2); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                            }
                            x.setShips(A[0], A[1], pIndex, Player.shipType.CARRIER, x.getHorizontal());
                            System.out.println("Spawning Destroyer");
                        }
                    }
                    break;

            }
            if (x.getShips().size() == 5) {
                x.setPlaceShips(false);
            }
        }
    }


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
