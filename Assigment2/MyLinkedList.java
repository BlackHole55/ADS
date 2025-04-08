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

    // Get element by index
    public T get(int index) {
        checkIndex(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return (T) current.data;
    }

    // Remove element by index
    public void remove(int index) {
        checkIndex(index);
        MyNode nodeToRemove = getNode(index);
        System.out.println(tail.data);
        for (int i = index; i < size; i++) {
            nodeToRemove = nodeToRemove.next;
        }
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
