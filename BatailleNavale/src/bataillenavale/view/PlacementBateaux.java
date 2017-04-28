package bataillenavale.view;

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Map;
import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipPiece;
import bataillenavale.model.ship.StatePiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 23/04/2017.
 */
public class PlacementBateaux extends JPanel implements Observer {

    //id permet de switcher de panel dans JPanelCards
    public static final String id = "placement";
    private static JPanelMenuDroite menuDroite;
    private static JPanelSouth buttons;
    private static JPanelGrille grille;
    private static Ship currentShip;


    private static BatailleNavale model;

    private int size = 0;

    // TODO: Voir pour utiliser un GridBagLayout partout pour placer comme on veut mais c'est compliqué
    public PlacementBateaux(final BatailleNavale model, final JPanelCards card) {
        super(new BorderLayout());
        model.addObserver(this);
        this.model = model;
        this.size = model.getPartie().getHuman().getMapPerso().getSize();

        this.buttons = new JPanelSouth(card);
        add(buttons, BorderLayout.SOUTH);
    }


    public void constructGrillePlacement() {

        // Construction de la grille des bateaux
        if (grille != null) {
            remove(grille);
        }

        //grille = new JPanelGrille();
        grille = new JPanelGrille(this.model,this.model.getPartie().getHuman().getMapPerso().getSize());

        add(grille, BorderLayout.CENTER);


    }

    public void constructMenuBateaux() {
        // Construction du menu de placement à droite
        if (menuDroite != null) {
            remove(menuDroite);
        }
        menuDroite = new JPanelMenuDroite();

        add(menuDroite, BorderLayout.EAST);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    /**
     * Classe privee contenant la grille de placement des bateaux
     */

    /*
    private class JPanelGrille extends JPanel implements Observer {

        private JLabelBateau[][] listButton;

        public JPanelGrille() {
            super(new GridLayout(size + 1, size + 1));
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
                    JLabelBateau btn = new JLabelBateau(model, x, y);
                    listButton[y][x] = btn;
                    this.add(btn);
                }

            }
        }

        @Override
        public void update(Observable o, Object arg) {
            Map map = model.getPartie().getHuman().getMapPerso();
            ShipPiece[][] tabMap = map.getMapDispositionBateaux();
            for (int x = 0; x < tabMap.length; x++) {
                for (int y = 0; y < tabMap[x].length; y++) {
                    if(tabMap[y][x] != null) {
                        if (tabMap[y][x].getState() == StatePiece.MISS) {
                            listButton[y][x].setBackground(Color.ORANGE);
                        }
                        if (tabMap[y][x].getState() == StatePiece.HIT) {
                            listButton[y][x].setBackground(Color.RED);
                        }
                    }

                }
            }
        }
    }
    */



    /**
     * Classe privee qui permet de créer le panel de validation et de retour à l'accueil en bas de la fenetre
     */
    private class JPanelSouth extends JPanel {

        public JPanelSouth(JPanelCards card) {
            super(new GridLayout(1, 2));

            // Menu des boutons en bas
            JButton backToCreer = new JButton("retour");
            backToCreer.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    //state = NOTHING_SELECTED;
                    card.show(CreationPartie.id);
                }
            });
            this.add(backToCreer);

            JButton valider = new JButton("valider");

            //valider.setEnabled(false);

