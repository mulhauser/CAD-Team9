package bataillenavale.dao;

import bataillenavale.model.Profile;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by mulhauser on 02/05/2017.
 */
public class DAOSauvegardeSerialisation extends DAOSauvegarde {

    public HashMap getProfiles() {
        HashMap<String, Profile> listeProfiles = new HashMap<>();

        File folder = new File("./profils");
        File[] files = folder.listFiles();

        for (int i = 0; i < files.length; i++) {

            if (files[i].isFile() && files[i].getName().endsWith(".save") && !files[i].isHidden()) {
                try {
                    FileInputStream fis = new FileInputStream(files[i]);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    Profile profile = (Profile) ois.readObject();
                    listeProfiles.put(profile.getPseudo(), profile);
                    ois.close();
                    fis.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return listeProfiles;
    }

    public void saveProfile(Profile p) {
        String file = "./profils" + File.separator + p.getPseudo() + ".save";

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean profileExist(String nom) {
        Iterator iterator = this.getProfiles().keySet().iterator();
        while (iterator.hasNext()) {
            if (((Profile) this.getProfiles().get(iterator.next())).getPseudo().equals(nom)) {
                return true;
            }
        }
        return false;
    }
}
