package fr.uvsq.pglp.serialisation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeGroupe implements Groupe,Iterable<Groupe>{
	private String nom;
	private List<Groupe> annuaire = new ArrayList <Groupe>();
	private int id;
	public CompositeGroupe(final String n, final int idGroupe) {
		this.nom = n;
		this.id = idGroupe;
	}

	public List<Groupe> getAnnuaire(){
		return this.annuaire;
	}


	public void add(final Groupe g){
		annuaire.add(g);
	}

	public void remove(final Groupe groupe){
		this.annuaire.remove(groupe);
	}

	public IteratorBFS getIteratorBFS(){
         return new IteratorBFS(this);
	}
	public IteratorDFS getIteratorDFS(){
       return new IteratorDFS(this);
	}

	@Override
	public void print() {
		System.out.print("Composite Groupe: "+this.nom);
		System.out.print("\n");
		for(Groupe g: annuaire) {
			g.print();
		}
	}

	@Override
	public boolean isCompositeGroupe() {
		return true;
	}

	@Override
	public String toString() {
		return this.nom;
	}

	@Override
	public Iterator<Groupe> iterator() {
		return annuaire.listIterator();
	}






}