            valider.setEnabled(true);
            valider.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    card.getViewMain().constructGrilleHumain();
                    // On affiche le panel de placement
                    card.show(ViewMain.id);
                }
            });
            this.add(valider);
        }
    }

    /**
     * Classe privee pour construire le menu de placement des bateaux
     */
    private class JPanelMenuDroite extends JPanel {

        JPanelBateaux bateaux;
        JPanelCoordonnees coordonnees;
        JPanelValidation validation;

        public JPanelMenuDroite() {
            super(new GridBagLayout());
            this.setPreferredSize(new Dimension(200, 500));
            this.bateaux = new JPanelBateaux();
            this.coordonnees = new JPanelCoordonnees();
            this.validation = new JPanelValidation();
            GridBagConstraints c = new GridBagConstraints();
            c.gridy = 0;
            this.add(new JLabel("Placez vos bateaux "), c);
            c.gridy = 1;
            this.add(this.bateaux, c);
            c.gridy = 2;
            this.add(this.coordonnees, c);
            c.gridy = 3;
            this.add(this.validation, c);
        }

        public JPanelCoordonnees getCoordonnees() {
            return this.coordonnees;
        }

        public JPanelValidation getValidation() {
            return this.validation;
        }

        public JPanelBateaux getBateaux() {
            return this.bateaux;
        }
    }

    /**
     * Classe privee pour créer le panel de la liste des bateaux à placer
     */
    private class JPanelBateaux extends JPanel {

        public JPanelBateaux() {
            super(new GridLayout(5, 1));

            this.setPreferredSize(new Dimension(200, 400));

            ArrayList<Ship> shipList = model.getPartie().getHuman().getFlotte().getShipList();
            for (Ship s : shipList) {
                this.add(new JPanelBateau(s, this));
            }

        }
    }

    /**
     * Classe privee qui permet de construire pour chaque bateau, le label et ses deux boutons associés pour son placement
     */
    private class JPanelBateau extends JPanel {

        Ship ship;
        JLabel nom;
        JButton horizontalButton;
        JButton verticalButton;
        JPanelBateaux parent;

        public JPanelBateau(Ship s, JPanelBateaux ships) {
            super(new GridLayout(1, 3));
            this.ship = s;
            this.parent = ships;
            // Creation du label du bateau associé
            this.nom = new JLabel(s.getNom());
            this.nom.setHorizontalAlignment(SwingConstants.TRAILING);
            this.add(nom);


            BufferedImage imgH = s.getImage();
            BufferedImage imgV = new BufferedImage(imgH.getHeight(), imgH.getWidth(), imgH.getType());
            this.horizontalButton = new JButton(new ImageIcon(imgH));
            this.horizontalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s.setOrientation(Ship.Orientation.HORIZONTAL);
                    currentShip = s;

                    // On active les boutons des coordonness et les boutons annuler/valider
                    for (Component c : menuDroite.getCoordonnees().getComponents()) {
                        c.setEnabled(true);
                    }
                    for (Component c : menuDroite.getValidation().getComponents()) {
                        c.setEnabled(true);
                    }
                }
            });
            this.add(horizontalButton);

            // Rotation de l'image de 90° pour l'affichage vertical
            AffineTransform tx = new AffineTransform();
            tx.setToTranslation((imgV.getWidth() - imgH.getWidth()) / 2, (imgV.getHeight() - imgH.getHeight()) / 2);
            tx.rotate(Math.toRadians(90), imgH.getWidth() / 2, imgH.getHeight() / 2);

            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

            op.filter(imgH, imgV);

            this.verticalButton = new JButton(new ImageIcon(imgV));
            this.verticalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s.setOrientation(Ship.Orientation.VERTICAL);
                    currentShip = s;

                    // On active les boutons des coordonness et les boutons annuler/valider
                    for (Component c : menuDroite.getCoordonnees().getComponents()) {
                        c.setEnabled(true);
                    }
                    for (Component c : menuDroite.getValidation().getComponents()) {
                        c.setEnabled(true);
                    }
                }
            });
            this.add(verticalButton);
        }
    }

    /**
     * Classe privee pour la selection des coordonnées
     */
    private class JPanelCoordonnees extends JPanel {

        private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        private JComboBox positionX;
        private String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private JComboBox positionY;

        public JPanelCoordonnees() {
            super(new GridLayout(1, 2));
            this.positionX = new JComboBox(alphabet);
            this.positionX.setSelectedIndex(0);
            this.positionX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentShip.getCoordinate().setX(positionX.getSelectedIndex());
                }
            });
            this.positionX.setEnabled(false);
            this.add(this.positionX);

            this.positionY = new JComboBox(numbers);
            this.positionY.setSelectedIndex(0);
            this.positionY.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentShip.getCoordinate().setY(positionY.getSelectedIndex());
                }
            });
            this.positionY.setEnabled(false);
            this.add(this.positionY);
        }

        public JComboBox getPositionX() {
            return this.positionX;
        }

        public JComboBox getPositionY() {
            return this.positionY;
        }
    }

    /**
     * Classe privee pour la validation du placement ou l'annulation
     */
    private class JPanelValidation extends JPanel {

        private JButton annulerPlacement;
        private JButton validerPlacement;

        public JPanelValidation() {
            super(new GridLayout(1, 2));
            this.annulerPlacement = new JButton("Annuler");
            this.validerPlacement = new JButton("Valider");
            this.annulerPlacement.setEnabled(false);
            this.validerPlacement.setEnabled(false);

            this.annulerPlacement.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            this.validerPlacement.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // On sera notifier dans les update si le placement peut se faire, voir dans BatailleNavale
                    // la methode ajouterShip(Ship s) notifie les vues
                    model.ajouterShip(currentShip);
                }
            });
            this.add(this.annulerPlacement);
            this.add(this.validerPlacement);
        }
    }
}
