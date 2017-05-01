package bataillenavale.view.profile;

import bataillenavale.controler.MenuListener;
import bataillenavale.dao.DAOFactory;
import bataillenavale.model.BatailleNavale;
import bataillenavale.view.JPanelCards;
import bataillenavale.view.partie.AccueilPartie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 30/04/2017.
 */
public class CreationProfile extends JPanel {

    public static final String id = "newProfile";
    private JLabel pseudoLabel;
    private JTextField pseudo;
    private JButton retour;
    private JButton valider;
    private BatailleNavale model;

    public CreationProfile(JPanelCards card) {
        super(new BorderLayout());
        JPanel saisie = new JPanel(new GridLayout(5, 2));

        card.chargerMenuProfil();
        pseudoLabel = new JLabel("Pseudo");
        pseudo = new JTextField();
        pseudo.setToolTipText("Pseudo");

        //epoque = new JComboBox()
        // ligne 1 du gridlayout
        saisie.add(pseudoLabel);
        saisie.add(pseudo);
        // ligne 2 gridlayout
        saisie.add(new JLabel(""));
        saisie.add(new JLabel(""));
        // ligne 3 du GL
        saisie.add(new JLabel(""));
        saisie.add(new JLabel(""));
        // ligne 4 du GL
        saisie.add(new JLabel(""));
        saisie.add(new JLabel(""));

        retour = new JButton("Retour");
        retour.addActionListener(new MenuListener(card, AccueilProfile.id));

        valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!DAOFactory.getInstance().getDAOSauvegarde().profileExist(pseudo.getText())) {
                    model = new BatailleNavale();
                    model.newProfile(pseudo.getText());
                    card.chargerMenuPartie(model);
                    card.getAccueilPartie().setModel(model);
                    card.getLoadPartie().setModel(model);
                    card.getNewPartie().setModel(model);
                    card.show(AccueilPartie.id);
                } else {
                    JOptionPane.showMessageDialog(card.fenetre, "Le profil avec le nom : " + pseudo.getText() + " existe déjà !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                //model.newPartie();
                //model.getProfile().ajouterPartie(model.getPartie());
                // On construit la grille et la liste des bateaux a placer
                //card.getPlacementPanel().constructGrillePlacement();
                //card.getPlacementPanel().constructMenuBateaux();
                // On affiche le panel de placement
                //card.show(PlacementBateaux.id);
            }
        });

        saisie.add(retour);
        saisie.add(valider);
        add(saisie);
    }
}
