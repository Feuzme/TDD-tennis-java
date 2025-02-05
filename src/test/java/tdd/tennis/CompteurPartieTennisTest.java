package tdd.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	@DisplayName("Un utilisateur peut cr�er une nouvelle partie avec deux joueurs")
	void test_utilisateur_cree_partie() {
		partie = compteur.nouvellePartie(joueur1, joueur2);
		assertNotNull(partie);
	}

	@Test
	@DisplayName("Au d�but de la partie le joueur 1 a 0 points.")
	void test_joueur1_score_debut_nul() {
		assertEquals(0, partie.getScoreJoueur1().getPoints());
	}

	@Test
	@DisplayName("Au d�but de la partie le joueur 2 a 0 points.")
	void test_joueur2_score_debut_nul() {
		assertEquals(0, partie.getScoreJoueur2().getPoints());
	}

	@Test
	@DisplayName("Au d�but de la partie les joueurs ont 0 jeux gagn�s.")
	void test_joueurs_jeux_debut_nuls() {
		assertEquals(0, partie.getScoreJoueur2().getJeux());
		assertEquals(0, partie.getScoreJoueur1().getJeux());
	}

	@Test
	@DisplayName("Au d�but de la partie les joueurs ont 0 sets gagn�s.")
	void test_joueurs_sets_debut_nuls() {
		assertEquals(0, partie.getScoreJoueur2().getSet());
		assertEquals(0, partie.getScoreJoueur1().getSet());
	}

	@Test
	@DisplayName("Au d�but de la partie les joueurs ont 0 matchs gagn�s.")
	void test_joueurs_matchs_debut_nuls() {
		assertEquals(0, partie.getScoreJoueur2().getSet());
		assertEquals(0, partie.getScoreJoueur1().getSet());
	}

	@Test
	@DisplayName("L'utilisateur peut notifier que Joueur1 a gagn� un point.")
	void test_joueur1_gagme_point() {
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		assertNotEquals(0, partie.getScoreJoueur1().getPoints());
	}

	@Test
	@DisplayName("L'utilisateur peut notifier que Joueur2 a gagn� un point.")
	void test_joueur2_gagme_point() {
		partie = compteur.joueurGagne(partie, partie.getJoueur2());
		assertNotEquals(0, partie.getScoreJoueur2().getPoints());
	}

	@Test
	@DisplayName("Quand joueur1 gagne un point, il passe de 0 � 15")
	void test_joueur1_gagme_0a15() {
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		assertEquals(15, partie.getScoreJoueur1().getPoints());
	}

	@Test
	@DisplayName("Quand joueur2 gagne un point, il passe de 0 � 15")
	void test_joueur2_gagme_0a15() {
		partie = compteur.joueurGagne(partie, partie.getJoueur2());
		assertEquals(15, partie.getScoreJoueur2().getPoints());
	}

	@Test
	@DisplayName("Quand un joueur1 gagne un point, il passe de 15 � 30")
	void test_joueur1_gagme_15a30() {
		partie.getScoreJoueur1().setPoints(15);
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		assertEquals(30, partie.getScoreJoueur1().getPoints());
	}

	@Test
	@DisplayName("Quand un joueur2 gagne un point, il passe de 15 � 30")
	void test_joueur2_gagme_15a30() {
		partie.getScoreJoueur2().setPoints(15);
		partie = compteur.joueurGagne(partie, partie.getJoueur2());
		assertEquals(30, partie.getScoreJoueur2().getPoints());
	}

	@Test
	@DisplayName("Quand un joueur1 gagne un point, il passe de 30 � 40.")
	void test_joueur1_gagme_30a40() {
		partie.getScoreJoueur1().setPoints(30);
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		assertEquals(40, partie.getScoreJoueur1().getPoints());
	}

	@Test
	@DisplayName("Quand un joueur2 gagne un point, il passe de 30 � 40.")
	void test_joueur2_gagme_30a40() {
		partie.getScoreJoueur2().setPoints(30);
		partie = compteur.joueurGagne(partie, partie.getJoueur2());
		assertEquals(40, partie.getScoreJoueur2().getPoints());
	}
	
	@Test
	@DisplayName("si le joueur est � 40 point et gagne alors il gagne le jeu")
	void test_gagne_jeu() {
		partie.getScoreJoueur1().setPoints(40);		
		partie = compteur.joueurGagne(partie, partie.getJoueur1());		
		assertEquals(1, partie.getScoreJoueur1().getJeux());
		partie.getScoreJoueur1().setPoints(0);
		
		partie.getScoreJoueur2().setPoints(40);
		partie = compteur.joueurGagne(partie, partie.getJoueur2());
		assertEquals(1, partie.getScoreJoueur2().getJeux());
	}
	
	@Test
	@DisplayName("Si les deux joueurs sont a egalit� a 40 points, si aucun joueur a un avantage, le joueur qui gagne le point gagne un avantage")
	void test_egalite_40_gagnant_avantage() {
		partie.getScoreJoueur1().setPoints(40);
		partie.getScoreJoueur2().setPoints(40);
		
		partie = compteur.joueurGagne(partie, partie.getJoueur1());
		partie = compteur.joueurGagne(partie, partie.getJoueur2());
		
		assertTrue(partie.getScoreJoueur1().isAvantage());
	}
}
