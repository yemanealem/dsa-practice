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


}