package bataillenavale.controler;

import bataillenavale.dao.DAOFactory;
import bataillenavale.model.BatailleNavale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 01/05/2017.
 */
public class SaveListener implements ActionListener {

    private BatailleNavale model;

    public SaveListener(BatailleNavale m){
        this.model = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DAOFactory.getInstance().getDAOSauvegardeSerialisation().saveProfile(model.getProfile());
    }
}
