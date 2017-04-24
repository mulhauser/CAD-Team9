package bataillenavale.view;

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.ship.Ship;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 23/04/2017.
 */
public class PlacementBateaux extends JPanel implements Observer {

    public static final String id = "placement";
    private JList<Ship> shipJList;
    private JPanel grille;
    private JPanel ships;
    private JPanel buttons;

    private JLabel bigShip;
    private JButton bigH;
    private JButton bigV;

    private JLabel mediumShip;
    private JButton mediumH;
    private JButton mediumV;

    private JLabel mediumShipBis;
    private JButton mediumHBis;
    private JButton mediumVBis;

    private JLabel smallShip;
    private JButton smallH;
    private JButton smallV;

    private int size;
    private JButtonBateau[][] listButton;
    private BatailleNavale model;

    private class JButtonBateau extends JButton implements Observer {

        // x = colonne du tableau, y = ligne du tableau
        final int posX, posY;
        final BatailleNavale model;

        public JButtonBateau(BatailleNavale model, int x, int y) {
            super();
            this.model = model;
            this.posX = x;
            this.posY = y;
            this.setEnabled(false);
            try {
                BufferedImage buttonIcon = ImageIO.read(new File("./BatailleNavale/img/ocean.png"));
                this.setIcon(new ImageIcon(buttonIcon));
                this.setDisabledIcon(new ImageIcon(buttonIcon));
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public PlacementBateaux(final BatailleNavale model, final JPanelCards card) {
        super(new BorderLayout());
        model.addObserver(this);
        this.model = model;
        this.size = model.getHuman().getMapPerso().getSize();

        buttons = new JPanel(new GridLayout(1, 2));


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



    }


    public void constructGrillePlacement(){
        grille = new JPanel(new GridLayout(size, size));

        listButton = new JButtonBateau[size][size];

        // On créer la grille de boutons pour le positionnement des bateaux
        for (int y = 0; y < listButton.length; y++) {
            for (int x = 0; x < listButton[y].length; x++) {
                JButtonBateau btn = new JButtonBateau(model, x, y);

                listButton[y][x] = btn;
                grille.add(btn);
            }
        }
        add(grille, BorderLayout.CENTER);

        ships = new JPanel(new GridLayout(4, 3));


        // Menu des bateaux à droite
        bigShip = new JLabel("BlackPearl");
        bigShip.setHorizontalAlignment(SwingConstants.TRAILING);
        mediumShip = new JLabel("Galion");
        mediumShip.setHorizontalAlignment(SwingConstants.TRAILING);
        mediumShipBis = new JLabel("Galion");
        mediumShipBis.setHorizontalAlignment(SwingConstants.TRAILING);
        smallShip = new JLabel("Boat");
        smallShip.setHorizontalAlignment(SwingConstants.TRAILING);

        BufferedImage buttonIcon = null;
        try {
            buttonIcon = ImageIO.read(new File("./BatailleNavale/img/bigShipH.png"));
            bigH = new JButton(new ImageIcon(buttonIcon));
            buttonIcon = ImageIO.read(new File("./BatailleNavale/img/bigShipV.png"));
            bigV = new JButton(new ImageIcon(buttonIcon));

            buttonIcon = ImageIO.read(new File("./BatailleNavale/img/mediumShipH.png"));
            mediumH = new JButton(new ImageIcon(buttonIcon));
            mediumHBis = new JButton(new ImageIcon(buttonIcon));

            buttonIcon = ImageIO.read(new File("./BatailleNavale/img/mediumShipV.png"));
            mediumV = new JButton(new ImageIcon(buttonIcon));
            mediumVBis = new JButton(new ImageIcon(buttonIcon));

            buttonIcon = ImageIO.read(new File("./BatailleNavale/img/smallShipH.png"));
            smallH = new JButton(new ImageIcon(buttonIcon));
            buttonIcon = ImageIO.read(new File("./BatailleNavale/img/smallShipV.png"));
            smallV = new JButton(new ImageIcon(buttonIcon));

        } catch (IOException e) {
            e.printStackTrace();
        }
        ships.add(bigShip);
        ships.add(bigH);
        ships.add(bigV);
        ships.add(mediumShip);
        ships.add(mediumH);
        ships.add(mediumV);
        ships.add(mediumShipBis);
        ships.add(mediumHBis);
        ships.add(mediumVBis);
        ships.add(smallShip);
        ships.add(smallH);
        ships.add(smallV);
        add(ships, BorderLayout.EAST);
    }
    @Override
    public void update(Observable o, Object arg) {

    }
}
