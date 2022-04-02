package stack;

import util.EmptyListException;


public interface List<T>
{
  boolean isEmpty();
  int size();
  void addToFront(T data);
  T removeFirst() throws EmptyListException;
  T lookFirst() throws EmptyListException;
}
