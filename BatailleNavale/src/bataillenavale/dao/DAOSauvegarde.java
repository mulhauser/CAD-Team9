package bataillenavale.dao;

import bataillenavale.model.Profile;

import java.io.File;
import java.util.HashMap;

/**
 * Created by mulhauser on 25/04/2017.
 */
public abstract class DAOSauvegarde {

    public DAOSauvegarde() {
        // On créer un dossier de profils
        File f = new File("./profils");
        if (!f.exists()) {
            f.mkdir();
        }
    }


    public abstract HashMap getProfiles();

    public abstract void saveProfile(Profile p);

    public abstract boolean profileExist(String nom);
}
