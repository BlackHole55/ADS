package Assigment2;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode head;
    private MyNode tail;
    private int size;
    
    public MyLinkedList() {}

    // Size getter
    public int size() {
        return size;
    }

    public void print() {
        MyNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    // Add element to linked list
    public void add(T data) {
        MyNode newNode = new MyNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Add new element by index
    public void add(int index, T data) {
        checkIndex(index);
        MyNode newNode = new MyNode(data);
        MyNode indexNode = getNode(index);
        if (indexNode == head) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            newNode.prev = indexNode.prev;
            indexNode.prev.next = newNode;
        }

        if (indexNode == tail) {
            tail.prev = newNode;
            newNode.next = tail;
        } else {
            newNode.next = indexNode;
            indexNode.next.prev = newNode;
        }
        size++;
    }

    // Add element to the begining
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add element to the end
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    // Get element by index
    public T get(int index) {
        checkIndex(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return (T) current.data;
    }

    public T getFirst() {
        return (T) head.data;
    }

    public T getLast() {
        return (T) tail.data;
    }

    // Update element by index
    public void set(int index, T item) {
        checkIndex(index);
        MyNode nodeToChange = getNode(index);
        nodeToChange.data = item;
    }

    // Remove element by index
    public void remove(int index) {
        checkIndex(index);
        MyNode currentNode = getNode(index);

        if (currentNode == head) {
            head = head.next;
        } else {
            currentNode.prev.next = currentNode.next;
        }

        if (currentNode == tail) {
            tail = currentNode.prev;
        } else {
            currentNode.next.prev = currentNode.prev;
        }
        size--;
    }

    public void removeFirst() {
        head = head.next;
        size--;
    }

    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    private static class MyNode {
        Object data;
        MyNode next;
        MyNode prev;

        MyNode(Object data) {
            this.data = data;
        }
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }
}
