public class Main {
  public static void main(String[] args) {
    ArrayList list = new ArrayList(5);

    list.append("A");
    list.append("B");
    list.append("C");
    System.out.println("List: " + list.print());

    list.insert("X", 1);
    System.out.println("List after insert at index 1: " + list.print());

    Object deleted = list.delete(2);
    System.out.println("Deleted element at index 2: " + deleted);
    System.out.println("List after delete at index 2: " + list.print());

    System.out.println("Element at index 1: " + list.select(1));

    list.update("Z", 1);
    System.out.println("List after update: " + list.print());

    Object[] all = list.selectAll();
    System.out.print("All elements: [");
    for (int i = 0; i < all.length; i++) {
      System.out.print(all[i]);
      if (i != all.length - 1) System.out.print(", ");
    }
    System.out.println("]");

    list.clear();
    System.out.println("List after clear: " + list.print());
  }
}
