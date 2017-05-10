package bataillenavale.model.player.strategies;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class CrossStrategy extends AttackStrategies implements Serializable{

    private static final long serialVersionUID = 6834726075740598097L;

    public CrossStrategy(){
        super();
    }

    private int[] storedPosition = {-1,-1};
    //1 signifie de gauche à droite et -1 pour de droite à gauche, défaut = 1
    private int diagonalWay = 1;


    @Override
    public int[] getStrategyShoot(int size) {
        //car resultat = coordonnees x et y
        int[] res = new int[2];
        Random r = new Random();

        //déclaration des variables
        int y = 0;
        boolean tirOk = false;
        int x = r.nextInt(size);
        //si on a pas de position stockée :
        if(this.storedPosition[0]==-1 && this.storedPosition[1]==-1){
            //1 : on regarde sur quelle ligne tirer au hasard
            while(!isLigneAvailable(y,size)){
                y++;
            }
            //2 : on tir au hasard sur cette ligne et on stock la position
            while(!isShootPossible(x,y)){
                x = r.nextInt(size);
            }
            //on sait ici que le tir(x,y) est possible
            res[0] = x;
            res[1] = y;
            this.storedPosition[0] = x;
            this.storedPosition[1] = y;
        }else{
            //sinon (donc si on a une position stockée)
            //si on peut aller en diagonale on y va (stop permet de savoir si on peut ou pas)
            int stop = 0;
            if((this.storedPosition[0]+this.diagonalWay)<size && (this.storedPosition[1]+1)<size &&
                    (this.storedPosition[0]+this.diagonalWay)>-1 && (this.storedPosition[1]+1)>-1){
                if(isShootPossible(this.storedPosition[0]+this.diagonalWay,this.storedPosition[1]+1)){
                    this.storedPosition[0] = this.storedPosition[0]+this.diagonalWay;
                    this.storedPosition[1] = this.storedPosition[1]+1;
                    res[0] = this.storedPosition[0];
                    res[1] = this.storedPosition[1];
                    stop = 1;
                }
            }
            if(stop==0){
                //sinon on réinitialise la position stockée
                this.storedPosition[0] = -1;
                this.storedPosition[1] = -1;
                // et on retire au hasard sur la première ligne disponible en partant du haut
                //1 : on regarde sur quelle ligne tirer au hasard
                while(!isLigneAvailable(y,size)){
                    y++;
                }
                //2 : on tir au hasard sur cette ligne et on stock la position
                while(!isShootPossible(x,y)){
                    x = r.nextInt(size);
                }
                //on sait ici que le tir(x,y) est possible
                res[0] = x;
                res[1] = y;
                this.storedPosition[0] = x;
                this.storedPosition[1] = y;
                //on inverse le sens des diagonales pour après
                this.diagonalWay *= -1;
            }
        }

        //on ajoute le tire avec listShoot.add(new Coordinate(x, y)); dans ajouteShoot
        //on est certain que la fonction retourne true
        ajouteShoot(res[0], res[1]);

        return res;
    }

    public String toString(){
        return "Cross";
    }

    //on doit vérifier qu'il est possible de tirer sur la ligne du haut puis les suivantes
    public boolean isLigneAvailable(int y, int size){
        for(int x=0; x<size; x++){
            if(isShootPossible(x,y)){
                return true;
            }
        }
        return false;
    }
}
