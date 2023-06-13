package objects;

import java.util.*;

import utils.Utils;


public class Championship {
    private String id;
    private String title;
    private String date;
    private List<Player> players;
    
	public Championship(String title, List<Player> players) {
		super();
		this.id = Utils.generateChampionshipID();
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

	public void setDate() {
		this.date = Utils.formatData(new Date());
	}

	public void cleanChampionship() {
		this.title = null;
		this.date = null;
		this.players = null;
	}

	public String getPlayersNickName() {
		StringBuffer allPlayersNickName = new StringBuffer();
		 for(Player player : players){
			 allPlayersNickName.append(player.getName() + "\n");
		 }
		return allPlayersNickName.toString();

	}
	
	
	@Override
	public String toString() {
		return "Campeonato " + title + " criado no dia " + date + " com os jogadores: \n" + getPlayersNickName();
	}
	

	public String details() {
		return "Campeonato " + title + " criado no dia " + date + "\n" + players.toString();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
