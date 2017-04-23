package bataillenavale.view;

import bataillenavale.controler.MenuListener;
import bataillenavale.model.BatailleNavale;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class Accueil extends JPanel implements Observer{
    public static final String id = "accueil";

    public Accueil(final BatailleNavale model, final JPanelCards card){
        //buttons affiche tout les boutons possibles
        JPanel buttons = new JPanel(new GridLayout(3,1));
        model.addObserver(this);
        JButton creerPartie = new JButton("Nouvelle Partie");
        creerPartie.addActionListener(new MenuListener(model, card, "creation"));
        buttons.add(creerPartie);

        JButton chargerPartie = new JButton("Charger Partie");
        chargerPartie.addActionListener(new MenuListener(model, card, "accueil"));
        buttons.add(chargerPartie);

        JButton voirScore = new JButton("Voir scores");
        voirScore.addActionListener(new MenuListener(model, card, "accueil"));
        buttons.add(voirScore);

        buttons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Bienvenue", TitledBorder.LEFT, TitledBorder.TOP, new Font(Font.SERIF, Font.ITALIC, 16), Color.GRAY));

        add(buttons, BorderLayout.CENTER);
    }
    @Override
    public void update(Observable o, Object arg) {

    }
}
