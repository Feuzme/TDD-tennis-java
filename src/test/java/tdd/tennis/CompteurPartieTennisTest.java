package tdd.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompteurPartieTennisTest {

	PartieDeTennis partie;
	CompteurPartieTennis compteur = new CompteurPartieTennis();
	JoueurDeTennis joueur1 = new JoueurDeTennis();
	JoueurDeTennis joueur2 = new JoueurDeTennis();

	@BeforeEach
	@Test
	@DisplayName("Un utilisateur peut créer une nouvelle partie avec deux joueurs")
	void test_utilisateur_cree_partie() {
		partie = compteur.nouvellePartie(joueur1, joueur2);
		assertNotNull(partie);
	}
	
	@Test
	@DisplayName("Au début de la partie le joueur 1 a 0 points.")
	void test_joueur1_score_debut_nul() {
		assertEquals(0, partie.getScoreJoueur1().getPoints());
	}
	
	@Test
	@DisplayName("Au début de la partie le joueur 2 a 0 points.")
	void test_joueur2_score_debut_nul() {
		assertEquals(0, partie.getScoreJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("Au début de la partie les joueurs ont 0 jeux gagnés.")
	void test_joueurs_jeux_debut_nuls() {
		assertEquals(0, partie.getScoreJoueur2().getJeux());
		assertEquals(0, partie.getScoreJoueur1().getJeux());
	}
	
	@Test
	@DisplayName("Au début de la partie les joueurs ont 0 sets gagnés.")
	void test_joueurs_sets_debut_nuls() {
		assertEquals(0, partie.getScoreJoueur2().getSet());
		assertEquals(0, partie.getScoreJoueur1().getSet());
	}
	
	@Test
	@DisplayName("Au début de la partie les joueurs ont 0 matchs gagnés.")
	void test_joueurs_matchs_debut_nuls() {
		assertEquals(0, partie.getScoreJoueur2().getSet());
		assertEquals(0, partie.getScoreJoueur1().getSet());
	}
	
	@Test
	@DisplayName("L'utilisateur peut notifier que Joueur1 a gagné un point.")
	void test_joueur1_gagme_point() {
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		assertNotEquals(0, partie.getScoreJoueur1().getPoints());
	}
	
	@Test
	@DisplayName("L'utilisateur peut notifier que Joueur2 a gagné un point.")
	void test_joueur2_gagme_point() {
		partie = compteur.joueurGagne(partie, partie.getJoueur2());
		assertNotEquals(0, partie.getScoreJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("Quand un joueur gagne un point, il passe de 0 à 15")
	void test_joueur_gagme_0a15() {
		assertEquals(0, partie.getScoreJoueur1().getPoints());
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		assertEquals(15, partie.getScoreJoueur1().getPoints());
	}
	@Test
	@DisplayName("Quand un joueur gagne un point, il passe de 15 à 30")
	void test_joueur_gagme_15a30() {
		assertEquals(15, partie.getScoreJoueur1().getPoints());
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		assertEquals(30, partie.getScoreJoueur1().getPoints());
	}
	@Test
	@DisplayName("Quand un joueur gagne un point, il passe de 30 à 40.")
	void test_joueur_gagme_30a40() {
		assertEquals(30, partie.getScoreJoueur1().getPoints());
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		assertEquals(40, partie.getScoreJoueur1().getPoints());
	}
	
	
}
