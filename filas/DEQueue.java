package filas;

public class DEQueue {
  private Object[] data;
  private int head, tail, quantity;

  public DEQueue(int length) {
    data = new Object[length];
    head = 0;
    tail = -1;
    quantity = 0;
  }

  public boolean isEmpty() {
    return quantity == 0;
  }

  public boolean isFull() {
    return quantity == data.length;
  }

  public void beginEnqueue(Object data) {
    if (isFull()) {
      System.err.println("Queue is full.");
    } else {
      tail = next(tail);
      quantity++;
      this.data[tail] = data;
    }
  }

  public void endEnqueue(Object data) {
    if (isFull()) {
      System.err.println("Queue is full.");
    } else {
      head = prev(head);
      this.data[head] = data;
      quantity++;
    }
  }

  public Object beginDequeue() {
    Object dequeuedObject = null;
    if (isEmpty()) {
      System.err.println("Queue is empty.");
    } else {
      dequeuedObject = data[head];
      head = next(head);
      quantity--;
    }

    return dequeuedObject;
  }

  public Object endDequeue() {
    Object dequeuedObject = null;
    if (isEmpty()) {
      System.err.println("Queue is empty.");
    } else {
      dequeuedObject = data[tail];
      tail = prev(tail);
      quantity--;
    }

    return dequeuedObject;
  }

  private int next(int head) {
    return (head + 1) % data.length;
  }

  private int prev(int head) {
    return ((head - 1) + data.length) % data.length;
  }

  public Object front() {
    Object frontObject = null;
    if (isEmpty()) {
      System.err.println("Queue is empty.");
    } else {
      frontObject = data[head];
    }

    return frontObject;
  }

  public Object rear() {
    Object rearObject = null;
    if (isEmpty()) {
      System.err.println("Queue is empty.");
    } else {
      rearObject = data[tail];
    }

    return rearObject;
  }

  public String printFrontToRear() {
    String result = "";
    int temp = head;
    for (int i = 0; i < quantity; i++) {
      result += data[temp];
      temp = next(temp);
      if (i != quantity - 1) {
        result += ", ";
      }
    }
    return "[" + result + "]";
  }

  public String printRearToFront() {
    String result = "";
    int temp = tail;
    for (int i = 0; i < quantity; i++) {
      result += data[temp];
      temp = prev(temp);
      if (i != quantity - 1) {
        result += ", ";
      }
    }
    return "[" + result + "]";
  }
}
