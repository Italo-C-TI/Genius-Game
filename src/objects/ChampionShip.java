package objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ChampionShip {
    private String id;
    private String title;
    private String date;
    private ArrayList<Player> players;
    
	public ChampionShip(String title, ArrayList<Player> players) {
		super();
		this.id = Utils.generateStringID();
		this.title = title;
		this.date = Utils.formatData(new Date());
		this.players = players;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}



}
