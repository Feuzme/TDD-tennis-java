package tdd.tennis;

/**
 * Cette classe represente une partie de tennis entre deux joueur avec leurs scores.
 * @author Killian
 *
 */
public class PartieDeTennis {

	private JoueurDeTennis joueur1;
	private JoueurDeTennis joueur2;
	
	private ScoreTennis scoreJoueur1;
	private ScoreTennis scoreJoueur2;
	
	
	public PartieDeTennis() {
		// TODO Auto-generated constructor stub
	}
	
	public PartieDeTennis(JoueurDeTennis j1, JoueurDeTennis j2) {
		super();
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.scoreJoueur1 = new ScoreTennis();
		this.scoreJoueur2 = new ScoreTennis();
	}
	/*
	 * GET && SET
	 */
	public JoueurDeTennis getJoueur1() {
		return joueur1;
	}
	public void setJoueur1(JoueurDeTennis joueur1) {
		this.joueur1 = joueur1;
	}
	public JoueurDeTennis getJoueur2() {
		return joueur2;
	}
	public void setJoueur2(JoueurDeTennis joueur2) {
		this.joueur2 = joueur2;
	}
	public ScoreTennis getScoreJoueur1() {
		return scoreJoueur1;
	}
	public void setScoreJoueur1(ScoreTennis scoreJoueur1) {
		this.scoreJoueur1 = scoreJoueur1;
	}
	public ScoreTennis getScoreJoueur2() {
		return scoreJoueur2;
	}
	public void setScoreJoueur2(ScoreTennis scoreJoueur2) {
		this.scoreJoueur2 = scoreJoueur2;
	}
}
