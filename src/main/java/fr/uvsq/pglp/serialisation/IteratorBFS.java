package fr.uvsq.pglp.serialisation;

import java.util.ArrayDeque;

public class IteratorBFS extends IteratorAnnuaire{

    public IteratorBFS(final CompositeGroupe groupe){
        super(groupe,new ArrayDeque<Groupe>());
    }

    @Override
    protected Groupe getCollection() {
        return ((ArrayDeque<Groupe>) getAnnuaireCollection()).remove();
    }


}
