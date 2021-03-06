package bataillenavale.model;

import java.io.Serializable;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class Coordinate implements Serializable{

    private static final long serialVersionUID = 6313187226481388093L;
    protected int x;
    protected int y;

    public Coordinate(){

    }
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o){
        Coordinate c = (Coordinate)o;
        return c.x == x && c.y == y;
    }

    public String toString(){
        return "("+x+","+y+")";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
