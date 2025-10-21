package filas_encadeadas;

public class Main {
    public static void main(String[] args) {
        LinkedDEqueue<String> deq = new LinkedDEqueue<>(5);

        // beginEnqueue (adds to front)
        deq.beginEnqueue("A");
        deq.beginEnqueue("B");

        // endEnqueue (adds to rear)
        deq.endEnqueue("1");
        deq.endEnqueue("2");

        System.out.println("DEQueue front to rear: " + deq.printFrontToRear());
        System.out.println("DEQueue rear to front: " + deq.printRearToFront());
        System.out.println("isEmpty: " + deq.isEmpty());
        System.out.println("isFull: " + deq.isFull());

        // beginDequeue
        System.out.println("Removed from front: " + deq.beginDequeue());
        // endDequeue
        System.out.println("Removed from rear: " + deq.endDequeue());

        System.out.println("After removals front to rear: " + deq.printFrontToRear());
        System.out.println("After removals rear to front: " + deq.printRearToFront());
    }
}
