package fr.uvsq.pglp.serialisation;

import java.util.ArrayList;
import java.util.List;

public class CompositeGroupe implements Groupe {
	private String nom;
	private List<Groupe> annuaire = new ArrayList <Groupe>();
	public CompositeGroupe(String nom) {
		this.nom=nom;
	}
	@Override
	public void print() {
		System.out.println("Composite Groupe: "+this.nom);
		for(Groupe g: annuaire) {
			g.print();
		}
	}
	
	public void add(Groupe g){
		annuaire.add(g);
	}
	
	public String toString() {
		return this.nom;
	}

}
