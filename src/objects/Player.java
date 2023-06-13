package objects;

public class Player {
    private String id;
    private String name;
    private String nickname;
    private Integer totalPoints;
    private Integer totalTime;
    private Integer fastestPlayTime;

    
	public Player(String id,String name,String nickname) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.totalPoints = 0;
		this.totalTime = 0;
		this.fastestPlayTime = 0;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}
	public void addPoints(Integer points) {
		this.totalPoints+= points;
	}
	public Integer getTotalTime() {
		return totalTime;
	}
	public void setAddTime(Integer time) {
		this.totalTime+= time;
	}
	public Integer getFastestPlayTime() {
		return fastestPlayTime;
	}
	public void setFastestPlayTime(Integer fastestPlayTime) {
		if(this.fastestPlayTime == 0 ||  this.fastestPlayTime > fastestPlayTime) {
			this.fastestPlayTime = fastestPlayTime;
		}
	}

    
	@Override
	public String toString() {
		return    "nome: " + name + ",\n"
				+ "apelido: " + nickname + ",\n"
				+ "pontos: " + totalPoints + ",\n"
				+ "tempo total: " + totalTime + " segundos" + ",\n"
				+ "jogada mais rápida: " + fastestPlayTime + " segundos" + "\n"
				+ "------------------------------------------------\n";

	}
}
