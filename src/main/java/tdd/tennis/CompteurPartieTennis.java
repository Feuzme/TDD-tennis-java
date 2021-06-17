package tdd.tennis;

/**
 * Cette classe contient tout le code permettant de calculer les points au
 * tennis.
 * 
 * @author Killian
 *
 */
public class CompteurPartieTennis {

	/**
	 * Cette Methode permet de créer une nouvelle partie de tennis. Une partie
	 * contient 2 joueurs et 2 Scores Au debut de la partie, les score sont a 0.
	 * 
	 * @param joueur1 premier joueur de la partie
	 * @param joueur2 deuxieme joueur de la partie
	 * @return une nouvelle partie.
	 */
	public PartieDeTennis nouvellePartie(JoueurDeTennis joueur1, JoueurDeTennis joueur2) {
		return new PartieDeTennis(joueur1, joueur2);
	}

	/**
	 * Cette methode doit etre appeler lors ce qu'un joueur gagne un point.
	 * 
	 * @param partie  qui est jouer.
	 * @param gagnant Joueur qui a gagner.
	 * @return La partie avec les nouveaux scores.
	 */
	public PartieDeTennis joueurGagne(PartieDeTennis partie, JoueurDeTennis gagnant) {
		ScoreTennis nvScoreTennis = new ScoreTennis();
		
		if (gagnant == partie.getJoueur1()) {
			if (partie.getScoreJoueur1().getPoints() == 0)
				nvScoreTennis.setPoints(15);
			if (partie.getScoreJoueur1().getPoints() == 15)
				nvScoreTennis.setPoints(30);
			if (partie.getScoreJoueur1().getPoints() == 30)
				nvScoreTennis.setPoints(40);
			
			if(partie.getScoreJoueur1().getPoints() == 40) {
				nvScoreTennis.setJeux(partie.getScoreJoueur1().getJeux() + 1);
			}				
			
			partie.setScoreJoueur1(nvScoreTennis);
		}

		if (gagnant == partie.getJoueur2()) {			
			if(partie.getScoreJoueur2().getPoints() == 0)
				nvScoreTennis.setPoints(15);			
			if(partie.getScoreJoueur2().getPoints() == 15)
				nvScoreTennis.setPoints(30);			
			if(partie.getScoreJoueur2().getPoints() == 30)
				nvScoreTennis.setPoints(40);		
			
			if(partie.getScoreJoueur2().getPoints() == 40)
				nvScoreTennis.setJeux(partie.getScoreJoueur2().getJeux() + 1);
			
			partie.setScoreJoueur2(nvScoreTennis);
		}

		return partie;
	}
}
