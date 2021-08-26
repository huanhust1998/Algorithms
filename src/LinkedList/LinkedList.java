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

    public void printNode() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data + "  " + n);
            n = n.next;
        }
    }

    //I. Chèn phần tử vào danh sách
    //thêm phần tử vào đầu danh sách
    public void push(int new_data) {
        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;
        //head.next = new_node;
    }

    //thêm vào sau một node
    public void insertAfter(Node node, int new_data) {
        if (node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);

        new_node.next = node.next;

        node.next = new_node;
    }

    // thêm vào trước một node
    public void insertBefore(Node node, int new_data) {
        if (node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node new_node = new Node(new_data);

        new_node.next = node;

        Node n = head;

        while (n.next != node) {
            if (n.next == node)
                break;
            n = n.next;
        }
        n.next = new_node;
        return;
    }

    //thêm vào cuối danh sách
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        Node n = head;
        if (n == null) {
            head = new Node(new_data);
        } else {
            while (n.next != null) {
                n = n.next;
            }
        }
        new_node.next = null;
        n.next = new_node;
        return;
    }

    // II. Xóa phần tử khỏi danh sách
    // xóa ở đầu danh sách
    public void deleteHead() {
        Node temp = head;
        if (temp != null) {
            head = temp.next;
        }
    }

    //xóa ở cuối danh sách
    public void pop() {
        Node last = head;
        while (last.next.next != null) {
            last = last.next;
        }
        last.next = null;
    }

    //xóa phần tử cụ thể
    public void deleteNode(int data) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }
        //tìm ra node
        while (temp != null) {
            if (temp.data == data) break;
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);

        linkedList.head.next = first;
        first.next = second;

        linkedList.push(123);
        linkedList.insertAfter(first, 100);
        linkedList.insertBefore(first, 1000);
        linkedList.append(100000);
        linkedList.deleteHead();
        linkedList.deleteNode(2);
        linkedList.printNode();
    }
}
