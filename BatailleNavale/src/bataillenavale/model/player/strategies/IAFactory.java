package bataillenavale.model.player.strategies;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class IAFactory {

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
                strategy = new CrossStrategy();
                break;
            case "cross":
                strategy = new RandomStrategy();
                break;
        }
        return strategy;
    }
}
