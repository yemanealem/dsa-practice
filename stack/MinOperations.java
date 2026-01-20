public class MinOperations {

    // Method to calculate minimum operations to return to main folder
    public int minOperations(String[] logs) {
        // Manual stack using array
        String[] stack = new String[logs.length]; // max possible depth
        int top = -1; // empty stack

        for (String log : logs) {
            if (log.equals("../")) {
                if (top >= 0) top--; // pop
            } else if (log.equals("./")) {
                // stay in current folder, do nothing
            } else {
                // push folder
                stack[++top] = log;
            }
        }

        // stack size = depth = steps to main folder
        return top + 1;
    }

    // Main method to test
    public static void main(String[] args) {
        MinOperations solution = new MinOperations();

        // Test example
        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        int result = solution.minOperations(logs);

        System.out.println("Minimum operations to return to main folder: " + result);
    }
}
