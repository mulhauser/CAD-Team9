package bataillenavale.view;

/**
 * Created by Laurent on 28/04/2017.
 */

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Map;
import bataillenavale.model.ship.ShipPiece;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe privee contenant la grille de placement des bateaux
 */
public class JPanelGrille extends JPanel implements Observer {

    private JLabelBateau[][] listButton;
    private static BatailleNavale model;
    private static int size;
    private Map map;

    public JPanelGrille(BatailleNavale model, int size, Map map) {
        super(new GridLayout(size + 1, size + 1));
        this.model=model;
        this.size = size;
        this.map = map;
        model.addObserver(this);
        listButton = new JLabelBateau[size][size];
        // On créer la grille de boutons pour le positionnement des bateaux
        this.add(new JLabel("", SwingConstants.CENTER));
        this.add(new JLabel("A", SwingConstants.CENTER));
        this.add(new JLabel("B", SwingConstants.CENTER));
        this.add(new JLabel("C", SwingConstants.CENTER));
        this.add(new JLabel("D", SwingConstants.CENTER));
        this.add(new JLabel("E", SwingConstants.CENTER));
        this.add(new JLabel("F", SwingConstants.CENTER));
        this.add(new JLabel("G", SwingConstants.CENTER));
        this.add(new JLabel("H", SwingConstants.CENTER));
        this.add(new JLabel("I", SwingConstants.CENTER));
        this.add(new JLabel("J", SwingConstants.CENTER));
        for (int y = 0; y < size; y++) {
            this.add(new JLabel(Integer.toString(y), SwingConstants.CENTER));
            for (int x = 0; x < size; x++) {
                JLabelBateau btn = new JLabelBateau(model, x, y, this.map);
                listButton[y][x] = btn;
                this.add(btn);
            }

        }
    }

    @Override
    public void update(Observable o, Object arg) {

        ShipPiece[][] tabMap = this.map.getMapDispositionBateaux();
        for (int x = 0; x < tabMap.length; x++) {
            for (int y = 0; y < tabMap[x].length; y++) {
                switch (tabMap[y][x].getState()){
                    case EMPTY:
                        listButton[y][x].setBackground(Color.BLUE);
                        break;
                    case MISS:
                        listButton[y][x].setBackground(Color.ORANGE);
                        break;
                    case HIT:
                        listButton[y][x].setBackground(Color.RED);
                        break;
                    case FAIL:
                        listButton[y][x].setBackground(Color.BLACK);
                        break;
                }
            }
        }
    }

}