package filas;

public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("Queue: " + queue.print());
        System.out.println("Front of queue: " + queue.front());

        // Dequeue
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Queue after remove: " + queue.print());

        queue.enqueue("D");
        queue.enqueue("E");
        System.out.println("Final queue: " + queue.print());
    }
}
