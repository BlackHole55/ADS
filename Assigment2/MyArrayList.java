package Assigment2;

public class MyArrayList <T extends Comparable<T>> implements MyList<T>{
    private Object[] array;
    private int size = 0;
    private int capacity = 5;

    public MyArrayList() { 
        array = new Object[capacity]; 
    }

    // Size getter
    public int size() {
        return size;
    }

    // Get element by index
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    // Get First element
    public T getFirst() {
        isEmpty();
        return (T) array[0];
    }

    // Get Last element
    public T getLast() {
        isEmpty();
        return (T) array[size - 1];
    }

    // Add new element
    public void add(T newItem) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = newItem;
    }

    // Add new element by index
    public void add(int index, T item) {
        checkIndex(index);
        if (size == capacity) {
            increaseBuffer();
        }
        size++;

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = item;
    }

    // Add new element in the begining
    public void addFirst(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        size++;

        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = item;
    }

    // Add new element to the end
    public void addLast(T newItem) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = newItem;
    }

    // Update element by index
    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }

    // Print array
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Clear array
    public void clear() {
        Object[] array2 = new Object[capacity];
        size = 0;

        array = array2;
    }

    // Remove element by index
    public void remove(int index) {
        if (size-1 == index) {
            array[index] = null;
        }
        else 
        {
            for(int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        size--;
    }

    // Remove First element
    public void removeFirst() {
        isEmpty();
        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // Remove Last element
    public void removeLast() {
        isEmpty();
        array[--size] = null;
    }

    // Sort array, using bubble sort
    public void sort() {
        int i = 0;
        boolean swapNeeded = true;
        while (i < size - 1 && swapNeeded) {
            swapNeeded = false;
            for (int j = 1; j < size - i; j++) {
                if (((T) array[j - 1]).compareTo((T) array[j]) > 0) {
                    Object temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    swapNeeded = true;                  
                }
            }
            if (!swapNeeded) {
                break;
            }
            i++;
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }

        return -1;
    }

    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return true;
            }
        }

        return false;
    }

    public Object[] toArray() {
        Object[] resultArr = new Object[size];
        for (int i = 0; i < size; i++) {
            resultArr[i] = array[i];
        }
        return resultArr;
    }

    private void increaseBuffer() {
        capacity = (int) (1.5 * capacity);
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i]; 
        }

        array = array2;
    }

    private void isEmpty() {
        if (size == 0) {
            throw new NullPointerException("ArrayList is empty");
        }
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }
}