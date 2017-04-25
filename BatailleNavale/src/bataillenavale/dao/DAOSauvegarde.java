package bataillenavale.dao;

import java.io.File;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class DAOSauvegarde {

    public DAOSauvegarde(){
        // On créer un dossier de profils
        File f = new File("profils");
        if(!f.exists()){
            f.mkdir();
        }
    }

    // A CREER PLUS TARD LA SAUVEGARDE, CHARGEMENT DE PARTIE ET PROFIL
}
