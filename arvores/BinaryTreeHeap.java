package arvores;

public class BinaryTreeHeap implements Queuable {
  private int tail;
  private Object[] data;

  public BinaryTreeHeap() {
    this(15);
  }

  public BinaryTreeHeap(int length) {
    tail = -1;
    data = new Object[length];
  }

  private int parent(int child) {
    return (child - 1) / 2;
  }

  private int leftChild(int parent) {
    return parent * 2 + 1;
  }

  private int rightChild(int parent) {
    return parent * 2 + 2;
  }

  private void swap(int index1, int index2) {
    Object temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }

  private void heapifyUp(int index) {
    int temp = parent(index);
    while (index > 0 && (Integer) data[index] > (Integer) data[temp]) {
      swap(index, temp);
      index = temp;
      temp = parent(index);
    }
  }

  private void heapifyDown(int index) {
    while (index <= tail) {
      int left = leftChild(index);
      int right = rightChild(index);
      int bigger = index;
      if ((Integer) data[left] > (Integer) data[bigger] && left <= tail) {
        bigger = left;
      }
      if ((Integer) data[right] > (Integer) data[bigger] && right <= tail) {
        bigger = right;
      }

      if (bigger != index) {
        swap(index, bigger);
      } else {
        break;
      }
      index = bigger;
    }
  }

  @Override
  public boolean isEmpty() {
    return tail == -1;
  }

  @Override
  public boolean isFull() {
    return tail == data.length - 1;
  }

  @Override
  public Object front() {
    Object frontObject = null;
    if (isEmpty()) {
      System.err.println("Heap is empty.");
    } else {
      frontObject = data[0];
    }
    return frontObject;
  }

  @Override
  public void enqueue(Object data) {
    if (isFull()) {
      System.err.println("Heap is full.");
    } else {
      tail++;
      this.data[tail] = data;
      heapifyUp(tail);
    }
  }

  @Override
  public Object dequeue() {
    Object dequeuedObject = null;
    if (isEmpty()) {
      System.err.println("Heap is empty.");
    } else {
      dequeuedObject = data[0];
      data[0] = data[tail];
      tail--;
      heapifyDown(0);
    }

    return dequeuedObject;
  }

  @Override
  public String print() {
    String result = "";
    for (int i = 0; i <= tail; i++) {
      result += data[i];
      if (i != tail) {
        result += ", ";
      }
    }
    return "[" + result + "]";
  }
}