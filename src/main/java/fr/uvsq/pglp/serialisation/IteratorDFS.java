package fr.uvsq.pglp.serialisation;

import java.util.Stack;

public class IteratorDFS extends IteratorAnnuaire{
    public IteratorDFS(final CompositeGroupe groupe){
        super(groupe,new Stack<Groupe>());
    }
    @Override
    protected Groupe getCollection() {
        return ((Stack<Groupe>) getAnnuaireCollection()).pop();
    }
}
