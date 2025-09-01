package filas;

public class ArrayQueue implements Queuable {
  private Object[] data;
  private int head;
  private int tail;

  public ArrayQueue() {
    this(10);
  }

  public ArrayQueue(int length) {
    data = new Object[length];
    head = 0;
    tail = -1;
  }

  @Override
  public boolean isEmpty() {
    return (head - 1 == tail);
  }

  @Override
  public boolean isFull() {
    return (tail == data.length - 1);
  }

  @Override
  public String print() {
    String result = "";
    for (int i = head; i <= tail; i++) {
      result += data[i];
      if (i != tail) {
        result += ", ";
      }
    }
    return "[" + result + "]";
  }

  @Override
  public void enqueue(Object data) {
    if (isFull()) {
      System.err.println("Queue is full.");
    } else {
      this.data[++tail] = data;
    }
  }

  @Override
  public Object dequeue() {
    Object dequeuedObject = null;
    if (isEmpty()) {
      System.err.println("Queue is empty.");
    } else {
      dequeuedObject = data[head++];
    }
    return dequeuedObject;
  }

  @Override
  public Object front() {
    Object frontObject = null;
    if (isEmpty()) {
     System.err.println("Queue is empty."); 
    } else {
      frontObject = data[head];
    }
    return frontObject;
  }
}

