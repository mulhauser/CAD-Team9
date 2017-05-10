package bataillenavale.view;

import bataillenavale.model.BatailleNavale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 12/04/2017.
 */

public class PlateauJeu extends JPanel {
    public static final String id = "main";
    private JPanel grilleHuman;
    private JPanel grilleBot;
    private BatailleNavale model;
    protected JPanelCards card;
    private JPanel panelFire;
    private JPanel panelDisplay;
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
        removeAll();
        card.chargerMenuJouer(model);


        this.size = this.model.getPartie().getHuman().getMapPerso().getSize();


        panelFire = new JPanel(new GridLayout(1,3));
        String[] alphabet = {"A", "B","C","D","E","F","G","H","I","J"};
        final JComboBox chooseX = new JComboBox(alphabet);
        String[] numbers = {"0", "1","2","3","4","5","6","7","8","9"};
        final JComboBox chooseY = new JComboBox(numbers);
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
                model.tirHumain(fireX,fireY);
                if(model.getPartie().getHuman().checkVictory(model.getPartie().getHuman().getMapAdver())){
                    //si humain gagne
                    JOptionPane.showMessageDialog (null, "Congratulations, you win", "Victory", JOptionPane.INFORMATION_MESSAGE);
                    chooseX.setEnabled(false);
                    chooseY.setEnabled(false);
                }else{
                    //sinon le bot joue
                    model.tirBot();
                    if(model.getPartie().getBot().checkVictory(model.getPartie().getBot().getMapAdver())){
                        //puis si le bot gagne
                        JOptionPane.showMessageDialog (null, "Sorry, you lose...", "IA win", JOptionPane.INFORMATION_MESSAGE);
                        chooseX.setEnabled(false);
                        chooseY.setEnabled(false);
                    }
                }
            }
        });

        panelFire.add(chooseX);
        panelFire.add(chooseY);
        panelFire.add(fire);

        panelDisplay = new JPanel(new GridLayout(1,2));
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

        grilleHuman = new JPanelGrille(this.model,this.model.getPartie().getHuman().getMapPerso().getSize(), model.getPartie().getHuman().getMapPerso());
        this.grilleHuman.setPreferredSize(new Dimension(400,400));

        add(grilleHuman, BorderLayout.WEST);
    }

    public void constructGrilleBot() {

        if (grilleBot!= null) {
            remove(grilleBot);
        }

        //System.out.println(model.getPartie().getBot().getMapPerso());
        grilleBot = new JPanelGrille(this.model,this.model.getPartie().getHuman().getMapPerso().getSize(), model.getPartie().getHuman().getMapAdver());
        this.grilleBot.setPreferredSize(new Dimension(400,400));

        add(grilleBot, BorderLayout.EAST);
    }

    public void setModel(BatailleNavale model) {
        this.model = model;
    }
}
