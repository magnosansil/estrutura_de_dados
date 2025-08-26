package pilhas;

public class InvertedArrayStack implements Stackable {
    private Object[] data;
    private int pointerTop;

    public InvertedArrayStack(){
      this(10);
    }

    public InvertedArrayStack(int length) {
        data = new Object[length];
        pointerTop = data.length;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return null;
        }
        return data[pointerTop++];
    }

    @Override
    public void push(Object value) {
        if (pointerTop > 0) {
            data[--pointerTop] = value;
        } else {
            System.out.println("Stack is full");
        }
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return null;
        }
        return data[pointerTop];
    }

    @Override
    public boolean isFull() {
        return pointerTop == 0;
    }

    @Override
    public boolean isEmpty() {
        return pointerTop == data.length;
    }

    public String print() {
        String result = "";
        for (int i = pointerTop; i < data.length; i++) {
            result += data[i];
            if (i != data.length - 1) {
                result += ", ";
            }
        }
        return "[" + result + "]";
    }
}
