package bataillenavale.view.partie;

import bataillenavale.controler.MenuListener;
import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Epoque;
import bataillenavale.view.JPanelCards;
import bataillenavale.view.PlacementBateaux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class CreationPartie extends JPanel {

    public static final String id = "newPartie";
    private final JComboBox epoque, strat;
    private final JButton retour;
    private final JButton valider;
    protected BatailleNavale model;
    // rajouter epoque et difficulte plus tard
    //private final JComboBox epoque;
    //private final JComboBox difficulte;

    public CreationPartie(final JPanelCards card) {
        super(new BorderLayout());
        JPanel saisie = new JPanel(new GridLayout(4, 2));

        // ligne 2 gridlayout
        saisie.add(new JLabel("Epoque : "));
        epoque = new JComboBox(Epoque.values());
        epoque.setSelectedIndex(0);
        saisie.add(epoque);
        // ligne 3 du GL
        saisie.add(new JLabel("Difficulté : "));
        String[] strats = {"random", "cross"};
        strat = new JComboBox(strats);
        strat.setSelectedIndex(0);
        saisie.add(strat);
        // ligne 4 du GL
        saisie.add(new JLabel(""));
        saisie.add(new JLabel(""));

        retour = new JButton("Retour");
        retour.addActionListener(new MenuListener(card, AccueilPartie.id));

        valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                //model.newProfile(pseudo.getText());
                switch (epoque.getSelectedItem().toString()){
                    case "XX":
                        model.newPartie(Epoque.XX, strat.getSelectedItem().toString());
                        break;
                    case "XVI":
                        model.newPartie(Epoque.XVI, strat.getSelectedItem().toString());
                        break;
                }
                model.getProfile().ajouterPartie(model.getPartie());
                //model.getProfile().ajouterPartie(model.getPartie());
                // On construit la grille et la liste des bateaux a placer
                card.getPlacementPanel().setModel(model);
                card.getPlacementPanel().constructGrillePlacement();
                card.getPlacementPanel().constructMenuBateaux();
                card.chargerMenuJouer(model);
                // On affiche le panel de placement
                card.show(PlacementBateaux.id);

            }
        });

        saisie.add(retour);
        saisie.add(valider);
        add(saisie);

    }

    public void setModel(BatailleNavale m){
        this.model = m;
    }
}
