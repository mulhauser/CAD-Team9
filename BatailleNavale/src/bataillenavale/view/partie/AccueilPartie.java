package bataillenavale.view.partie;

import bataillenavale.controler.MenuListener;
import bataillenavale.model.BatailleNavale;
import bataillenavale.view.JPanelCards;
import bataillenavale.view.profile.CreationProfile;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by mulhauser on 01/05/2017.
 */
public class AccueilPartie extends JPanel {
    public static final String id = "accueilPartie";

    protected BatailleNavale model;

    public AccueilPartie(final JPanelCards card) {
        //buttons affiche tout les boutons possibles
        // chargement menuBar pour accueil
        card.chargerMenuPartie();

        JPanel buttons = new JPanel(new GridLayout(3, 1));
        JButton creerPartie = new JButton("Créer Partie");
        creerPartie.addActionListener(new MenuListener(card, "newPartie"));
        buttons.add(creerPartie);


        JButton chargerPartie = new JButton("Charger Partie");
        chargerPartie.addActionListener(new MenuListener(card, "loadPartie"));
        buttons.add(chargerPartie);

        JButton retour = new JButton("Retour");
        retour.addActionListener(new MenuListener(card, CreationProfile.id));
        buttons.add(retour);

        buttons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Bienvenue", TitledBorder.LEFT, TitledBorder.TOP, new Font(Font.SERIF, Font.ITALIC, 16), Color.GRAY));

        add(buttons, BorderLayout.CENTER);
    }

    public void setModel(BatailleNavale m){
        this.model = m;
    }

}
