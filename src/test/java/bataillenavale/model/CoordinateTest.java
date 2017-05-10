package bataillenavale.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wolkowicz on 30/04/2017.
 */
public class CoordinateTest {

    int x = 2,y = 2;
    Coordinate c = new Coordinate(x, y);





    @Test
    public void equals() throws Exception {
        // que tester ici ?
    }


    @Test
    public void setX() throws Exception {
        c.setX(5);
        assertEquals(5, c.getX());
    }


    @Test
    public void setY() throws Exception {
        c.setY(5);
        assertEquals(5, c.getY());
    }

}