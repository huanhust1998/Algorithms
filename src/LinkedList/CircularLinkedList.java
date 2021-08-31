package LinkedList;

public class CircularLinkedList {

    static class Node {
        int data;
        Node next;
    }

    public static Node push(Node head_ref, int data) {
        Node prev = new Node();
        Node temp = head_ref;
        prev.data = data;
        prev.next = head_ref;

        if (head_ref != null) {
            while (temp.next != head_ref) {
                temp = temp.next;
            }
            temp.next = prev;
        } else {
            prev.next = prev;
        }
        head_ref = prev;
        return head_ref;
    }

    public static void printNode(Node head) {
        Node temp = head;
        do {
            System.out.println(temp.data + " :" + temp);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        Node head = null;

        head = push(head, 1234);
        head = push(head, 12345);
        head = push(head, 12346);
        head = push(head, 12347);
        printNode(head);
    }
}

