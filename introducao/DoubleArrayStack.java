public class DoubleArrayStack {
  private Object[] data;
  private int pointerTopFirst;
  private int pointerTopSecond;

  public DoubleArrayStack() {
    this(10);
  }

  public DoubleArrayStack(int lenght) {
    data = new Object[lenght];
    pointerTopFirst = data.length;
    pointerTopSecond = -1;
  }

  public boolean isEmpty1() {
    return pointerTopFirst == data.length;
  }

  public boolean isEmpty2() {
    return pointerTopSecond == -1;
  }
  public boolean isFull1() {
    return pointerTopFirst == pointerTopSecond + 1;
  }

  public boolean isFull2() {
    return isFull1();
  }

  public String print1() {
    String result = "";
    for (int i = pointerTopFirst; i < data.length; i++) {
        result += data[i];
        if (i != data.length - 1) {
            result += ", ";
        }
    }
    return "[" + result + "]";
}

public String print2() {
    String result = "";
    for (int i = 0; i <= pointerTopSecond; i++) {
        result += data[i];
        if (i != pointerTopSecond) {
            result += ", ";
        }
    }
    return "[" + result + "]";
}

  public Object pop1() {
    if (isEmpty1()) {
      System.out.println("Empty stack");
    } else {
      return data[++pointerTopFirst];
    }
    return null;
  }

  public Object pop2() {
    if (isEmpty2()) {
      System.out.println("Empty stack");
    } else {
      return data[pointerTopSecond--];
    }
    return null;
  }

  public void push1(Object data) {
    if (!isFull1()) {
      this.data[--pointerTopFirst] = data;
    }
  }
  public void push2(Object data) {
    if (!isFull2()) {
      this.data[++pointerTopSecond] = data;
    }
  }

  public Object peek1() {
    if (isEmpty1()) {
      System.out.println("Empty stack");
      return null;
    } else {
      return data[pointerTopFirst];
    }
  }
  public Object peek2() {
    if (isEmpty2()) {
      System.out.println("Empty stack");
      return null;
    } else {
      return data[pointerTopSecond];
    }
  }

}
