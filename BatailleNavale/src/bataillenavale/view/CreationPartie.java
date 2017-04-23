package bataillenavale.view;

import bataillenavale.controler.MenuListener;
import bataillenavale.model.BatailleNavale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class CreationPartie extends JPanel implements Observer {

    public static final String id = "creation";
    private final JTextField pseudo;
    private final JButton retour;
    private final JButton valider;
    // rajouter epoque et difficulte plus tard
    //private final JComboBox epoque;
    //private final JComboBox difficulte;

    public CreationPartie(final BatailleNavale model, final JPanelCards card){
        super(new BorderLayout());
        model.addObserver(this);
        JPanel saisie = new JPanel(new GridLayout(5,2));

        pseudo = new JTextField("Pseudo");
        //epoque = new JComboBox()
        // ligne 1 du gridlayout
        saisie.add(new JLabel("Pseudo : "));
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
        retour.addActionListener(new MenuListener(model,card,Accueil.id));

        valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                model.getHuman().setPseudo(pseudo.getText());
                card.show(PlacementBateaux.id);
            }
        });

        saisie.add(retour);
        saisie.add(valider);
        add(saisie);

    }
    @Override
    public void update(Observable o, Object arg) {

    }
}
