package tdd.tennis;

/**
 * Représente le score d'un joueur de tennis.
 * @author Killian
 *
 */
public class ScoreTennis {
	private int points;
	private int jeux;
	private int set;
	private int match;
	
	public ScoreTennis() {
	}
	
	public int getJeux() {
		return jeux;
	}
	public void setJeux(int jeux) {
		this.jeux = jeux;
	}
	public int getSet() {
		return set;
	}
	public void setSet(int set) {
		this.set = set;
	}
	public int getMatch() {
		return match;
	}
	public void setMatch(int match) {
		this.match = match;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
