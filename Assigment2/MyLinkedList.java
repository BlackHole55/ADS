package Assigment2;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode head;
    private MyNode tail;
    private int size;
    
    public MyLinkedList() {}

    // Size getter
    public int size() {
        return size;
    }

    public void print() {
        MyNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
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
        isEmpty();
        return (T) head.data;
    }

    public T getLast() {
        isEmpty();
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
        isEmpty();
        head = head.next;
        size--;
    }

    public void removeLast() {
        isEmpty();
        if (size <= 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }


    // Sort LinkedList using Bubble sort
    public void sort() {
        int i = 0;
        boolean swapNeeded = true;

        while (i < size - 1 && swapNeeded) {
            swapNeeded = false;

            MyNode current = head;
            MyNode nextNode = head.next;

            for (int j = 0; j < size - i - 1; j++) {
                if (((T) current.data).compareTo((T) nextNode.data) > 0) {
                    Object temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;

                    swapNeeded = true;                  
                }
                current = nextNode;
                nextNode = nextNode.next;
            }
            if (!swapNeeded) {
                break;
            }
            i++;
        }
    }

    // Get index of element by object
    public int indexOf(Object object) {
        isEmpty();
        MyNode current = head;
        int i = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return i;
            }
            current = current.next;
            i++;
        }

        return -1;
    }

    // Get index of last element by object
    public int lastIndexOf(Object object) {
        isEmpty();
        MyNode current = tail;
        int i = size - 1;
        while (current != null) {
            if (current.data.equals(object)) {
                return i;
            }
            current = current.prev;
            i--;
        }

        return -1;
    }

    // Check if object exists
    public boolean exists(Object object) {
        MyNode current = head;
        while (current != null) {
            if (current.data.equals(object)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public Object[] toArray() {
        Object[] array =  new Object[size];
        MyNode current = head;
        int i = 0;
        while (current != null) {
            array[i] = current.data;
            current = current.next;
            i++;
        }

        return array;
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

    private void isEmpty() {
        if (head == null) {
            throw new NullPointerException("LinkedList is empty");
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
