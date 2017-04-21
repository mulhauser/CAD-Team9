package bataillenavale.controler;

import bataillenavale.model.BatailleNavale;
import bataillenavale.view.JPanelCards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class MenuListener implements ActionListener{
    private JPanelCards card;
    private BatailleNavale model;
    private String idPanel;

    public MenuListener(BatailleNavale m, JPanelCards card, String id){
        this.model = m;
        this.card = card;
        this.idPanel = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.show(idPanel);
        if(e.getActionCommand()=="Créer Partie"){
           System.out.println("Ici on doit créer la map");
        }
        if(e.getActionCommand()=="Charger Partie"){
            System.out.println("Ici on doit proposer les parties sauvegardées");
        }
        if(e.getActionCommand()=="Voir scores"){
            System.out.println("Ici doit afficher les score");
        }
        if(e.getActionCommand()=="accueil"){
            System.out.println("Ici on ne fait rien");
        }
    }
}
