package bataillenavale.view;

import bataillenavale.controler.MenuListener;
import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Coordinate;
import bataillenavale.model.Map;
import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.xx.ContreTorpilleur;
import bataillenavale.model.ship.xx.Croiseur;
import bataillenavale.model.ship.xx.Torpilleur;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 12/04/2017.
 */

public class ViewMain extends JPanel implements Observer{
    public static final String id = "main";
    private Map mapPlayer;
    private Map mapAdver;
    private JPanel grilleHuman;
    private JPanel grilleEnnemy;
    private BatailleNavale model;
    private int size;

    //un bateau :
    //avec parametre 1 = position x
    //parametre 2 = position y
    //parametre 3 = V ou H (V = 1, H = 0)
    //parametre 4 = taille
    private int[] shipHuman = {1,1,1,3};

    //un bateau :
    //avec parametre 1 = position x
    //parametre 2 = position y
    //parametre 3 = V ou H (V = 1, H = 0)
    //parametre 4 = taille
    private int[] shipEnnemy = {3,3,0,4};

    //creation d'un bateau qui servira 10 fois
    private Ship croiseur = new Croiseur();
    private Ship caravelle1 = new ContreTorpilleur();
    private Ship caravelle2 = new ContreTorpilleur();
    private Ship caravelle3 = new ContreTorpilleur();
    private Ship torpilleur = new Torpilleur();

    //sert pour le tire
    private int fireX;
    private int fireY;

    public ViewMain(final BatailleNavale model, final JPanelCards card){
        //ici le super pour le Fichier (accueil,quitter)
        super(new BorderLayout());
        model.addObserver(this);
        //this.model = model;
        //pour l'instant on ne reprend pas le model on en crée un nouveau :
        this.model = new BatailleNavale();
        //maintenant on doit creer les persos ainsi :
        //il faut creer 2 joueurs avec bateaux placés au meme endroit :
        //1 de 4 cases en : [D0]-[GØ] --> le croiseur
        //1 de 3 cases en : [B2]-[B4]
        //1 de 3 cases en : [G3]-[I3]
        //1 de 3 cases en : [B8]-[D8]
        //1 de 2 cases en : [H8]-[I8]
        this.croiseur.setCoordinate(new Coordinate(3,0));
        this.croiseur.setOrientation(Ship.Orientation.HORIZONTAL);

        this.caravelle1.setCoordinate(new Coordinate(1,2));
        this.caravelle1.setOrientation(Ship.Orientation.VERTICAL);

        this.caravelle2.setCoordinate(new Coordinate(6,3));
        this.caravelle2.setOrientation(Ship.Orientation.HORIZONTAL);

        this.caravelle3.setCoordinate(new Coordinate(1,8));
        this.caravelle3.setOrientation(Ship.Orientation.HORIZONTAL);

        this.torpilleur.setCoordinate(new Coordinate(7,8));
        this.torpilleur.setOrientation(Ship.Orientation.HORIZONTAL);

        this.mapPlayer = new Map();
        this.mapPlayer.ajouterBateau(this.croiseur);
        this.mapPlayer.ajouterBateau(this.caravelle1);
        this.mapPlayer.ajouterBateau(this.caravelle2);
        this.mapPlayer.ajouterBateau(this.caravelle3);
        this.mapPlayer.ajouterBateau(this.torpilleur);

        this.mapAdver = new Map();
        this.mapAdver.ajouterBateau(this.croiseur);
        this.mapAdver.ajouterBateau(this.caravelle1);
        this.mapAdver.ajouterBateau(this.caravelle2);
        this.mapAdver.ajouterBateau(this.caravelle3);
        this.mapAdver.ajouterBateau(this.torpilleur);

        //puis utiliser mapDispositionBateaux pour savoir si un bateau est présent ou non.

        //pour le test
        System.out.println(this.mapPlayer.toString());

        this.size = model.getPartie().getHuman().getMapPerso().getSize();
        this.grilleHuman = newGrille(400,this.mapPlayer);
        this.grilleEnnemy = newGrille(400,this.mapAdver);


        //après affichage des 2 maps, place au tir

        JPanel panelFire = new JPanel(new GridLayout(1,3));
        String[] alphabet = {"A", "B","C","D","E","F","G","H","I","J"};
        JComboBox chooseX = new JComboBox(alphabet);
        String[] numbers = {"0", "1","2","3","4","5","6","7","8","9"};
        JComboBox chooseY = new JComboBox(numbers);
        JButton fire = new JButton("FIRE");

        chooseX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireX = chooseX.getSelectedIndex();
            }
        });
        chooseY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireY = chooseY.getSelectedIndex();
            }
        });

        fire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //test
                System.out.println("X: "+fireX+". Y: "+fireY);
                //retourne un booléan : true si touché, false sinon
                if(fire(fireX,fireY)){
                    JOptionPane.showMessageDialog(null, "Touché");
                }else{
                    JOptionPane.showMessageDialog(null, "Plouf");
                }

            }
        });

        panelFire.add(chooseX);
        panelFire.add(chooseY);
        panelFire.add(fire);

        JPanel panelDisplay = new JPanel(new GridLayout(1,2));
        panelDisplay.add(new JLabel("You",SwingConstants.CENTER));
        panelDisplay.add(new JLabel("Ennemy",SwingConstants.CENTER));

        add(panelDisplay,BorderLayout.NORTH);
        add(grilleHuman, BorderLayout.WEST);
        add(grilleEnnemy, BorderLayout.EAST);
        add(panelFire,BorderLayout.SOUTH);
    }

    public JPanel newGrille(int sizeScreen,Map map){

        JPanel grille = new JPanel(new GridLayout(size+1, size+1));

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

        for (int y = 0; y < size; y++) {
            grille.add(new JLabel(Integer.toString(y), SwingConstants.CENTER));
            for (int x = 0; x < size; x++) {
                JLabel btn = new JLabel();
                btn.setEnabled(false);
                btn.setOpaque(true);
                //on vérifie un bateau s'y trouve
                if(map.getMapDispositionBateauxElement(y,x)){
                    btn.setBackground(Color.RED);
                }else{
                    btn.setBackground(Color.BLUE);
                }
                btn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                grille.add(btn);
            }

        }

        //pour la taille de la grille
        grille.setPreferredSize(new Dimension(sizeScreen,sizeScreen));
        return grille;
    }

    public void updateGrille(JPanel currentGrille){

    }

    public boolean fire(int x, int y){
        if(this.mapAdver.getMapDispositionBateauxElement(y,x)){
            return true;
        }else{
            return false;
        }
    }

    /*public boolean fire(int x, int y){

        for(int i=0;i<shipEnnemy[3];i++){
            if(shipEnnemy[2]==0){
                if(shipEnnemy[0]+i==x && shipEnnemy[1]==y) {
                    return true;
                }
            }else{
                if(shipEnnemy[0]==x && shipEnnemy[1]+i==y) {
                    return true;
                }
            }
        }

        return false;
    }
    */

    @Override
    public void update(Observable o, Object arg) {

    }
}
