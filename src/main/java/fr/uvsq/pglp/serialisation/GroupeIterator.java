package fr.uvsq.pglp.serialisation;
import java.util.*;
public class GroupeIterator<T> implements Iterator<T>{
  private Set<T> visited = new HashSet<T>();
  private Queue<T> queue = new LinkedList<T>();
  
  public GroupeIterator() {
	  
  }

@Override
public boolean hasNext() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public T next() {
	// TODO Auto-generated method stub
	return null;
}

}

