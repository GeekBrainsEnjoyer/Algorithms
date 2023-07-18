package HW3;

public class Program {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

        ll.revert();

        ll.print();
    }
}
