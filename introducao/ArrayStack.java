public class ArrayStack implements Stackable {
  private Object[] data;
  private int pointerTop;

  public ArrayStack() {
    this(10);
  }

  public ArrayStack(int length) {
    data = new Object[length];
    pointerTop = -1;
  }

  @Override
  public boolean isEmpty() {
    return pointerTop == -1;
  }

  @Override
  public boolean isFull() {
    return pointerTop == data.length - 1;
  }

  @Override
  public Object pop() {
    if (isEmpty()) {
      System.out.println("Empty stack");
    } else {
      return data[pointerTop--];
    }
    return null;
  }

  @Override
  public void push(Object data) {
    if (!isFull()) {
      this.data[++pointerTop] = data;
    }
  }

  @Override
  public Object peek() {
    if (isEmpty()) {
      System.out.println("Empty stack");
      return null;
    } else {
      return data[pointerTop];
    }
  }

  @Override
  public String print() {
    String result = "";
    for (int i = pointerTop; i >= 0; i--) {
      result += data[i];
      if (i != 0) {
        result += ", ";
      }
    }
    return "[" + result + "]";
  }
}
