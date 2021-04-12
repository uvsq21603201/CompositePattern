package fr.uvsq.poo.compte;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Personnel personnel1 = new Personnel.Builder("Lob", "Jean")
        		.ajouterFonction("Ingénieur")
        		.ajouterFonction("Manager")
        		.dateNaissance(1988,10,03).build();
      
        Personnel personnel3 = new Personnel.Builder("Low", "Francis")
        		.ajouterFonction("Stagiaire")
        		.ajouterFonction("Comptabilité")
        		.dateNaissance(1990, 04, 05).build();
      
        Personnel personnel2 = new Personnel.Builder("Lob", "Jean")
        		.ajouterFonction("Ingénieur")
        		.ajouterFonction("Manager")
        		.dateNaissance(1988,10,03).build();
	   CompositeGroupe groupe2 = new CompositeGroupe("Créatif");
	   groupe2.add(personnel2);
	   groupe2.print();
       
	   final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); 
	   final PrintStream standardOut = System.out;
	   System.setOut(new PrintStream(outputStreamCaptor));
	   
	   System.out.print(outputStreamCaptor.toString());
        
        
        
        
       
        
        /*
        groupe1.add(personnel3);
        
        
        groupe2.add(personnel4);
        
        groupe.add(groupe1);
        groupe.add(groupe2);
        */
        
    }
}
