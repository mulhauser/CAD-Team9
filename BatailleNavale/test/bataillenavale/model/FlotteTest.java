package bataillenavale.model;

import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipFactory;
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
public class FlotteTest {

    private List<Ship> shipListXX;
    private List<Ship> shipListXVI;


    @Before
    public void setUp() throws Exception {
        shipListXX = ShipFactory.getInstance().getShipsByEpoque(XX);
        shipListXVI = ShipFactory.getInstance().getShipsByEpoque(XVI);
    }

    @After
    public void tearDown() throws Exception {
        shipListXVI = null;
        shipListXX = null;
        assertNull(shipListXVI);
        assertNull(shipListXX);
    }


    /**
     * on test que la liste dans la flotte soit bien la bonne
     * XXeme
     */
    @Test
    public void flotteXX(){
        Flotte f = new Flotte(shipListXX);
        for(int i = 0; i < f.getShipList().size(); i++){
            assertEquals(shipListXX.get(i), f.getShipList().get(i));
        }
    }


    /**
     * on test que la liste dans la flotte soit bien la bonne
     * XVIeme
     */
    @Test
    public void flotteXVI(){
        Flotte f = new Flotte(shipListXVI);
        for(int i = 0; i < f.getShipList().size(); i++){
            assertEquals(shipListXVI.get(i), f.getShipList().get(i));
        }
    }

}