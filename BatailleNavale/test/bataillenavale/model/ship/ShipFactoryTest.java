package bataillenavale.model.ship;

import bataillenavale.model.ship.xx.Croiseur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static bataillenavale.model.Epoque.XVI;
import static bataillenavale.model.Epoque.XX;
import static org.junit.Assert.*;

/**
 * Created by wolkowicz on 30/04/2017.
 */
public class ShipFactoryTest {




    List<Ship> listXX, listXVI;
    @Before
    public void setUp() throws Exception {
        listXX = ShipFactory.getInstance().getShipsByEpoque(XX);
        listXVI = ShipFactory.getInstance().getShipsByEpoque(XVI);
    }

    @After
    public void tearDown() throws Exception {
        listXX = null;
        listXVI = null;
        assertNull(listXX);
        assertNull(XVI);
    }

    /** bonne facon de le faire ?
     *
     * @throws Exception
     */
    @Test
    public void getShipsByEpoqueXX() throws Exception {
        String[] tab = {"PorteAvion", "Croiseur", "ContreTorpilleur", "SousMarin", "Torpilleur"};
        for(int i = 0; i < listXX.size(); i++){
            assertEquals(tab[i], listXX.get(i).getNom());
        }
    }

    @Test
    public void getShipsByEpoqueXVI() throws Exception {
        String[] tab = {"Fregate", "Corsaire", "Galion", "Caravelle", "Galere"};
        for(int i = 0; i < listXVI.size(); i++){
            assertEquals(tab[i], listXVI.get(i).getNom());
        }
    }

}