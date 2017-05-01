package bataillenavale.model.ship;

import bataillenavale.model.ship.xx.Croiseur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wolkowicz on 30/04/2017.
 */
public class ShipPieceTest {

    Ship s;
    List<ShipPiece> list;

    @Before
    public void setUp() throws Exception {
       s = new Croiseur();
       list = s.getPieceShipList();
    }

    @After
    public void tearDown() throws Exception {
        s = null;
        assertNull(s);
    }



    @Test
    public void getStateInitial() {
        for(ShipPiece p : list){
            assertEquals(StatePiece.MISS, p.getState());
        }
    }


    @Test
    public void setState() {
        for(ShipPiece p : list){
            p.setState(StatePiece.HIT);
        }
        for(ShipPiece p : list){
            assertEquals(StatePiece.HIT, p.getState());
        }
    }


    @Test
    public void getShip() {
        for(ShipPiece p : list){
            assertEquals(s, p.getShip());
        }
    }

}