package LinkedList;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data + " " + n);
            n = n.next;
        }
    }

    //thêm vào đầu danh sách liên kết
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        // cho node mới trỏ tới node đầu tiên
        new_node.next = head;
        //cập nhật node đầu bằng node mới
        head = new_node;
    }

    //thêm node mới vào sau một node cụ thể
    public void insertAfter(Node prev_node, int new_data) {
        /*1. Check if the given Node is null*/
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);

        // node mới trỏ tới node sau node hiện tại
        new_node.next = prev_node.next;

        //node hiện tại trỏ tới node mới
        prev_node.next = new_node;
    }

    /*//thêm node mới vào trước một node cụ thể
    public void insertBefore(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);

        //lấy ra node trước node hiện tại
        Node before_Node = null;
        before_Node.next = prev_node;

        System.out.println("before_Node: " + before_Node);
        before_Node.next = new_node;
        new_node.next = prev_node;
    }*/

    //thêm vào cuối danh sách

    public static void main(String[] args) {
        // write your code here
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        linkedList.head.next = second;

        second.next = third;

        linkedList.push(100);
        linkedList.insertAfter(second, 1000);
        //linkedList.insertBefore(third, 1000);

        linkedList.printList();
    }
}
