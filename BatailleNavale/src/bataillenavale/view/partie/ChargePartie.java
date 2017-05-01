package bataillenavale.view.partie;

import bataillenavale.controler.MenuListener;
import bataillenavale.model.BatailleNavale;
import bataillenavale.model.Partie;
import bataillenavale.view.JPanelCards;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by mulhauser on 01/05/2017.
 */
public class ChargePartie extends JPanel {
    public static final String id = "loadPartie";

    protected BatailleNavale model;
    protected JPanelCards card;
    protected JButton retour, valider;
    protected JList list;
    protected HashMap<Integer, Partie> parties;

    public ChargePartie(final JPanelCards card){
        super(new BorderLayout());

        this.card = card;
        this.card.chargerMenuProfil();



        JPanel south = new JPanel(new GridLayout(1,2));
        retour = new JButton("Retour");
        retour.addActionListener(new MenuListener(card, AccueilPartie.id));

        valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!list.isSelectionEmpty()){
                    model.setPartie(parties.get(list.getSelectedValue()));
                    card.getAccueilPartie().setModel(model);
                    card.getLoadPartie().setModel(model);
                    card.getNewPartie().setModel(model);
                    card.show(AccueilPartie.id);
                }else{
                    JOptionPane.showMessageDialog(card.fenetre, "Veuillez selectionner une partie", "Information", JOptionPane.INFORMATION_MESSAGE);
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

    public void setModel(BatailleNavale m){
        this.model = m;
    }

    public void constructListPartie(){
        parties = model.getProfile().getParties();
        if(parties.size() > 0) {
            DefaultListModel listModel = new DefaultListModel<String>();
            for (Integer v : parties.keySet()) {
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
            JOptionPane.showMessageDialog(card.fenetre, "Aucune Partie", "Information", JOptionPane.INFORMATION_MESSAGE);
            card.show(AccueilPartie.id);
        }
    }
}
