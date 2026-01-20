public class MinOperations {
    
}
class Solution {
    public int minOperations(String[] logs) {
       String[] stack = new String[logs.length];
    int top = -1; // empty stack

    for (String log : logs) {
        if (log.equals("../")) {
            if (top >= 0) {
                top--; // pop
            }
        } else if (log.equals("./")) {
            // stay in current folder, do nothing
        } else {
            // go into folder, push
            top++;
            stack[top] = log;
        }
    }

    // number of folders deep = stack size
    return top + 1; 
    }
}