package fr.uvsq.pglp.serialisation;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import fr.uvsq.pglp.serialisation.CompositeGroupe;
import fr.uvsq.pglp.serialisation.Personnel;

public class CompositeGroupeTest {

	@Test
	public void creerGroupeAvecNomTest() {
	     CompositeGroupe groupe = new CompositeGroupe("Direction");
		 assertEquals("Direction",groupe.toString());	  
	}
	
	@Test
	public void ajouterCompositeGroupeCreatifACompositeGroupeBusinessTest() {
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		CompositeGroupe groupe1 = new CompositeGroupe("Business");
		CompositeGroupe groupe2 = new CompositeGroupe("Créatif");
		groupe1.add(groupe2);
		groupe1.print();
		assertEquals("Composite Groupe: Business\n"+ "Composite Groupe: Créatif",outputStreamCaptor.toString());
	}
	
	@Test
	public void ajouterPersonnelACompositeGroupeCreatifTest() {
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();   
		Personnel personnel1 = new Personnel.Builder("Lob", "Jean")
	        		.ajouterFonction("Ingénieur")
	        		.ajouterFonction("Manager")
	        		.dateNaissance(1988,10,03).build();
		 CompositeGroupe groupe2 = new CompositeGroupe("Créatif");
		 groupe2.add(personnel1);
		 groupe2.print();
		 assertEquals("Composite Groupe: Créatif\nPersonnel{Nom=Lob, Prénom=Jean}\nIngénieur\nManager\n",outputStreamCaptor.toString());
	}
	
	@Test
	public void ajouterPersonnelsAGroupeTest() {
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();  
		Personnel personnel1 = new Personnel.Builder("Tristan", "Jean")
	        		.ajouterFonction("Directeur")
	        		.dateNaissance(1975,10,03).build();
		  
		   Personnel personnel2 = new Personnel.Builder("Su", "Lee")
	        		.ajouterFonction("Sous directeur")
	        		.dateNaissance(1980,12,02).build();
	      
	        Personnel personnel3 = new Personnel.Builder("Gasp", "Jim")
	        		.ajouterFonction("Stagiaire")
	        		.ajouterFonction("Commerce")
	        		.dateNaissance(1994, 04, 26).build();
	        Personnel personnel4 = new Personnel.Builder("Dupont", "Marc")
	        		.ajouterFonction("Manager")
	        		.ajouterFonction("Graphisme")
	        		.dateNaissance(1990, 01, 07).build();
	        Personnel personnel5 = new Personnel.Builder("David", "Maria")
	        		.ajouterFonction("Architecte")
	        		.ajouterFonction("Graphisme")
	        		.dateNaissance(1995,05, 18).build();
	      
	     
	       CompositeGroupe groupe = new CompositeGroupe("Direction");
	       CompositeGroupe groupe1 = new CompositeGroupe("Business");
	  	   CompositeGroupe groupe2 = new CompositeGroupe("Créatif");
	  	   groupe.add(personnel1);
	  	   groupe.add(personnel2);
	  	   groupe1.add(personnel3);
	  	   groupe2.add(personnel4);
	  	   groupe2.add(personnel5);
	  	   
	  	   groupe.add(groupe1);
	  	   groupe.add(groupe2);
	       groupe.print();
	       assertEquals("Composite Groupe: Direction\n"
	       		+ "Personnel{Nom=Tristan, Prénom=Jean} \n"
	       		+ "Directeur \n"
	       		+ "\n"
	       		+ "Personnel{Nom=Su, Prénom=Lee} \n"
	       		+ "Sous directeur \n"
	       		+ "\n"
	       		+ "Composite Groupe: Business\n"
	       		+ "Personnel{Nom=Gasp, Prénom=Jim} \n"
	       		+ "Stagiaire \n"
	       		+ "Commerce \n"
	       		+ "\n"
	       		+ "Composite Groupe: Créatif\n"
	       		+ "Personnel{Nom=Dupont, Prénom=Marc} \n"
	       		+ "Manager \n"
	       		+ "Graphisme \n"
	       		+ "\n"
	       		+ "Personnel{Nom=David, Prénom=Maria} \n"
	       		+ "Architecte \n"
	       		+ "Graphisme",outputStreamCaptor.toString());
	}
}
