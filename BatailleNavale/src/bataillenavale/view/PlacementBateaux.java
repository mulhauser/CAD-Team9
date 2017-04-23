package bataillenavale.view;

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.ship.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 23/04/2017.
 */
public class PlacementBateaux extends JPanel implements Observer{

    public static final String id = "placement";
    private JList<Ship> shipJList;
    private JPanel grille;
    private JPanel ships;
    private JPanel buttons;
    //private JLabel bigBoat;
    private int size;
    private JButtonBateau[][] listButton;

    private class JButtonBateau extends JButton implements Observer{

        // x = colonne du tableau, y = ligne du tableau
        final int posX, posY;
        final BatailleNavale model;
        public JButtonBateau(BatailleNavale model, int x, int y){
            super();
            this.model = model;
            this.posX = x;
            this.posY = y;
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

        @Override
        public void update(Observable o, Object arg) {
            // modifier couleur bouton quand bateau placé
        }
    }

    public PlacementBateaux(final BatailleNavale model, final JPanelCards card){
        super(new BorderLayout());
        model.addObserver(this);
        this.size = model.getHuman().getMapPerso().getSize();
        grille = new JPanel(new GridLayout(size,size));
        ships = new JPanel(new GridLayout(4,3));
        buttons = new JPanel(new GridLayout(1,2));
        listButton = new JButtonBateau[size][size];

        // On créer la grille de boutons pour le positionnement des bateaux
        for(int y = 0; y < listButton.length; y ++){
            for(int x = 0; x < listButton[y].length; x++){
                JButtonBateau btn = new JButtonBateau(model, x, y);
                listButton[y][x] = btn;
                grille.add(btn);
            }
        }
        add(grille, BorderLayout.CENTER);

        // Menu des boutons en bas
        JButton backToCreer = new JButton("retour");
        backToCreer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //state = NOTHING_SELECTED;
                card.show(CreationPartie.id);
            }
        });
        buttons.add(backToCreer);

        JButton valider = new JButton("valider");
        valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // on dit au bot de placer ses bateaux
                //((Bot)model.getJ2()).placerBateaux(bateauxChoisis);

                //wizard.getJpanelJouer().initialize();
                //wizard.show(JPanelJouer.id);
            }
        });
        buttons.add(valider);
        add(buttons, BorderLayout.SOUTH);

        // Menu des bateaux à droite


        add(ships, BorderLayout.EAST);

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
