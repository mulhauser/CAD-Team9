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
import java.util.Observable;
import java.util.Observer;

/**
 * Classe privee qui pour chaque case de la grille de placement
 */
public class JLabelBateau extends JLabel implements Observer {

    // x = colonne du tableau, y = ligne du tableau
    final int posX, posY;
    final BatailleNavale model;


    public JLabelBateau(BatailleNavale model, int x, int y) {
        super();
        model.addObserver(this);
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

    @Override
    public void update(Observable o, Object arg) {
        // modifier couleur bouton quand bateau placé

        //System.out.println(model.getPartie().getHuman().getMapPerso().toString());
    }
}