package bataillenavale.view;

import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 12/04/2017.
 */

public class PlateauJeu extends JPanel implements Observer{
    public static final String id = "main";
    private Map mapPlayer;
    private Map mapAdver;
    private JPanel grilleHuman;
    private JPanel grilleBot;
    private BatailleNavale model;
    protected JPanelCards card;
    private int size;



    //sert pour le tire
    private int fireX;
    private int fireY;

    public PlateauJeu(final JPanelCards card){
        //ici le super pour le Fichier (accueil,quitter)
        super(new BorderLayout());
        this.card = card;

    }

    public void constructFenetre(){
        model.addObserver(this);
        this.model = model;

        card.chargerMenuJouer(model);


        this.size = model.getPartie().getHuman().getMapPerso().getSize();


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
                //model.getPartie().getBot().fire(fireX,fireY);
                //puis après le tir peut-importe le résultat de celui-ci il faut mettre à jour la vue
                model.ajouterTirHumain(fireY,fireX);
            }
        });

        panelFire.add(chooseX);
        panelFire.add(chooseY);
        panelFire.add(fire);

        JPanel panelDisplay = new JPanel(new GridLayout(1,2));
        panelDisplay.add(new JLabel("You",SwingConstants.CENTER));
        panelDisplay.add(new JLabel("Ennemy",SwingConstants.CENTER));

        add(panelDisplay,BorderLayout.NORTH);
        add(panelFire,BorderLayout.SOUTH);
    }

    public void constructGrilleHumain() {

        // Construction de la grille des bateaux
        if (grilleHuman != null) {
            remove(grilleHuman);
        }

        grilleHuman = new JPanelGrille(this.model,this.model.getPartie().getHuman().getMapPerso().getSize(), model.getPartie().getHuman());
        this.grilleHuman.setPreferredSize(new Dimension(400,400));

        add(grilleHuman, BorderLayout.WEST);
    }


    @Override
    public void update(Observable o, Object arg) {

    }

    public void constructGrilleBot() {

        if (grilleBot!= null) {
            remove(grilleBot);
        }

        // On construit la map du bot avec une fonctionne qui place aléatoirement ses bateaux

        grilleBot = new JPanelGrille(this.model,this.model.getPartie().getHuman().getMapPerso().getSize(), model.getPartie().getBot());
        this.grilleBot.setPreferredSize(new Dimension(400,400));

        add(grilleBot, BorderLayout.EAST);
    }

    public void setModel(BatailleNavale model) {
        this.model = model;
    }
}
