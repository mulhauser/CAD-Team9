package bataillenavale.model.ship;

import bataillenavale.model.Coordinate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Ship {

    /**
     * taille petit = 2
     * taille moyen 3
     * taille grand 4
     */
    //private int live;
    //private boolean alive = true;
    private int size;
    private String nom;
    private Coordinate coordinate;
    private Orientation orientation;
    private BufferedImage image;

    public enum Orientation {
        TOP,
        VERTICAL,
        HORIZONTAL,
        LEFT
    }

    private List<ShipPiece> pieceShipList;

    public Ship(String n, int s) {
        //this.live = l;
        try {
            this.nom = n;
            this.size = s;

            // Construction de l'image du bateau de base
            this.image = ImageIO.read(new File("./BatailleNavale/img/1.png"));

            pieceShipList = new ArrayList<ShipPiece>(size);
            for (int i = 0; i < this.size; i++) {
                pieceShipList.add(new ShipPiece(this));
                // On construit l'image selon sa taille
                if(i < this.size - 1) {
                    BufferedImage img2 = ImageIO.read(new File("./BatailleNavale/img/1.png"));
                    this.image = joinBufferedImage(this.image, img2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getSize() {
        return this.size;
    }

    public List<ShipPiece> getPieceShipList() {
        return this.pieceShipList;
    }

    public void setOrientation(Orientation o) {
        this.orientation = o;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void setCoordinate(Coordinate c) {
        this.coordinate = c;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public BufferedImage getImage(){
        return this.image;
    }

    public void setImage(BufferedImage img){
        this.image = img;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String n){
        this.nom = n;
    }

    public boolean isDestroy() {
        boolean res = true;
        for (ShipPiece sp : pieceShipList) {
            if (sp.getState() == StatePiece.MISS) {
                res = false;
                break;
            }
        }
        return res;
    }

    public BufferedImage joinBufferedImage(BufferedImage img1, BufferedImage img2) {

        //do some calculate first
        int offset = 5;
        int wid = img1.getWidth() + img2.getWidth() - 1;
        int height = Math.max(img1.getHeight(), img2.getHeight());
        //create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(wid, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        //fill background
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, wid, height);
        //draw image
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth() - 1, 0);
        g2.dispose();
        return newImage;
    }
}
