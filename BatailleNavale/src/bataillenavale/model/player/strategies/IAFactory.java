package bataillenavale.model.player.strategies;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class IAFactory implements Serializable{

    private static IAFactory instance = new IAFactory();

    private IAFactory(){
    }

    public static IAFactory getInstance(){
        if(instance == null){
            instance = new IAFactory();
        }
        return instance;
    }

    public AttackStrategies getStrategy(String strat){
        AttackStrategies strategy = null;
        switch (strat){
            case "random":
                strategy = new RandomStrategy();
                break;
            case "cross":
                strategy = new CrossStrategy();
                break;
        }
        return strategy;
    }
}
