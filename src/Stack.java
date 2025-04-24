// Catherine Neely

class Node {

    String data;
    Node next = null;

    public Node(String i) {
        data = i;
    }
    public Node(String i, Node n) {
        data = i;
        next = n;
    }
}

class LinkedList {

    public Node head;
    public Node tail;
    public int size = 0;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(String newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean contains(String newData) {
        Node curr = head;
        while (curr != null) {
            if (curr.data.equals(newData)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int size() {
        return size;
    }
}

public class Stack {
    Node head = null;
    private int size = 0;

    public Stack(Node node) {
        head = new Node(node.data);
        size++;
    }
    public Stack () {
        head = null;
        size = 0;
    }

    public void push(Node node) {
        Node newNode = new Node(node.data, head);
        head = newNode;
        size++;
    }

    public Node pop() {
        if (head == null) {
            return null;
        }
        Node n = head;
        head = head.next;
        size--;
        return n;
    }

    public Node peek() {
        if (head == null) {
            return null;
        }
        return head;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void printStack(Node head) {
        Stack tmp = new Stack();
        while(!isEmpty()) {
            Node n = pop();
            System.out.print(n.data + " ");
            tmp.push(n);
        }
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
    }

    public int stackSize () {
        return size;
    }
}
