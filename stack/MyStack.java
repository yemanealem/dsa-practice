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

        System.out.println(stack.top());  
        System.out.println(stack.pop());  
        System.out.println(stack.top());   
        System.out.println(stack.empty()); 

        stack.pop();
        stack.pop();

        System.out.println(stack.empty()); 
    }
}


/*
How it works (Stack using Single Queue Approach):

1. Use a custom queue implemented with a circular array to store elements.
   - The front of the queue always represents the top of the stack.
   - rear points to where the next element will be inserted.
   - size tracks the number of elements in the queue.

2. push(x):
   - Add x to the rear of the queue using offer().
   - Rotate the queue size-1 times:
       - Remove the element from the front (poll()) and add it to the rear (offer()).
       - This moves the newly added element to the front, simulating stack behavior (LIFO).
   
3. pop():
   - Remove and return the element from the front of the queue (queue.poll()).
   - This corresponds to removing the top of the stack.

4. top():
   - Return the element at the front of the queue without removing it (queue.peek()).
   - This corresponds to reading the top of the stack.

5. empty():
   - Return true if the queue is empty (size == 0), false otherwise.

Example Trace (push sequence: 10, 20, 30):

Step | Operation     | Queue (front → rear) | Top of Stack
-----|---------------|--------------------|-------------
1    | push(10)      | [10]               | 10
2    | push(20)      | [20, 10]           | 20
3    | push(30)      | [30, 20, 10]       | 30
4    | top()         | [30, 20, 10]       | 30
5    | pop()         | [20, 10]           | 20
6    | top()         | [20, 10]           | 20
7    | pop()         | [10]               | 10
8    | pop()         | []                 | - (stack empty)

Time Complexity:
- push: O(n), because rotation requires moving size-1 elements.
- pop: O(1)
- top: O(1)
- empty: O(1)

Space Complexity:
- O(n) for storing the elements in the queue.
*/
