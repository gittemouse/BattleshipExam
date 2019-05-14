package battleshipeksamen;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private int[][] boardMatrix = new int[10][10];                               // Matrice som passer til spillepladen
    private ArrayList<Ship> ships = new ArrayList<Ship>();                      // Indeholder liste over skibe 
    private ArrayList<Drawable> drawableObjects = new ArrayList<Drawable>();    // Indeholder liste over krydser/cirkler
    private ArrayList<SpriteAnimation> animations = new ArrayList<SpriteAnimation>(); // Indeholder liste over animation
    private Boolean placeShips = true; // Tjekker om man kan placere skibe
    private Boolean playerTurn = true; // Tjekker om det er spillerens tur
    private Boolean playerTurnUsed = false; // Tjekker om spilleren har brugt sin tur 
    private Boolean horizontal = true;      // Til at styre orientering af skibets placering
    private Ship nextShip = new Destroyer(new Point(0, 0), new Point(0, 0));

    private float shotHit = 0;
    private float shotMissed = 0;
    private float totalShots = 0;
    private float totalAccuracy = 0;

    /**
     * @return Om en spiller har brugt sin tur.
     */
    public Boolean getPlayerTurnUsed() {
        return playerTurnUsed;
    }

    /**
     *
     * @param playerTurnUsed
     */
    public void setPlayerTurnUsed(Boolean playerTurnUsed) {
        this.playerTurnUsed = playerTurnUsed;
    }

    /**
     *
     * @return Om det er spillerens tur
     */
    public Boolean getPlayerTurn() {
        return playerTurn;
    }

    /**
     *
     * @param playerTurn
     */
    public void setPlayerTurn(Boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    /**
     *
     * @return Om en spiller kan placere skibe
     */
    public Boolean getPlaceShips() {
        return placeShips;
    }

    /**
     *
     * @param PlaceShips
     */
    public void setPlaceShips(Boolean PlaceShips) {
        placeShips = PlaceShips;
    }

    /**
     * Udregner det total antal skudforsøg
     */
    public void setTotalShots() {
        totalShots = shotHit + shotMissed;
    }

    /**
     *
     * @return Total antal skud brugt
     */
    public float getTotalShots() {
        return totalShots;
    }

    /**
     * Opdaterer antal af skud med 1
     */
    public void setShotHit() {
        shotHit = shotHit + 1;
    }

    /**
     * @return antal af skud der har ramt
     */
    public float getShotHit() {
        return shotHit;
    }

    /**
     * @return antal skud som ikke har ramt
     */
    public float getShotMissed() {
        return shotMissed;
    }

    /**
     * Opdaterer antal skud som man ikke har ramt med 1
     */
    public void setShotMissed() {
        shotMissed = shotMissed + 1;
    }

    /**
     * @return skud nøjagtighed
     */
    public float getTotalAccuracy() {
        if (totalShots > 0) {
            totalAccuracy = (shotHit / totalShots) * 100;
        }
        return totalAccuracy;
    }

    // Fylder spillerens matrix op med -1
    public Player() {
        for (int[] row : boardMatrix) {
            Arrays.fill(row, -1);
        }
    }

    /**
     * @return værdien matrice
     */
    public int[][] getBoardMatrix() {
        return boardMatrix;
    }

    /**
     *
     * @param pIndex Punkt i matricen
     * @param value Værdi der skal sættes i matricen
     */
    public void setBoardMatrix(Point pIndex, int value) {
        boardMatrix[pIndex.x][pIndex.y] = value;
    }

    /**
     *
     * @return hele liste over skibene
     */
    public ArrayList<Ship> getShips() {
        return ships;
    }

    /**
     *
     * @return liste over alle symboler
     */
    public ArrayList<Drawable> getDrawableObjects() {
        return drawableObjects;
    }

    /**
     * Udregner hvornår alle skibene er sunket
     *
     * @return antal liv spilleren har tilbage
     */
    public int totalHPRemaining() {
        int result = 0;
        for (Ship s : ships) {
            result += s.hp;
        }
        return result;
    }

    /**
     *
     */
    public enum symbolType {
        CROSS, CIRCLE
    }

    /**
     *
     */
    public enum animationType {
        EXPLOSION, SPLASH
    }

    /**
     *
     * @param pPixel1 Øverste vestste hjørne punkt i pixel koordinater
     * @param pPixel2 Nederste højre hjørne punkt i pixel koordianter
     * @param pIndex punktet i matricen i matrix koordianter
     * @param symbol Om det er en cirkel eller kryds der skal tegnes
     */
    public void setDrawableObjects(Point pPixel1, Point pPixel2, Point pIndex, symbolType symbol) {
        switch (symbol) {
            case CROSS:
                this.drawableObjects.add(new Cross(pPixel1, pPixel2, pIndex));
                break;
            case CIRCLE:
                this.drawableObjects.add(new Circle(pPixel1, pPixel2, pIndex));
                break;
        }
    }

    /**
     *
     */
    public enum shipType {
        DESTROYER, SUBMARINE, CRUISER, BATTLESHIP, CARRIER
    }

    /**
     *
     * @param pPixel1 Øverste vestste hjørne punkt i pixel koordinater
     * @param pPixel2 Nederste højre hjørne punkt i pixel koordianter
     * @param pIndex punktet i matricen i matrix koordianter
     * @param ship Type af skib der skal tilføjes
     * @param horiz Hvilken retning skibet skal vende
     */
    public void setShips(Point pPixel1, Point pPixel2, Point pIndex, shipType ship, Boolean horiz) {
        switch (ship) {
            case DESTROYER:
                this.ships.add(new Destroyer(pPixel1, pPixel2, pIndex, horiz));
                break;
            case SUBMARINE:
                this.ships.add(new Submarine(pPixel1, pPixel2, pIndex, horiz));
                break;
            case CRUISER:
                this.ships.add(new Cruiser(pPixel1, pPixel2, pIndex, horiz));
                break;
            case BATTLESHIP:
                this.ships.add(new Battleship(pPixel1, pPixel2, pIndex, horiz));
                break;
            case CARRIER:
                this.ships.add(new Carrier(pPixel1, pPixel2, pIndex, horiz));
                break;
        }
    }

    /**
     *
     * @param pPixel1 Øverste vestste hjørne punkt i pixel koordinater
     * @param pPixel2 Nederste højre hjørne punkt i pixel koordianter
     * @param animation Hvilken animation der skal tegnes
     */
    public void setAnimations(Point pPixel1, Point pPixel2, animationType animation) {
        switch (animation) {
            case EXPLOSION:
                animations.add(new Explosion(pPixel1, pPixel2));
                break;
            case SPLASH:
                animations.add(new Splash(pPixel1, pPixel2));
        }
    }

    /**
     *
     * @return liste over animationer
     */
    public ArrayList<SpriteAnimation> getAnimations() {
        return animations;
    }

    /**
     *
     * @param a fjerner animationen når den er færdig med at køre
     */
    public void removeAnimation(SpriteAnimation a) {
        animations.remove(a);
    }

    /**
     *
     * @return Finder hvilken retning skibet skal placeres
     */
    public Boolean getHorizontal() {
        return horizontal;
    }

    /**
     * Skifter regning på placering af skib
     */
    public void toggleHorizontal() {
        horizontal = !horizontal;
    }

    /**
     *
     * @return Viser hvilket skib der bliver placeret, næste gang et skib skal
     * tegnes
     */
    public Ship getNextShip() {
        return nextShip;
    }

    /**
     *
     * @param pPixel1 Øverste vestste hjørne punkt i pixel koordinater
     * @param pPixel2 Nederste højre hjørne punkt i pixel koordianter
     * @param horiz sætter retningen på "nextShip" skibet.
     */
    public void setNextShipPos(Point pPixel1, Point pPixel2, Boolean horiz) {
        nextShip.setPosition(pPixel1, pPixel2, horiz);
    }

    /**
     *
     * @param nextShip det næste skib der skal tegnes
     */
    public void setNextShip(Ship nextShip) {
        this.nextShip = nextShip;
    }
}
