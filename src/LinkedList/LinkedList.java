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

    //III. Tìm chiều dài của mảng
    public int countLength() {
        int count = 0;

        Node n = head;
        while (n != null) {
            n = n.next;
            count++;
        }
        return count;
    }

    public int getCount(Node node) {
        if (node == null)
            return 0;
        return 1 + getCount(node.next);
    }

    public int getCount1() {
        return getCount(head);
    }

    //Tìm phần tử trong danh sách
    public boolean search1(int key) {
        Node n = head;
        while (n != null) {
            if (n.data == key) return true;
            n = n.next;
        }
        return false;
    }

    public boolean search2(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return search2(node.next, key);
    }

    // Đảo ngược danh sách
    // sử dụng vòng lặp
    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // sử dụng đệ quy
    public Node reverse1(Node node) {
        if (node == null || node.next == null)
            return node;
        Node rest = reverse1(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
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
        linkedList.printNode();
        System.out.println("=========");
        /*linkedList.deleteHead();
        linkedList.deleteNode(2);*/
        /*System.out.println("Length of linked list: " + linkedList.countLength());
        System.out.println("Length of linked list: " + linkedList.getCount1());
        System.out.println("True or false: " + linkedList.search1(100));
        System.out.println("True or false: " + linkedList.search2(linkedList.head, 10));
        linkedList.printNode();
        System.out.println("=========");
        Node n = linkedList.reverse(linkedList.head);
        while (n != null) {
            System.out.println(n.data + " " + n);
            n = n.next;
        }*/
        Node n = linkedList.reverse1(linkedList.head);
        while (n != null) {
            System.out.println(n.data + " " + n);
            n = n.next;
        }
    }
}
