package bataillenavale.view.profile;

import bataillenavale.controler.MenuListener;
import bataillenavale.dao.DAOFactory;
import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Profile;
import bataillenavale.view.JPanelCards;
import bataillenavale.view.partie.AccueilPartie;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by mulhauser on 30/04/2017.
 */
public class ChargeProfile extends JPanel {

    public static final String id = "loadProfile";
    private JList list;
    private JButton valider, retour;
    HashMap<String, Profile> profiles;
    BatailleNavale model;
    JPanelCards card;

    public ChargeProfile(JPanelCards card){
        super(new BorderLayout());
        this.card = card;



        JPanel south = new JPanel(new GridLayout(1,2));
        retour = new JButton("Retour");
        retour.addActionListener(new MenuListener(card, AccueilProfile.id));

        valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!list.isSelectionEmpty()){
                    model = new BatailleNavale();
                    model.setProfile(profiles.get(list.getSelectedValue()));
                    card.getAccueilPartie().setModel(model);
                    card.getLoadPartie().setModel(model);
                    card.getNewPartie().setModel(model);
                    card.chargerMenuPartie();
                    card.show(AccueilPartie.id);
                }else{
                    JOptionPane.showMessageDialog(card.fenetre, "Veuillez selectionner un profil", "Erreur", JOptionPane.ERROR_MESSAGE);
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

        south.add(retour);
        south.add(valider);
        add(south, BorderLayout.SOUTH);
    }

    public void constructListProfil(){
        profiles = DAOFactory.getInstance().getDAOSauvegarde().getProfiles();
        if(profiles.size() > 0) {
            DefaultListModel listModel = new DefaultListModel<String>();
            for (String v : profiles.keySet()) {
                listModel.addElement(v);
            }
            list = new JList(listModel);
            list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            list.setLayoutOrientation(JList.VERTICAL_WRAP);
            list.setVisibleRowCount(-1);
            list.setSelectedIndex(0);
            JScrollPane listScroller = new JScrollPane(list);
            listScroller.setPreferredSize(new Dimension(250, 80));
            list.addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {

                }
            });
            list.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Type", TitledBorder.LEFT, TitledBorder.TOP, new Font(Font.SERIF, Font.ITALIC, 16), Color.GRAY));
            add(list, BorderLayout.CENTER);
        }else{
            JOptionPane.showMessageDialog(card.fenetre, "Aucun Profil", "Erreur", JOptionPane.INFORMATION_MESSAGE);
            card.show(AccueilProfile.id);
        }
    }
}
