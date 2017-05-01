package bataillenavale.controler;

import bataillenavale.view.JPanelCards;
import bataillenavale.view.partie.ChargePartie;
import bataillenavale.view.profile.ChargeProfile;

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
        // SI ON CHARGE UN PROFIL IL FAUT FAIRE UNE LECTURE ETC
        card.show(idPanel);
        switch (idPanel){
            // Si on charge le panel chargeProfile on construit la grille pour la liste des profiles
            case ChargeProfile.id:
                card.getLoadProfil().constructListProfil();
                break;
            case ChargePartie.id:
                card.getLoadPartie().constructListPartie();
                break;
        }
    }
}
