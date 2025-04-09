package Assigment2;

public class MyStack {
    MyArrayList<Integer> stack = new MyArrayList<>();

    // Check is stack empty
    public boolean empty() {
        if (stack.size() == 0) {
            return true;
        }

        return false;
    }

    // Return size of stack
    public int size() {
        return stack.size();
    }

    // Adds the element at the top of the stack
    public int push(int item) {
        stack.addLast(item);

        return item;
    }

    public int peek() {
        if (empty()) {
            throw new NullPointerException("Stack is empty");
        }
        return stack.getLast();
    }

    public int pop() {
        if (empty()) {
            throw new NullPointerException("Stack is empty");
        }
        
        int result = stack.getLast();

        stack.removeLast();

        return result;
    }
}
