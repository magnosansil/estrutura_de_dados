package dao.repository;

public interface Queueable<T>{
    
    void BeginEnqueue(T data);
    void EndEnqueue(T data);
    T BeginDequeue();
    T EndDequeue();
    T front();
    T rear();
    
    boolean isEmpty();
    boolean isFull();
    String printFrontToRear();
    String printRearToFront();
}