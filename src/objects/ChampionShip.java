package objects;

import java.util.Date;
import java.util.List;


public class ChampionShip {
    private String id;
    private String title;
    private String date;
    private List<Player> players;
    
	public ChampionShip(String title, List<Player> players) {
		super();
		this.id = Utils.generateStringID();
		this.title = title;
		this.date = Utils.formatData(new Date());
		this.players = players;



	}



}
