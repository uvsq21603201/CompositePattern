package fr.uvsq.pglp.serialisation;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.serialisation.Personnel;

public class PersonnelTest {
	private Personnel luke;

	  @Before
	  public void setup() {
	    luke = new Personnel.Builder("Skywalker","Luke")
	            .dateNaissance(2007, 10, 4)
	            .build();
	  }

	  @Test
	  public void creerPersonnelAvecNomPrenomTest() {
	    Personnel p = new Personnel.Builder("Skywalker","Luke").build();

	    assertPersonnel(p, "Skywalker", "Luke", Collections.emptyList(), 2000, 1, 1);
	  }

	  @Test
	  public void creerPersonnelAvecNomPrenomFonctionTest() {
	    Personnel p = new Personnel.Builder("Skywalker","Luke")
	      .ajouterFonction("Chargé de mission")
	      .ajouterFonction("Directeur")
	      .build();

	    assertPersonnel(p, "Skywalker","Luke", Arrays.asList("Chargé de mission", "Directeur"), 2000, 1, 1);
	  }

	  @Test
	  public void creerPersonnelAvecDateNaissance() {
	    assertPersonnel(luke, "Skywalker","Luke", Collections.emptyList(), 2007, 10, 4);
	  }

	  @Test
	  public void creerChaineCaracterePersonnelValideTest() {
	    assertEquals("Personnel{Nom=Skywalker, Prénom=Luke}\n", luke.toString());
	  }

	  @Test
	  public void creerUneDescriptionPersonnelTest() {
	    assertEquals("Luke Skywalker", luke.getDescription());
	  }

	  private static void assertPersonnel(Personnel p, String nom, String prenom, List<String> fonctions, int annee, int mois, int jour) {
	    assertEquals(nom, p.getNom());
	    assertEquals(prenom, p.getPrenom());
	    assertEquals(fonctions, p.getFonctions());
	    assertEquals(LocalDate.of(annee, mois, jour), p.getDateNaissance());
	  }

}
