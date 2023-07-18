package HW3;

public class LinkedList {
    private Node head;

    public void add(int value){
        Node newNode = new Node();
        newNode.value = value;
        if(head == null){
           head = newNode;
        } else {
            Node temp = head;
            head = newNode;
            newNode.next = temp;
            
        }
    }

    public void revert(){
        if(head != null && head.next != null)
        revert(head.next, head);
    }
        

    private void revert(Node currentNode, Node previousNode){
       if(currentNode.next == null){
        head = currentNode;
       } else {
        revert(currentNode.next, currentNode);
       }

       currentNode.next = previousNode;
       previousNode.next = null;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    private class Node{
        int value;
        Node next;
    }
}
