package bataillenavale.dao;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class DAOFactory {

    private static DAOFactory instance = new DAOFactory();

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        if(instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    public DAOSauvegarde getDAOSauvegardeSerialisation(){
        return new DAOSauvegardeSerialisation();
    }
}
