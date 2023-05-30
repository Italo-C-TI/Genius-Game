package objects;

import java.util.List;




public class ChampionShip {
    private String id;
    private List<Player> players;
    
	public ChampionShip(List<Player> players) {
		super();
		this.id = Utils.generateStringID();
		this.players = players;
	}



}
