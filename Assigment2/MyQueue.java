package Assigment2;

public class MyQueue {
    MyLinkedList<Integer> queue = new MyLinkedList<>();

    // Check is stack empty
    public boolean empty() {
        if (queue.size() == 0) {
            return true;
        }

        return false;
    }

    // Return size of stack
    public int size() {
        return queue.size();
    }

    // Retruns front element of queue
    public int peek() {
        if (empty()) {
            throw new NullPointerException("Stack is empty");
        }
        return queue.getFirst();
    }

    public int enqueue(int item) {
        queue.addLast(item);
        
        return queue.getLast();
    }

    public int dequeue() {
        if (empty()) {
            throw new NullPointerException("Stack is empty");
        }
        int result = queue.getFirst();
        queue.removeFirst();
        return result;
    }
}
