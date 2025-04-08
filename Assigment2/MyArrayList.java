package Assigment2;

public class MyArrayList <T> {
    private Object[] array;
    private int size = 0;
    private int capacity = 5;

    public MyArrayList() { 
        array = new Object[capacity]; 
    }

    public T get(int index) {
        return (T) array[index];
    }

    public T getFirst() {
        return (T) array[0];
    }

    public T getLast() {
        return (T) array[--size];
    }

    public void add(T newItem) {
        if(size == capacity) {
            increaseBuffer();
        }
        array[size++] = newItem;
    }

    public void add(int index, T item) {
        if(index >= size) {
            System.out.println("Index out of bound");
            
        }
        else {
            array[index] = item;
        }
    }

    public void addFirst(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        size++;

        for(int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = item;
    }

    public void addLast(T newItem) {
        if(size == capacity) {
            increaseBuffer();
        }
        array[size++] = newItem;
    }

    public void set(int index, T item) {
        if(index >= size) {
            System.out.println("Index out of bound");
            
        }
        else {
            array[index] = item;
        }
    }

    public void print() {
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void clear() {
        Object[] array2 = new Object[capacity];
        size = 0;

        array = array2;
    }

    public void delete(int index) {
        if(size-1 == index) {
            array[index] = null;
        }
        else 
        {
            for(int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
        }
        size--;
    }

    private void increaseBuffer() {
        capacity = (int) (1.5 * capacity);
        Object[] array2 = new Object[capacity];
        for(int i = 0; i < size; i++) {
            array2[i] = array[i]; 
        }

        array = array2;
    }
}