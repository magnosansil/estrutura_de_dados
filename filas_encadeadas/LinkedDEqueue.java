package filas_encadeadas;

import java.util.NoSuchElementException;

public class LinkedDEqueue<T> {
  private int amount;
  private int capacity;
  private DoubleNode<T> head;
  private DoubleNode<T> tail;

  public LinkedDEqueue() {
    this(20);
  }

  public LinkedDEqueue(int length) {
    amount = 0;
    capacity = length;
    head = null;
    tail = null;
  }

  public boolean isEmpty() {
    return amount == 0;
  }

  public boolean isFull() {
    return amount == capacity;
  }

  public T beginDequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Fila Vazia!");
    }
    T auxData = head.getData();
    head = head.getNext();
    if (!isEmpty()) {
      head.setPrevious(null);
    } else { 
      tail = null;
    }
    return auxData;
  }
  
  public T endDequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Fila Vazia!");
    }
    amount--;
    T auxData = tail.getData();
    tail = tail.getPrevious();
    if (!isEmpty()) {
      tail.setNext(null);
    } else {
      head = null;
    }

    return auxData;
  }

  public void beginEnqueue(T data) {
    if (isFull()) {
      throw new NoSuchElementException("Fila Cheia!");
    }

    DoubleNode<T> newNode = new DoubleNode<T>();
    newNode.setData(data);

    if (isEmpty()) {
      head = newNode;
      tail = head;
    } else {
      newNode.setNext(head);
      head.setPrevious(newNode);
      head = head.getPrevious();
    }
    amount++;
  }

  public void endEnqueue(T data) {
    if (isFull()) {
      throw new NoSuchElementException("Fila Cheia!");
    }

    DoubleNode<T> newNode = new DoubleNode<T>();
    newNode.setData(data);

    if (isEmpty()) {
      tail = newNode;
      head = tail;
    } else {
      newNode.setPrevious(tail);
      tail.setNext(newNode);
      tail = tail.getNext();
    }
    amount++;
  }

  public String printFrontToRear() {
    StringBuilder sb = new StringBuilder();
    DoubleNode<T> current = head;
    while (current != null) {
      sb.append(current.getData()).append(" ");
      current = current.getNext();
    }
    return sb.toString();
  }

  public String printRearToFront() {
    StringBuilder sb = new StringBuilder();
    DoubleNode<T> current = tail;
    while (current != null) {
      sb.append(current.getData()).append(" ");
      current = current.getPrevious();
    }
    return sb.toString();
  }
}
