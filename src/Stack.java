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

    public Stack(Node node) {
        head = new Node(node.data);
    }
    public Stack () {
        head = null;
    }

    public void push(Node node) {
        Node newNode = new Node(node.data, head);
        newNode.next = head;
        head = newNode;
    }

    public Node pop() {
        Node n = head;
        head = head.next;
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
        Stack tmp = null;
        while(!isEmpty()) {
            Node n = pop();
            System.out.print(n.data + " ");
            tmp.push(n);
        }
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
    }

    public int stackSize (Stack stack) {
        int size = 0;
        Stack tempStack = new Stack();
        while (!stack.isEmpty()) {
            Node tempNode = stack.pop();
            tempStack.push(tempNode);
            size++;
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return size;
    }
}
