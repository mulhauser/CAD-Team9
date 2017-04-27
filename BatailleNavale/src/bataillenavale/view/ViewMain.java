package bataillenavale.view;

import bataillenavale.controler.MenuListener;
import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Map;

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
    //private Map mapPlayer;
    //private Map mapAdver;
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

    //sert pour le tire
    private int fireX;
    private int fireY;

    public ViewMain(final BatailleNavale model, final JPanelCards card){
        //buttons affiche tout les boutons possibles
        super(new BorderLayout());
        model.addObserver(this);
        //this.model = model;
        //pour l'instant on ne reprend pas le model on en crée un nouveau :
        this.model = new BatailleNavale();
        //ceci sert à définir les bateaux de l'humain

        //ceci sert à définir les bateaux de l'ennemy

        this.size = model.getPartie().getHuman().getMapPerso().getSize();
        //mapPlayer = new Map();
        //mapAdver = new Map();
        this.grilleHuman = newGrilleHuman(400);
        this.grilleEnnemy = newGrilleEnnemy(400);

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
                    //il faut changer la couleur de la case en rouge
                    //il faut ne plus pouvoir jouer fire(fireX,fireY);
                    updateGrille(grilleEnnemy);
                }else{
                    JOptionPane.showMessageDialog(null, "Plouf");
                    //il faut changer la couleur de la case en noir
                    //il faut ne plus pouvoir jouer fire(fireX,fireY);
                    updateGrille(grilleEnnemy);
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

    public JPanel newGrilleHuman(int sizeScreen){

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
                btn.setBackground(Color.BLUE);
                //on vérifie si le bateau humain se trouve ici
                checkColor(btn,x,y,shipHuman);
                btn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                grille.add(btn);
            }

        }

        //pour la taille de la grille
        grille.setPreferredSize(new Dimension(sizeScreen,sizeScreen));
        return grille;
    }

    public JPanel newGrilleEnnemy(int sizeScreen){

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
                btn.setBackground(Color.BLUE);
                //on vérifie si le bateau humain se trouve ici
                checkColor(btn,x,y,shipEnnemy);
                btn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                grille.add(btn);
            }

        }

        //pour la taille de la grille
        grille.setPreferredSize(new Dimension(sizeScreen,sizeScreen));
        return grille;
    }

    public void updateGrille(JPanel currentGrille){
        //réussir à obtenir le label à la position [fireX,fireY]
    }

    public void checkColor(JLabel btn,int x, int y,int[] ship){

        for(int i=0;i<ship[3];i++){
            if(ship[2]==0){
                if(ship[0]+i==x && ship[1]==y) {
                    btn.setBackground(Color.RED);
                }
            }else{
                if(ship[0]==x && ship[1]+i==y) {
                    btn.setBackground(Color.RED);
                }
            }
        }
    }

    public boolean fire(int x, int y){

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

    @Override
    public void update(Observable o, Object arg) {

    }
}
