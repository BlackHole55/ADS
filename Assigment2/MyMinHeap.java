package Assigment2;

public class MyMinHeap {
    MyArrayList<Integer> minHeap = new MyArrayList<>();

    public boolean empty() {
        if (minHeap.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return minHeap.size();
    }

    public void insert(int item) {
        minHeap.add(item);

        int current = minHeap.size() - 1;
        
        while (minHeap.get(current) < minHeap.get(parentOf(current))) {
            swap(current, parentOf(current));

            current = parentOf(current);
        }
    }

    public int getMin() {
        return minHeap.getFirst();
    }

    public int extractMin() {
        int result = minHeap.getFirst();
        minHeap.removeFirst();
        heapify(0);
        
        return result;
    }

    private void heapify(int index) {
        if (leftChildOf(index) != -1 && rightChildOf(index) != -1) {
            int leftChild = minHeap.get(leftChildOf(index));
            int rightChild = minHeap.get(rightChildOf(index));
            if (minHeap.get(index) > leftChild || minHeap.get(index) > rightChild) {
                if (leftChild < rightChild) {
                    swap(index, leftChildOf(index));
                    heapify(leftChildOf(index));
                } else {
                    swap(index, rightChildOf(index));
                    heapify(rightChildOf(index));
                }
            }
        }    
    }

    private int leftChildOf(int index) {
        int leftChildIndex = (index * 2) + 1;
        if (leftChildIndex >= minHeap.size()) {
            return -1;
        }

        return leftChildIndex;
    }

    private int rightChildOf(int index) {
        int rightChildIndex = (index * 2) + 2;
        if (rightChildIndex >= minHeap.size()) {
            return -1;
        }

        return rightChildIndex;
    }

    private int parentOf(int index) {
        int parentIndex = (int) (index - 1) / 2;
        
        return parentIndex;
    }

    private void swap(int index1, int index2) {
        int temp = minHeap.get(index1);
        minHeap.set(index1, minHeap.get(index2));
        minHeap.set(index2, temp);
    }
}
