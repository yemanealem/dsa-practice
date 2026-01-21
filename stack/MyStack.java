import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Push element x onto stack
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        
        // Rotate the queue to bring x to the front
        for (int i = 1; i < size; i++) {
            queue.add(queue.poll());
        }
    }
    
    // Removes the element on top of the stack
    public int pop() {
        return queue.poll();
    }
    
    // Get the top element
    public int top() {
        return queue.peek();
    }
    
    // Returns whether the stack is empty
    public boolean empty() {
        return queue.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top());   // 3
        System.out.println(stack.pop());   // 3
        System.out.println(stack.top());   // 2
        System.out.println(stack.empty()); // false

        stack.pop();
        stack.pop();

        System.out.println(stack.empty()); // true
    }
}
