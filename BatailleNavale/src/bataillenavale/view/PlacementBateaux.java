package bataillenavale.view;

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.ship.Ship;

import javax.swing.*;
import javax.swing.border.BevelBorder;
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

    public static final String id = "placement";
    private JPanel grille;
    private static JPanelMenuDroite menuDroite;
    private static JPanelSouth buttons;
    private static Ship currentShip;





    private JLabelBateau[][] listButton;
    private static BatailleNavale model;

    //private int bateauxPlaces = 0;


    //temporaire pour stocker le nouveau bateau
    private int newX = 0;
    private int newY = 0;
    private int size = 0;
    //0=vertical, 1=horizontal
    private int direction;
    //le but est qu'il devienne par exemple "A0 - A3"

    private boolean boolX = false;
    private boolean boolY = false;

    //chaque 0 représente un bateau
    private int[] shipsAdded = {0,0,0,0};

    // TODO: Voir pour utiliser un GridBagLayout partout pour placer comme on veut mais c'est compliqué
    public PlacementBateaux(final BatailleNavale model, final JPanelCards card) {
        super(new BorderLayout());
        model.addObserver(this);
        this.model = model;
        this.size = model.getPartie().getHuman().getMapPerso().getSize();

        this.buttons = new JPanelSouth(card);
        add(buttons, BorderLayout.SOUTH);
    }



    // TODO: A revoir avec la map du Player
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
        if(menuDroite != null){
            remove(menuDroite);
        }
        menuDroite = new JPanelMenuDroite();

        add(menuDroite, BorderLayout.EAST);
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Coucou du placement");
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

        //annulerPlacement.setVisible(true);
        //validerPlacement.setVisible(true);
        //positionX.setVisible(true);
        //positionY.setVisible(true);

        //bateauxPlaces++;
    }

    public void permissionFin() {
        for (int y = 0; y < listButton.length; y++) {
            for (int x = 0; x < listButton[y].length; x++) {
                listButton[y][x].setEnabled(false);
            }
        }



        //annulerPlacement.setVisible(false);
        //validerPlacement.setVisible(false);
        //positionX.setVisible(false);
        //positionY.setVisible(false);

       // bateauxPlaces--;
    }

    public void updateMap(int newX,int newY){
        int x = newX;
        int y = newY;

        listButton[y][x].setVisible(false);
        if(this.direction==0){
            for(int i=0; i<this.size;i++){
                listButton[y+i][x].setVisible(false);
            }
        }else{
            for(int i=0; i<this.size;i++){
                listButton[y][x+i].setVisible(false);
            }
        }
        System.out.print(x+"-"+y);

    };

    public void deleteCase(){
        switch(size){
            case 2 :
                shipsAdded[0]=1;
                break;
            case 3:
                if(shipsAdded[1]==0){
                    shipsAdded[1]=1;
                }else{
                    shipsAdded[2]=1;
                }
                break;
            case 4:
                shipsAdded[3] = 1;
                break;
        }
    }

    /**
     * Classe privee qui pour chaque case de la grille de placement
     */
    private class JLabelBateau extends JLabel implements Observer {

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
            this.setBackground(Color.BLUE);
            this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));


        }

        @Override
        public void update(Observable o, Object arg) {
            // modifier couleur bouton quand bateau placé
            System.out.println("coucou des jlabel");
        }
    }


    /**
     * Classe privee qui permet de créer le panel de validation et de retour à l'accueil en bas de la fenetre
     */
    private class JPanelSouth extends JPanel{

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
            valider.setEnabled(false);

            this.add(valider);
        }
    }

    /**
     * Classe privee pour construire le menu de placement des bateaux
     */
    private class JPanelMenuDroite extends JPanel{

        JPanelBateaux bateaux;
        JPanelCoordonnees coordonnees;
        JPanelValidation validation;
        public JPanelMenuDroite(){
            super(new GridBagLayout());
            this.setPreferredSize(new Dimension(200,500));
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

        public JPanelCoordonnees getCoordonnees(){
            return this.coordonnees;
        }

        public JPanelValidation getValidation(){
            return this.validation;
        }

        public JPanelBateaux getBateaux(){
            return this.bateaux;
        }
    }

    /**
     * Classe privee pour créer le panel de la liste des bateaux à placer
     */
    private class JPanelBateaux extends JPanel{

        public JPanelBateaux(){
            super(new GridLayout(5,1));

            this.setPreferredSize(new Dimension(200,400));

            ArrayList<Ship> shipList = model.getPartie().getHuman().getFlotte().getShipList();
            for(Ship s : shipList){
                this.add(new JPanelBateau(s, this));
            }

        }
    }

    /**
     * Classe privee qui permet de construire pour chaque bateau, le label et ses deux boutons associés pour son placement
     */
    private class JPanelBateau extends JPanel{

        Ship ship;
        JLabel nom;
        JButton horizontalButton;
        JButton verticalButton;
        JPanelBateaux parent;
        public JPanelBateau(Ship s, JPanelBateaux ships){
            super(new GridLayout(1,3));
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
                    for(Component c : menuDroite.getCoordonnees().getComponents()){
                        c.setEnabled(true);
                    }
                    for(Component c : menuDroite.getValidation().getComponents()){
                        c.setEnabled(true);
                    }
                }
            });
            this.add(horizontalButton);

            // Rotation de l'image de 90° pour l'affichage vertical
            AffineTransform tx = new AffineTransform();
            tx.setToTranslation((imgV.getWidth() - imgH.getWidth())/2, (imgV.getHeight() - imgH.getHeight())/2);
            tx.rotate(Math.toRadians(90), imgH.getWidth()/2, imgH.getHeight()/2);

            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

            op.filter(imgH, imgV);

            this.verticalButton = new JButton(new ImageIcon(imgV));
            this.verticalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s.setOrientation(Ship.Orientation.VERTICAL);
                    currentShip = s;

                    // On active les boutons des coordonness et les boutons annuler/valider
                    for(Component c : menuDroite.getCoordonnees().getComponents()){
                        c.setEnabled(true);
                    }
                    for(Component c : menuDroite.getValidation().getComponents()){
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
    private class JPanelCoordonnees extends JPanel{

        private String[] alphabet = {"A", "B","C","D","E","F","G","H","I","J"};
        private JComboBox positionX;
        private String[] numbers = {"0", "1","2","3","4","5","6","7","8","9"};
        private JComboBox positionY;

        public JPanelCoordonnees(){
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

        public JComboBox getPositionX(){
            return this.positionX;
        }

        public JComboBox getPositionY(){
            return this.positionY;
        }
    }

    /**
     * Classe privee pour la validation du placement ou l'annulation
     */
    private class JPanelValidation extends JPanel{

        private JButton annulerPlacement;
        private JButton validerPlacement;
        public JPanelValidation(){
            super(new GridLayout(1,2));
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
