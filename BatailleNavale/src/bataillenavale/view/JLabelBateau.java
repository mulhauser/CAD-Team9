package bataillenavale.view;

/**
 * Created by mulhauser on 28/04/2017.
 */

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Map;
import bataillenavale.model.ship.ShipPiece;

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


    public JLabelBateau(BatailleNavale model, int x, int y, Map map) {
        super();
        this.model = model;
        this.posX = x;
        this.posY = y;
        this.setEnabled(false);
        this.setOpaque(true);
        ShipPiece piece = map.getShip(x, y);
        switch (piece.getState()){
            case EMPTY:
                this.setBackground(Color.BLUE);
                break;
            case MISS:
                this.setBackground(Color.YELLOW);
                break;
            case HIT:
                this.setBackground(Color.ORANGE);
                break;
            case DEAD:
                this.setBackground(Color.RED);
                break;
            case FAIL:
                this.setBackground(Color.BLACK);
                break;
        }
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));


    }
}