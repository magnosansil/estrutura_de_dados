public interface Stackable<T> {
    void push(T data);     
    T peek();              
    void update(T newData);
    T pop();              

    boolean isEmpty();
    boolean isFull();
    String toString();
}