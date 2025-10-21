package pilhas_encadeadas;

import java.util.NoSuchElementException;

import filas_encadeadas.DoubleNode;

public class LinkedStack<T> implements Stackable<T> {
	private DoubleNode<T> topPointer;
  private int amount;
  private int length;

  public LinkedStack() {
    this(10);
  }

  public LinkedStack(int length) {
    topPointer = null;
    amount = 0;
    this.length = length;
  }
  
  @Override
  public void push(T data) {
    if (isFull()) {
      throw new NoSuchElementException("Pilha Cheia!");
    }
    DoubleNode<T> tempNode = new DoubleNode<T>();
    tempNode.setData(data);
    tempNode.setPrevious(topPointer);
    if (!isEmpty()) {
      topPointer.setNext(tempNode);
    }
    topPointer = tempNode;
    amount++;	
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Pilha Vazia!");
    }
    T topData = topPointer.getData();
    topPointer = topPointer.getPrevious();
    amount--;
    if (!isEmpty()) {
      topPointer.setNext(null);
    }
    return topData;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Pilha Vazia!");
    }
    return topPointer.getData();
  }

	@Override
	public void update(T newData) {
		if (isEmpty()) {
			throw new NoSuchElementException("Pilha Vazia!");
		}
		topPointer.setData(newData);
	}

	@Override
	public boolean isFull() {
		return (amount == length);
	}

	@Override
	public boolean isEmpty() {
		return (amount == 0);
	}

	@Override
	public String toString() {
		String result = "";
		DoubleNode<T> auxPointer = topPointer;
		for (int i = 0; i < amount; i++) {
			result += auxPointer.getData();
			if (i != amount - 1) {
				result += ",";
			}
			auxPointer = auxPointer.getPrevious();
		}
		return "[" + result + "]";
	}
}