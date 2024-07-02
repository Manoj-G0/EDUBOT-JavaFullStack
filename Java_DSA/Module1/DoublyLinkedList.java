public class DoublyLinkedList {
    private class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            newNode.prev = tail;
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
            if (head == null) {
                head = newNode;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            if (size == 1) {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            if (size == 1) {
                head = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }
    public int find(int element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == element) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; 
    }
    public void reverse() {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
    }
    public void merge(DoublyLinkedList otherList) {
        if (otherList == null || otherList.isEmpty()) {
            return;
        }
        if (this.isEmpty()) {
            this.head = otherList.head;
            this.tail = otherList.tail;
            this.size = otherList.size;
            return;
        }
        this.tail.next = otherList.head;
        otherList.head.prev = this.tail;
        this.tail = otherList.tail;
        this.size += otherList.size;
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    runner.prev.next = runner.next;
                    if (runner.next != null) {
                        runner.next.prev = runner.prev;
                    }
                    size--;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }

    public void print() {
        System.out.print("DoublyLinkedList: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.print(); 

        list.remove(1);
        list.print(); 

        list.add(1, 40);
        list.print(); 

        System.out.println("Index of 40: " + list.find(40)); 

        list.reverse();
        list.print(); 

        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.add(0, 50);
        list2.add(1, 60);
        list.merge(list2);
        list.print(); 

        list.removeDuplicates();
        list.print(); 
    }
}
