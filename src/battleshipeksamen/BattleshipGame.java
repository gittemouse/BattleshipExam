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

    public int[] matrixIndexToPixelCoordinate(Point pIndex, Point offset, Dimension d) {
        double dwidth = (float) d.width;
        double dheight = (float) d.height;
        double px = (float) pIndex.x;
        double py = (float) pIndex.y;

        int[] result = new int[4];

        int x1 = (int) ((dwidth / 10) * px) + offset.x;
        int y1 = (int) ((dheight / 10) * py) + offset.y;
        int x2 = (int) ((dwidth / 10) * (px + 1)) + offset.x;
        int y2 = (int) ((dheight / 10) * (py + 1)) + offset.y;

        result[0] = x1;
        result[1] = y1;
        result[2] = x2;
        result[3] = y2;

        return result;
    }

    public void drawSymbol(Point pIndex, Point offset, Dimension d, Player x) throws InterruptedException {

        int A[] = matrixIndexToPixelCoordinate(pIndex, offset, d);

        if (x.getPlayerTurn() == true) {
            if (checkSquare(pIndex, x.getShipMatrix()) == -1) {
                System.out.println("Space is empty");
                x.setShipMatrix(pIndex, -2);
                
                x.setDrawableObjects(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.symbolType.CROSS);
                x.setAnimations(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.animationType.SPLASH);
                Sounds.PlaySound(Sounds.splash);
                x.setShotMissed();
                x.setAllShots();
                x.setAllAcc();
                System.out.print(A[0] + " ");
                System.out.print(A[1] + ": ");
                System.out.print(A[2] + " ");
                System.out.print(A[3] + " ");
            }
            if (checkSquare(pIndex, x.getShipMatrix()) >= 0) {
                System.out.println("Ship here");
                x.setShipMatrix(pIndex, -2);
                Sounds.PlaySound(Sounds.hit);
                Thread.sleep(1500);
                x.setAnimations(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.animationType.EXPLOSION);
                x.setDrawableObjects(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.symbolType.CIRCLE);
                x.setShotHit();
                x.setAllShots();
                x.setAllAcc();
                System.out.print(A[0] + " ");
                System.out.print(A[1] + ": ");
                System.out.print(A[2] + " ");
                System.out.print(A[3] + " ");
            } else {
                System.out.println("Space is taken");
            }
        }
    }

    public void placeShip(Point pIndex, Point offset, Dimension d, Player x) {
        int[] A = matrixIndexToPixelCoordinate(pIndex, offset, d);

        if ((x.getPlayerTurn() == true) && (x.getPlaceShips() == true)) {
            //int random = (int) (Math.round(Math.random()) % 5);
            int sizeOfCurrentShip = x.getShips().size() + 2;
            Boolean spaceClear = true;

            try {
                for (int i = 0; i < sizeOfCurrentShip; i++) {
                    if (x.getShipMatrix()[pIndex.x + i][pIndex.y] != -1) {
                        spaceClear = false;
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("The entire ship must be INSIDE the board");
                spaceClear = false;
            }

            switch (sizeOfCurrentShip) {
                case 2:
                    if (spaceClear == true) {
                        for (int i = 0; i < sizeOfCurrentShip; i++) {
                            x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 1); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                        }
                        x.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.DESTROYER);
                        System.out.println("Spawning Destroyer");
                    }

                    break;
                case 3:
                    if (spaceClear == true) {
                        for (int i = 0; i < sizeOfCurrentShip; i++) {
                            x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 1); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                        }
                        x.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.SUBMARINE);
                        System.out.println("Spawning Submarine");
                    }
                    break;
                case 4:
                    if (spaceClear == true) {
                        for (int i = 0; i < sizeOfCurrentShip; i++) {
                            x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 1); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                        }
                        x.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.CRUISER);
                        System.out.println("Spawning Cruiser");
                    }
                    break;
                case 5:
                    if (spaceClear == true) {
                        for (int i = 0; i < sizeOfCurrentShip; i++) {
                            x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 1); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                        }
                        x.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.BATTLESHIP);
                        System.out.println("Spawning Battleship");
                    }
                    break;
                case 6:
                    if (spaceClear == true) {
                        for (int i = 0; i < sizeOfCurrentShip; i++) {
                            x.setShipMatrix(new Point(pIndex.x + i, pIndex.y), sizeOfCurrentShip - 1); //sets the value of of the tiles, which the ship occupies, equal to the ships index in p1.ships
                        }
                        x.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.CARRIER);
                        System.out.println("Spawning Carrier");
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
