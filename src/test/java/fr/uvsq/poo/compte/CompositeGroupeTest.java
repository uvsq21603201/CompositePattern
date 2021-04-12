package fr.uvsq.poo.compte;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class CompositeGroupeTest {

	@Test
	public void creerGroupeAvecNomTest() {
	     CompositeGroupe groupe = new CompositeGroupe("Direction");
		 assertEquals("Direction",groupe.toString());	  
	}
	
	@Test
	public void ajouterCompositeGroupeACompositeGroupeTest() {
		CompositeGroupe groupe1 = new CompositeGroupe("Business");
	}
	
	@Test
	public void ajouterPersonnelCompositeGroupeCreatifTest() {
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
}
