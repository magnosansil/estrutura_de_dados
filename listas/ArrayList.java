public class ArrayList implements Listable {
  private Object[] data;
  private int head;
  private int tail;
  private int quantity;

  public ArrayList() {
      this(10);
  }

  public ArrayList(int lenght) {
      data = new Object[lenght];
      head = 0;
      tail = -1;
      quantity = 0;
  }

  @Override
  public Object select(int LogicIndex) {
      Object temp = null;
      if (isEmpty()) {
        System.err.println("List is invalid!");
      } else {
        if (LogicIndex < 0 || LogicIndex >= quantity) {
          System.err.println("Invalid index!");
        } else {
          int PhysicIndex = map(LogicIndex);
          temp = data[PhysicIndex];
          }
        }
      return temp;
  }

  @Override
  public Object[] selectAll() {
    Object[] buffer = new Object[quantity];
    int aux = head;
    for(int i = 0; i < quantity; i++) {
      buffer[i] = data[aux];
      aux = next(aux);
    }
    return buffer;
  }

  @Override
  public void update(Object data, int LogicIndex) {
      if (isEmpty()) {
        System.err.println("List is empty!");
      } else {
        if (LogicIndex < 0 || LogicIndex >= quantity) {
          System.err.println("Invalid index!");
        } else {
          int PhysicIndex = map(LogicIndex);
          this.data[PhysicIndex] = data;
        }
      }
  }

  @Override
  public void append(Object data) {
    if(isFull()) {
      System.err.println("List is full!");
    } else {
      tail = next(tail);
      this.data[tail] = data;
      quantity++;
    }
  }

  @Override
  public void clear() {
    head = 0;
    tail = -1;
    quantity = 0;
  }

  @Override
  public boolean isEmpty() {
    return quantity == 0;
  }

  @Override
  public boolean isFull() {
    return quantity == data.length;
  }

  @Override
  public String print() {
    String buffer = "";
    int aux = head;
    for(int i = 0; i < quantity; i++) {
      buffer += data[aux];
      aux = next(aux);
      if (i != quantity - 1) {
        buffer += ", ";
      }
    }
    return "[" + buffer + "]";
  }

  @Override
  public Object delete(int LogicIndex) {
    Object removed = null;
    if (isEmpty()) {
      System.err.println("List is empty!");
    } else if (LogicIndex < 0 || LogicIndex >= quantity) {
      System.err.println("Invalid index!");
    } else {
      int PhysicIndex = map(LogicIndex);
      removed = data[PhysicIndex];
      for (int i = PhysicIndex; i != tail; i = next(i)) {
        data[i] = data[next(i)];
      }
      data[tail] = null;
      tail = prev(tail);
      quantity--;
    }
    return removed;
  }

  @Override
  public void insert(Object data, int LogicIndex) {
    if (isFull()) {
      System.err.println("List is full!");
    } else if (LogicIndex < 0 || LogicIndex > quantity) {
      System.err.println("Invalid index!");
    } else {
      int PhysicIndex = map(LogicIndex);
      int i = tail;
      tail = next(tail);
      for (; i != prev(PhysicIndex); i = prev(i)) {
        this.data[next(i)] = this.data[i];
      }
      this.data[PhysicIndex] = data;
      quantity++;
    }
  }

  private int next(int index) {
    return (index + 1) % data.length;
  }

  private int prev(int index) {
    return (data.length + index - 1) % data.length;
  }

  private int map(int index) {
    return (head + index) % data.length;
  }
}