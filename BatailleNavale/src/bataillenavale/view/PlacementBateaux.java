package bataillenavale.view;

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.ship.Ship;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
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

    private JButton annulerPlacement = new JButton("Annuler");
    private JButton validerPlacement = new JButton("Valider Placement");

    private int size;
    private JLabelBateau[][] listButton;
    private BatailleNavale model;

    private int bateauxPlaces = 0;


    //temporaire pour stocker le nouveau bateau
    private String newBoat = "";
    private String newX = "";
    private String newY = "";
    //le but est qu'il devienne par exemple "A0 - A3"

    private String[] alphabet = {"","A", "B","C","D","E","F","G","H","I","J"};
    private JComboBox positionX = new JComboBox(alphabet);
    private String[] numbers = {"","0", "1","2","3","4","5","6","7","8","9"};
    private JComboBox positionY = new JComboBox(numbers);

    private boolean boolX = false;
    private boolean boolY = false;

    private class JLabelBateau extends JLabel implements Observer {

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
            this.setBackground(Color.BLUE);
            this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
           /* try {
                BufferedImage buttonIcon = ImageIO.read(new File("./BatailleNavale/img/ocean.png"));
                this.setIcon(new ImageIcon(buttonIcon));
                this.setDisabledIcon(new ImageIcon(buttonIcon));
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
            /*this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });*/


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
        this.size = model.getPartie().getHuman().getMapPerso().getSize();

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


        validerPlacement.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // on dit au bot de placer ses bateaux
                //((Bot)model.getJ2()).placerBateaux(bateauxChoisis);

                //wizard.getJpanelJouer().initialize();
                //wizard.show(JPanelJouer.id);
                /*System.out.println(model.getPartie().getHuman().getPseudo());
                if(bateauxPlaces<4){
                    JOptionPane.showMessageDialog(null, "Veuillez placer l'ensemble de la flotte.", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Flotte prête", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
                */
                if(boolX==true && boolY==true){
                    newBoat=newX+newY;
                    //il faut ajouter la direction et la taille maintenant
                    updateMap(newX,newY);
                    JOptionPane.showMessageDialog(null, "Bateau Placé en "+newBoat, "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Error", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons.add(valider);
        add(buttons, BorderLayout.SOUTH);



    }


    public void constructGrillePlacement() {

        // Construction de la grille des bateaux
        if (grille != null) {
            remove(grille);
        }
        grille = new JPanel(new GridLayout(size+1, size+1));

        listButton = new JLabelBateau[size][size];

        // On créer la grille de boutons pour le positionnement des bateaux
        grille.add(new JLabel("", SwingConstants.CENTER));
        grille.add(new JLabel("A", SwingConstants.CENTER));
        grille.add(new JLabel("B", SwingConstants.CENTER));
        grille.add(new JLabel("C", SwingConstants.CENTER));
        grille.add(new JLabel("D", SwingConstants.CENTER));
        grille.add(new JLabel("E", SwingConstants.CENTER));
        grille.add(new JLabel("F", SwingConstants.CENTER));
        grille.add(new JLabel("G", SwingConstants.CENTER));
        grille.add(new JLabel("H", SwingConstants.CENTER));
        grille.add(new JLabel("I", SwingConstants.CENTER));
        grille.add(new JLabel("J", SwingConstants.CENTER));
        for (int y = 0; y < listButton.length; y++) {
            grille.add(new JLabel(Integer.toString(y), SwingConstants.CENTER));
            for (int x = 0; x < listButton[y].length; x++) {
                JLabelBateau btn = new JLabelBateau(model, x, y);
                listButton[y][x] = btn;
                grille.add(btn);
            }

        }
        add(grille, BorderLayout.CENTER);

    }

    public void constructMenuBateaux(){
        // Construction du menu de placement à droite
        if(ships != null){
            remove(ships);
        }
        ships = new JPanel(new GridLayout(7, 3));

        JLabel pseudo = new JLabel("Placez vos bateaux ");

        annulerPlacement.setVisible(false);
        validerPlacement.setVisible(false);
        positionX.setVisible(false);
        positionY.setVisible(false);

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

        bigH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                permission(0, 3);
            }
        });

        bigV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                permission(3, 0);
            }
        });

        mediumH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                permission(0, 2);
            }
        });

        mediumHBis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                permission(0, 2);
            }
        });

        mediumV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                permission(2, 0);
            }
        });

        mediumVBis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                permission(2, 0);
            }
        });

        smallV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                permission(1, 0);
            }
        });
        smallH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                permission(0, 1);
            }
        });

        annulerPlacement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //il faut ici pouvoir placer un bateau
                for(int y = 0; y < listButton.length; y ++){
                    for(int x = 0; x < listButton[y].length; x++){
                        listButton[y][x].setEnabled(false);
                    }
                }

                bigH.setEnabled(true);
                bigV.setEnabled(true);
                mediumH.setEnabled(true);
                mediumHBis.setEnabled(true);
                mediumV.setEnabled(true);
                mediumVBis.setEnabled(true);
                smallV.setEnabled(true);
                smallH.setEnabled(true);
                annulerPlacement.setVisible(false);
                validerPlacement.setVisible(false);
                positionX.setVisible(false);
                positionY.setVisible(false);

                bateauxPlaces--;
            }
        });

        positionX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(positionX.getSelectedItem()!=""){
                    boolX = true;
                    newX = (String) positionX.getSelectedItem();
                }else{
                    boolX = false;
                }
            }
        });

        positionY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(positionY.getSelectedItem()!=""){
                    boolY = true;
                    newY = (String) positionY.getSelectedItem();
                }else{
                    boolY = false;
                }
            }
        });

        ships.add(new JLabel());
        ships.add(pseudo);
        ships.add(new JLabel());
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
        ships.add(new JLabel());
        ships.add(positionX);
        ships.add(positionY);
        ships.add(new JLabel());
        ships.add(validerPlacement);
        ships.add(annulerPlacement);
        add(ships, BorderLayout.EAST);
    }
    @Override
    public void update(Observable o, Object arg) {

    }

    //permet de gérer la permission des cases de la map disponibles pour placer le début du bateaut en fonction de
    //sa taille et sa direction.
    //a représente le nombre de cases que l'on ne permet pas d'alouer en vertical et b en horizontal
    public void permission(int a, int b){
        for(int y = 0; y < listButton.length-a; y ++){
            for(int x = 0; x < listButton[y].length-b; x++){
                listButton[y][x].setEnabled(true);
            }
        }
        bigH.setEnabled(false);
        bigV.setEnabled(false);
        mediumH.setEnabled(false);
        mediumHBis.setEnabled(false);
        mediumV.setEnabled(false);
        mediumVBis.setEnabled(false);
        smallV.setEnabled(false);
        smallH.setEnabled(false);
        annulerPlacement.setVisible(true);
        validerPlacement.setVisible(true);
        positionX.setVisible(true);
        positionY.setVisible(true);

        bateauxPlaces++;
    }

    public void updateMap(String newX,String newY){
        int x = 0;
        int y = 0;

        switch (newX){
            case "A":
                x = 0;
                break;
            case "B":
                x = 1;
                break;
            case "C":
                x = 2;
                break;
            case "D":
                x = 3;
                break;
            case "E":
                x = 4;
                break;
            case "F":
                x = 5;
                break;
            case "G":
                x = 6;
                break;
            case "H":
                x = 7;
                break;
            case "I":
                x = 8;
                break;
            case "J":
                x = 9;
                break;
        }

        switch (newY){
            case "0":
                y = 0;
                break;
            case "1":
                y = 1;
                break;
            case "2":
                y = 2;
                break;
            case "3":
                y = 3;
                break;
            case "4":
                y = 4;
                break;
            case "5":
                y = 5;
                break;
            case "6":
                y = 6;
                break;
            case "7":
                y = 7;
                break;
            case "8":
                y = 8;
                break;
            case "9":
                y = 9;
                break;
        }

        listButton[y][x].setVisible(false);
        System.out.print(x+"-"+y);

    };

}
