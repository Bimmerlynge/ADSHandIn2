package stack;

import util.EmptyListException;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T>
{
  private LinkedList<T> list;

  public LinkedStack(){
    list = new LinkedList<>();
  }
  @Override public boolean isEmpty()
  {
    return list.isEmpty();
  }

  @Override public void push(T elm)
  {
    list.addToFront(elm);
  }

  @Override public T pop() throws EmptyStackException
  {

    try
    {
      return list.removeFirst();
    }
    catch (EmptyListException e)
    {
      System.out.println(e.getMessage());
      throw new EmptyStackException();
    }
  }

  @Override
  public T peek() throws EmptyStackException {
    try
    {
      return list.removeFirst();
    }
    catch (EmptyListException e)
    {
      System.out.println(e.getMessage());
      throw new EmptyStackException();
    }
  }
}
