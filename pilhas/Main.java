package pilhas;

public class Main {
    public static void main(String[] args) {
        DoubleArrayStack stack = new DoubleArrayStack(5);

        stack.push1("A");
        stack.push1("B");
        stack.push2("1");
        stack.push2("2");

        System.out.println("Stack 1: " + stack.print1());
        System.out.println("Stack 2: " + stack.print2());

        System.out.println("Pop stack 1: " + stack.pop1());
        System.out.println("Pop stack 2: " + stack.pop2());

        System.out.println("Stack 1 after pop: " + stack.print1());
        System.out.println("Stack 2 after pop: " + stack.print2());

        InvertedArrayStack invertedStack = new InvertedArrayStack(5);
        invertedStack.push("X");
        invertedStack.push("Y");
        invertedStack.push("Z");

        System.out.println("Inverted stack: " + invertedStack.print());
        System.out.println("Pop inverted stack: " + invertedStack.pop());
        System.out.println("Inverted stack after pop: " + invertedStack.print());
    }
}