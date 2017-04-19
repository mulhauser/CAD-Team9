package bataillenavale.player;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Map {

    private int[][] map;
    private int size;

    public Map(int s){
        this.size = s;
        this.map = new int[this.size][this.size];
    }
}
