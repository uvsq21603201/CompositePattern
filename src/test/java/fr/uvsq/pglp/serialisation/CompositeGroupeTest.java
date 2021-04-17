package fr.uvsq.pglp.serialisation;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompositeGroupeTest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	@After
	public void tearDown() {
	    System.setOut(standardOut);
	}

	@Test
	public void creerGroupeAvecNomTest() {
	     CompositeGroupe groupe = new CompositeGroupe("Direction",1);
		 assertEquals("Direction",groupe.toString());	  
	}

	@Test
	public void ajouterPersonnelACompositeGroupeDirection() {
		Personnel personnel1 = new Personnel.Builder("Tristan", "Jean")
				.ajouterFonction("Directeur")
				.dateNaissance(1975,10,03)
				.ajouterNumeros("01 23 45 67 89")
				.ajouterNumeros("06 44 29 18 07").build();
		CompositeGroupe groupe = new CompositeGroupe("Direction",1);
		groupe.add(personnel1);
		groupe.print();
		assertEquals("Composite Groupe: Direction\n"
				+ "Personnel{Nom=Tristan, Prénom=Jean, Date de naissance=1975-10-03, Numéros=[01 23 45 67 89, 06 44 29 18 07]}\n"
				+ "Directeur",outputStreamCaptor.toString().trim());
	}

	@Test
	public void ajouterCompositeGroupeBusinessACompositeGroupeDirection(){
		CompositeGroupe groupe = new CompositeGroupe("Direction",1);
		CompositeGroupe groupe1 = new CompositeGroupe("Business",2);
		groupe.add(groupe1);
		groupe.print();
		assertEquals("Composite Groupe: Direction\n"
				+ "Composite Groupe: Business",outputStreamCaptor.toString().trim());
	}

    @Test
	public void iteratorGroupeTest() {
    	Personnel personnel1 = new Personnel.Builder("Tristan", "Jean")
				.ajouterFonction("Directeur")
				.dateNaissance(1975,10,03)
				.ajouterNumeros("01 23 45 67 89")
				.ajouterNumeros("06 44 29 18 07").build();

		Personnel personnel2 = new Personnel.Builder("Su", "Lee")
				.ajouterFonction("Sous directeur")
				.dateNaissance(1980,12,02)
				.ajouterNumeros("03 47 55 89 98").build();

		Personnel personnel3 = new Personnel.Builder("Gasp", "Jim")
				.ajouterFonction("Stagiaire")
				.ajouterFonction("Commerce")
				.dateNaissance(1994, 04, 26)
				.ajouterNumeros("06 71 15 36 74").build();
		Personnel personnel4 = new Personnel.Builder("Dupont", "Marc")
				.ajouterFonction("Manager")
				.ajouterFonction("Graphisme")
				.dateNaissance(1990, 01, 07)
				.ajouterNumeros("01 29 51 62 32").build();
		Personnel personnel5 = new Personnel.Builder("David", "Maria")
				.ajouterFonction("Architecte")
				.ajouterFonction("Graphisme")
				.dateNaissance(1995,05, 18)
				.ajouterNumeros("06 84 19 78 24")
				.ajouterNumeros("07 55 58 02 44").build();


		CompositeGroupe groupe = new CompositeGroupe("Direction",1);
		CompositeGroupe groupe1 = new CompositeGroupe("Business",2);
		CompositeGroupe groupe2 = new CompositeGroupe("Créatif",3);
		groupe.add(personnel1);
		groupe.add(personnel2);
		groupe1.add(personnel3);
		groupe2.add(personnel4);
		groupe2.add(personnel5);

		groupe.add(groupe1);
		groupe.add(groupe2);
		IteratorBFS itGroupe = groupe.getIteratorBFS();
		System.out.print(itGroupe.getRootNode().toString()+"\n");
		do {
			System.out.print(itGroupe.next().toString());
			System.out.print("\n");
		} while (itGroupe.hasNext());
      assertEquals("Direction\n"
      		+ "Personnel{Nom=Tristan, Prénom=Jean, Date de naissance=1975-10-03, Numéros=[01 23 45 67 89, 06 44 29 18 07]}\n"
      		+ "Personnel{Nom=Su, Prénom=Lee, Date de naissance=1980-12-02, Numéros=[03 47 55 89 98]}\n"
      		+ "Business\n"
      		+ "Créatif\n"
      		+ "Personnel{Nom=Gasp, Prénom=Jim, Date de naissance=1994-04-26, Numéros=[06 71 15 36 74]}\n"
      		+ "Personnel{Nom=Dupont, Prénom=Marc, Date de naissance=1990-01-07, Numéros=[01 29 51 62 32]}\n"
      		+ "Personnel{Nom=David, Prénom=Maria, Date de naissance=1995-05-18, Numéros=[06 84 19 78 24, 07 55 58 02 44]}", outputStreamCaptor.toString().trim());
	}

	@Test
	public void iteratorHierarchieTest() {
		Personnel personnel1 = new Personnel.Builder("Tristan", "Jean")
				.ajouterFonction("Directeur")
				.dateNaissance(1975,10,03)
				.ajouterNumeros("01 23 45 67 89")
				.ajouterNumeros("06 44 29 18 07").build();

		Personnel personnel2 = new Personnel.Builder("Su", "Lee")
				.ajouterFonction("Sous directeur")
				.dateNaissance(1980,12,02)
				.ajouterNumeros("03 47 55 89 98").build();

		Personnel personnel3 = new Personnel.Builder("Gasp", "Jim")
				.ajouterFonction("Stagiaire")
				.ajouterFonction("Commerce")
				.dateNaissance(1994, 04, 26)
				.ajouterNumeros("06 71 15 36 74").build();
		Personnel personnel4 = new Personnel.Builder("Dupont", "Marc")
				.ajouterFonction("Manager")
				.ajouterFonction("Graphisme")
				.dateNaissance(1990, 01, 07)
				.ajouterNumeros("01 29 51 62 32").build();
		Personnel personnel5 = new Personnel.Builder("David", "Maria")
				.ajouterFonction("Architecte")
				.ajouterFonction("Graphisme")
				.dateNaissance(1995,05, 18)
				.ajouterNumeros("06 84 19 78 24")
				.ajouterNumeros("07 55 58 02 44").build();


		CompositeGroupe groupe = new CompositeGroupe("Direction",1);
		CompositeGroupe groupe1 = new CompositeGroupe("Business",2);
		CompositeGroupe groupe2 = new CompositeGroupe("Créatif",3);
		groupe.add(personnel1);
		groupe.add(personnel2);
		groupe1.add(personnel3);
		groupe2.add(personnel4);
		groupe2.add(personnel5);

		groupe.add(groupe1);
		groupe.add(groupe2);
		IteratorDFS itHierarchique = groupe.getIteratorDFS();
		do {
			System.out.print(itHierarchique.next().toString());
			System.out.print("\n");
		} while (itHierarchique.hasNext());
		System.out.print(itHierarchique.getRootNode().toString()+"\n");
		assertEquals("Créatif\n"
				+ "Personnel{Nom=David, Prénom=Maria, Date de naissance=1995-05-18, Numéros=[06 84 19 78 24, 07 55 58 02 44]}\n"
				+ "Personnel{Nom=Dupont, Prénom=Marc, Date de naissance=1990-01-07, Numéros=[01 29 51 62 32]}\n"
				+ "Business\n"
				+ "Personnel{Nom=Gasp, Prénom=Jim, Date de naissance=1994-04-26, Numéros=[06 71 15 36 74]}\n"
				+ "Personnel{Nom=Su, Prénom=Lee, Date de naissance=1980-12-02, Numéros=[03 47 55 89 98]}\n"
				+ "Personnel{Nom=Tristan, Prénom=Jean, Date de naissance=1975-10-03, Numéros=[01 23 45 67 89, 06 44 29 18 07]}\n"
				+ "Direction",outputStreamCaptor.toString().trim());
	}

	
	
}
