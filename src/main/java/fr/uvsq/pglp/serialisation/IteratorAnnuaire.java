package fr.uvsq.pglp.serialisation;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class IteratorAnnuaire implements Iterator<Groupe> {
  private Collection<Groupe> annuaireCollection;
  private CompositeGroupe rootNode;
  protected abstract Groupe getCollection();

  public IteratorAnnuaire(final CompositeGroupe groupe,final Collection<Groupe> collection){
      this.setAnnuaireCollection(collection);
      this.rootNode = groupe;
      this.getAnnuaireCollection().addAll(rootNode.getAnnuaire());
  }

  public CompositeGroupe getRootNode() {
      return this.rootNode;
  }
  public Collection<Groupe> getAnnuaireCollection() {
   return this.annuaireCollection;
  }
  public void setAnnuaireCollection(final Collection<Groupe> annuaire){
      this.annuaireCollection = annuaire;
  }

  @Override
  public boolean hasNext() {
      return !getAnnuaireCollection().isEmpty();
  }

  @Override
  public Groupe next(){
      if(!hasNext()){
          System.out.println("Erreur no element");
          throw new NoSuchElementException();
      }
      else {
          Groupe leaf = getCollection();
          if(leaf != null){
              if(leaf.isCompositeGroupe() != false){
                  getAnnuaireCollection().addAll(((CompositeGroupe) leaf).getAnnuaire());
              }
              return leaf;
          } else {
              System.out.println("Null");
              return leaf;
          }
      }
  }



}
