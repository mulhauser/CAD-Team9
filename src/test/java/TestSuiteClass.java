/**
 * Created by wolkowicz on 30/04/2017.
 */


import bataillenavale.model.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * classe a lancer pour executer toutes les classes de test
 * on peut choisir l ordre des tests a executer
 */


/**
 * PROBLEMES : CHEMINS ABSOLU POUR SHIP
 *             ID et PSEUDO DANS PROFILE QUI S INCREMENTENT BIZAREMENT
 */


/**
 * A FAIRE
 * fire player(finir) human bot
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        CoordinateTest.class,
        FlotteTest.class,
        MapTest.class,
        PartieTest.class,
        ProfileTest.class
})



public class TestSuiteClass {
}






