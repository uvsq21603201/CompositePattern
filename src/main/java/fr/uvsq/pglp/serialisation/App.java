package fr.uvsq.pglp.serialisation;


/**
 * Main application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
    
    }
}
