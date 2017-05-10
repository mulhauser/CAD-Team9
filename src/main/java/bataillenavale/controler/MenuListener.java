package bataillenavale.controler;

import bataillenavale.view.JPanelCards;
import bataillenavale.view.partie.AccueilPartie;
import bataillenavale.view.partie.ChargePartie;
import bataillenavale.view.partie.CreationPartie;
import bataillenavale.view.profile.AccueilProfile;
import bataillenavale.view.profile.ChargeProfile;
import bataillenavale.view.profile.CreationProfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class MenuListener implements ActionListener{
    private JPanelCards card;
    private String idPanel;

    public MenuListener(JPanelCards card, String id){
        this.card = card;
        this.idPanel = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.show(idPanel);
        switch (idPanel){
            // Si on charge le panel chargeProfile on construit la grille pour la liste des profiles
            case ChargeProfile.id:
                card.getLoadProfil().constructListProfil();
                card.chargerMenuProfil();
                break;
            case AccueilProfile.id:
                card.chargerMenuProfil();
                break;
            case CreationProfile.id:
                card.chargerMenuProfil();
                break;
            case ChargePartie.id:
                card.getLoadPartie().constructListPartie();
                card.chargerMenuPartie();
                break;
            case AccueilPartie.id:
                System.out.println("partie");
                card.chargerMenuPartie();
                break;
            case CreationPartie.id:
                card.chargerMenuPartie();
                break;

        }
    }
}
