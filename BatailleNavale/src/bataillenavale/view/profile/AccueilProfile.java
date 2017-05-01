package bataillenavale.view.profile;

import bataillenavale.controler.MenuListener;
import bataillenavale.view.JPanelCards;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class AccueilProfile extends JPanel implements Observer{
    public static final String id = "accueilProfile";

    public AccueilProfile(final JPanelCards card){
        //buttons affiche tout les boutons possibles
        // chargement menuBar pour accueil
        card.chargerMenuProfil();

        JPanel buttons = new JPanel(new GridLayout(2,1));
        JButton creerProfil = new JButton("Créer Profil");
        creerProfil.addActionListener(new MenuListener(card, "newProfile"));
        buttons.add(creerProfil);

        JButton chargerProfil = new JButton("Charger Profil");
        chargerProfil.addActionListener(new MenuListener(card, "loadProfile"));
        buttons.add(chargerProfil);

        buttons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Bienvenue", TitledBorder.LEFT, TitledBorder.TOP, new Font(Font.SERIF, Font.ITALIC, 16), Color.GRAY));

        add(buttons, BorderLayout.CENTER);
    }
    @Override
    public void update(Observable o, Object arg) {

    }
}
