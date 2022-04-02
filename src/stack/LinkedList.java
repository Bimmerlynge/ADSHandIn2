package stack;

import util.EmptyListException;

public class LinkedList<T> implements List<T>
{
  private Node<T> head;
  private int size;


  @Override public boolean isEmpty()
  {
    return size == 0;
  }

  @Override public int size()
  {
    return size;
  }

  @Override public void addToFront(T data)
  {
    Node<T> newNode = new Node<>(data);
    newNode.setNext(head);
    head = newNode;
    size++;
  }

  @Override public T removeFirst() throws EmptyListException
  {
    if (size == 0)
      throw new EmptyListException("Tried to remove from an empty list");
    Node<T> returnNode = head;
    head = returnNode.getNext();
    size--;
    return returnNode.getData();
  }

  @Override
  public T lookFirst() throws EmptyListException {
    if (size == 0)
      throw new EmptyListException("Tried to peek from an empty list");
    Node<T> returnNode = head;
    return returnNode.getData();
  }
}
