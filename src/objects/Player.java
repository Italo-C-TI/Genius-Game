package objects;

public class Player {
    private String id;
    private String name;
    private String nickname;
    private Integer totalPoints;
    private Double totalTime;
    private Double fastestPlayTime;

    
	public Player(String id,String name,String nickname) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.totalPoints = 0;
		this.totalTime = 0.0;
		this.fastestPlayTime = 0.0;
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
	public Double getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Double totalTime) {
		this.totalTime = totalTime;
	}
	public Double getFastestPlayTime() {
		return fastestPlayTime;
	}
	public void setFastestPlayTime(Double fastestPlayTime) {
		this.fastestPlayTime = fastestPlayTime;
	}

    
	@Override
	public String toString() {
		return  nickname + " - " + totalPoints ;

	}
}
