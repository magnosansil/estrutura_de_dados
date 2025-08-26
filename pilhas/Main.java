package pilhas;

public class Main {
    public static void main(String[] args) {
        DoubleArrayStack stack = new DoubleArrayStack(5);

        stack.push1("A");
        stack.push1("B");
        stack.push2("1");
        stack.push2("2");

        System.out.println("Pilha 1: " + stack.print1());
        System.out.println("Pilha 2: " + stack.print2());

        System.out.println("Pop pilha 1: " + stack.pop1());
        System.out.println("Pop pilha 2: " + stack.pop2());

        System.out.println("Pilha 1 após pop: " + stack.print1());
        System.out.println("Pilha 2 após pop: " + stack.print2());

        InvertedArrayStack invertedStack = new InvertedArrayStack(5);
        invertedStack.push("X");
        invertedStack.push("Y");
        invertedStack.push("Z");

        System.out.println("Pilha invertida: " + invertedStack.print());
        System.out.println("Pop pilha invertida: " + invertedStack.pop());
        System.out.println("Pilha invertida após pop: " + invertedStack.print());
    }
}