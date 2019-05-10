
package battleshipeksamen;

import java.awt.*;

public class BattleshipGame {

    Player p1;
    Player p2;
    Sounds lyd;

    private Boolean player1 = true;
    private Boolean player2 = true;
    private Boolean mode1 = true;
    private Boolean mode2 = true;

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

    public void drawSymbol(Point pIndex, Point offset, Dimension d) {

        int A[] = matrixIndexToPixelCoordinate(pIndex, offset, d);

        if ((player1 == true) && (mode2 == true)) {
            if (checkSquare(pIndex, p1.getShipMatrix()) == -1) {
                System.out.println("Space is empty");
                p1.setShipMatrix(pIndex, -2);
                p1.setDrawableObjects(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.symbolType.CROSS);
                Sounds.PlaySound(Sounds.splash);
                p1.setShotHit();
                System.out.print(A[0] + " ");
                System.out.print(A[1] + ": ");
                System.out.print(A[2] + " ");
                System.out.print(A[3] + " ");
            }
            if (checkSquare(pIndex, p1.getShipMatrix()) >= 0) {
                System.out.println("Ship here");
                p1.setShipMatrix(pIndex, -2);
                p1.setDrawableObjects(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.symbolType.CIRCLE);
                Sounds.PlaySound(Sounds.explosion);
                p1.setShotMissed();
                System.out.print(A[0] + " ");
                System.out.print(A[1] + ": ");
                System.out.print(A[2] + " ");
                System.out.print(A[3] + " ");
            } else {
                System.out.println("Space is taken");
            }
        } else {
            if (checkSquare(pIndex, p2.getShipMatrix()) == -1) {
                System.out.println("Space is empty");
                p2.setShipMatrix(pIndex, -2);
                p2.setDrawableObjects(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.symbolType.CROSS);
                System.out.print(A[0] + " ");
                System.out.print(A[1] + ": ");
                System.out.print(A[2] + " ");
                System.out.print(A[3] + " ");
            }
            if (checkSquare(pIndex, p2.getShipMatrix()) >= 0) {
                System.out.println("Ship here");
                p2.setShipMatrix(pIndex, -2);
                p2.setDrawableObjects(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.symbolType.CIRCLE);
                System.out.print(A[0] + " ");
                System.out.print(A[1] + ": ");
                System.out.print(A[2] + " ");
                System.out.print(A[3] + " ");
            } else {
                System.out.println("Space is taken");
            }
        }

    }

    public void placeShip(Point pIndex, Point offset, Dimension d) {
        int[] A = matrixIndexToPixelCoordinate(pIndex, offset, d);

        if ((player1 == true) && (mode1 == true)) {
            //int random = (int) (Math.round(Math.random()) % 5);
            p1.setShipMatrix(pIndex, p1.getShips().size()+1);

            //p1.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.DESTROYER);
            p1.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.CARRIER);
            //p1.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.CRUISER);
            //p1.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.SUBMARINE);
            //p1.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.BATTLESHIP);
            
            
        } else {
            p2.setShipMatrix(pIndex, 1);

            p2.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.DESTROYER);
            p2.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.CARRIER);
            p2.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.CRUISER);
            p2.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.SUBMARINE);
            p2.setShips(new Point(A[0], A[1]), new Point(A[2], A[3]), Player.shipType.BATTLESHIP);
        }
    }
    

}
