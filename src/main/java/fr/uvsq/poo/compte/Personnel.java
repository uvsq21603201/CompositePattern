package fr.uvsq.poo.compte;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Personnel implements Groupe{
  public static LocalDate DATE_NAISSANCE = LocalDate.of(2000, 1, 1);
  
  private final String nom;
  private final String prenom;
  private final List<String> fonctions;
  private final List<String> numeros;
  private LocalDate dateNaissance;
  
  
     private Personnel(Builder builder) {
	    this.nom = builder.nom;
	    this.prenom = builder.prenom;
	    this.fonctions = builder.fonctions;
	    this.numeros = builder.numeros;
	    this.dateNaissance = builder.dateNaissance;
	  }
  
      public String getNom() {
	    return this.nom;
	  }

	  public String getPrenom() {
	    return this.prenom;
	  }
	  
	  public String getDescription() {
		  return this.prenom + ' '+this.nom;
	  }

	  public List<String> getFonctions() {
	    return this.fonctions;
	  }
	  
	  public List<String> getNumeros(){
		  return this.numeros;
	  }

	  public LocalDate getDateNaissance() {
	    return this.dateNaissance;
	  }

	  @Override
	  public String toString() {
	    return "Personnel{Nom=" + this.nom + "," + " Prénom=" + this.prenom + "} ";
	  }
  
  public static class Builder{
	  private final String nom;
	  private final String prenom;
	  private final List<String> fonctions;
	  private final List<String> numeros;
	  private LocalDate dateNaissance;
	  
	  public Builder(String nom,String prenom) {
		  this.nom = nom;
		  this.prenom = prenom;
		  
		  this.fonctions = new ArrayList<>();
		  this.numeros = new ArrayList<>();
		  this.dateNaissance = DATE_NAISSANCE;
	}
	 
	  public Personnel build() {
	      return new Personnel(this);
	    }

	    public Builder ajouterFonction(String fonction) {
	      fonctions.add(fonction);
	      return this;
	    }
	    
	    public Builder ajouterNumeros(String numero) {
	    	numeros.add(numero);
	    	return this;
	    }
	    

	    public Builder dateNaissance(int annee, int mois, int jour) {
	      dateNaissance = LocalDate.of(annee, mois, jour);
	      return this;
	    }
	  
	  
  }

@Override
public void print() {
	System.out.println(this.toString());			
	for(String f: fonctions) {
		System.out.println(f+" ");
	}System.out.print("\n");
	
}
}
