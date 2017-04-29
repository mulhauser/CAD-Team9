package bataillenavale.view;

/**
 * Created by mulhauser on 28/04/2017.
 */

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.ship.ShipPiece;
import bataillenavale.model.ship.StatePiece;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Classe privee qui pour chaque case de la grille de placement
 */
public class JLabelBateau extends JLabel {

    // x = colonne du tableau, y = ligne du tableau
    final int posX, posY;
    final BatailleNavale model;


    public JLabelBateau(BatailleNavale model, int x, int y) {
        super();
        this.model = model;
        this.posX = x;
        this.posY = y;
        this.setEnabled(false);
        this.setOpaque(true);
        ShipPiece piece = model.getPartie().getHuman().getMapPerso().getShip(x, y);
        if (piece == null) {
            this.setBackground(Color.BLUE);
        } else if(piece.getState() == StatePiece.MISS){
            this.setBackground(Color.ORANGE);
        }else{
            this.setBackground(Color.RED);
        }
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));


    }
}