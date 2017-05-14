package bataillenavale.model.player.strategies;

import java.io.Serializable;
import java.util.Random;

import bataillenavale.model.Coordinate;
import bataillenavale.model.Map;
import bataillenavale.model.ship.ShipPiece;
import bataillenavale.model.ship.StatePiece;

public class AdvancedStrategy extends AttackStrategies implements Serializable{

	private static final long serialVersionUID = 3211547143294068452L;
	
	
	public AdvancedStrategy()
	{
		super();
	}
	
	@Override
	public int[] getStrategyShoot(Map adversMap) {
		int size = adversMap.getSize();
		taille = size;
		System.out.println("Check case détruite.");
		int[] res = checkHitButNotDestroy(adversMap);
		if (res[0] == -1)
			res = checkShipPlacement(adversMap);
		if (res[0] == -1)
			res = getNewCrossPosition(size);
		ajouteShoot(res[0], res[1]);
		return res;
	}
	
	public int[] getNewCrossPosition(int size) {
		int x=-1, y=-1;
		Random r = new Random();
		do {
			x = r.nextInt(size);
			y = 2*r.nextInt(size/2) + x%2;
		} while (!isShootPossible(x, y));
		int[] res = new int[2];
		res[0] = x;
		res[1] = y;
		return res;
	}
	
	public int[] checkHitButNotDestroy(Map adversMap) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		for (Coordinate co : listShoot) {
			int x = co.getX(), y = co.getY();
			ShipPiece sp = adversMap.getShip(x, y);
	        switch (sp.getState()){
            case HIT:
            	res[0] = x;
            	res[1] = y;
            	return res;
	        }
		}
		return res;
	}
	
	public int[] checkShipPlacement(Map adversMap){
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		for (Coordinate co : listShoot) {
			int x = co.getX(), y = co.getY();
			ShipPiece sp = adversMap.getShip(x, y);
	        switch (sp.getState()){
	            case DEAD:
	            	if ((x+1 < taille) && this.isShootPossible(x+1, y)) {
	                	res[0] = x+1;
	                	res[1] = y;
	            	} else if ((x-1 >= 0) && this.isShootPossible(x-1, y)) {
	                	res[0] = x-1;
	                	res[1] = y;            		
	            	} else if ((y+1 < taille) && this.isShootPossible(x, y+1)) {
	                	res[0] = x;
	                	res[1] = y+1;            		
	            	} else if ((y-1 >= 0) && this.isShootPossible(x, y-1)) {
	                	res[0] = x;
	                	res[1] = y-1;
	            	}
	            	if (res[0] != -1)
	            		return res;
	            	break;
	        }
		}
		return res;
	}

}
