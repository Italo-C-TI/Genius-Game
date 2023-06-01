package objects;

public class Player {
    private String name;
    private String nickname;
    private int totalPoints;
    private long totalTime;
    private long fastestPlayTime;
    
	public Player(String name, String nickname) {
		super();
		this.name = name;
		this.nickname = nickname;
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
	public int getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	public long getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}
	public long getFastestPlayTime() {
		return fastestPlayTime;
	}
	public void setFastestPlayTime(long fastestPlayTime) {
		this.fastestPlayTime = fastestPlayTime;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", nickname=" + nickname + ", totalPoints=" + totalPoints + ", totalTime="
				+ totalTime + ", fastestPlayTime=" + fastestPlayTime + "]";
	}

}
