public class MinOperations {

    // Method to calculate minimum operations to return to main folder
    public int minOperations(String[] logs) {
        // Manual stack using array
        String[] stack = new String[logs.length]; // max possible depth
        int top = -1; // empty stack

        System.out.println("Processing logs:");

        for (String log : logs) {
            System.out.println("Log: " + log);

            if (log.equals("../")) {
                if (top >= 0) {
                    top--; // pop
                    System.out.println("Go up one folder -> pop stack");
                } else {
                    System.out.println("At main folder, cannot go up -> do nothing");
                }
            } else if (log.equals("./")) {
                System.out.println("Stay in current folder -> do nothing");
            } else {
                // push folder
                stack[++top] = log;
                System.out.println("Go into folder -> push to stack");
            }

            // Print current stack state
            System.out.print("Current stack: [");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i]);
                if (i < top) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("---------------------------");
        }

        // stack size = depth = steps to main folder
        return top + 1;
    }

    // Main method to test
    public static void main(String[] args) {
        MinOperations solution = new MinOperations();

        // Test case 1
        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println("Test Case 1:");
        int result1 = solution.minOperations(logs1);
        System.out.println("Minimum operations to return to main folder: " + result1);
        System.out.println("====================================\n");

        // Test case 2: multiple ../ at root
        String[] logs2 = {"../", "../", "d1/", "./", "d2/"};
        System.out.println("Test Case 2:");
        int result2 = solution.minOperations(logs2);
        System.out.println("Minimum operations to return to main folder: " + result2);
        System.out.println("====================================\n");

        // Test case 3: only stay logs
        String[] logs3 = {"./", "./", "./"};
        System.out.println("Test Case 3:");
        int result3 = solution.minOperations(logs3);
        System.out.println("Minimum operations to return to main folder: " + result3);
        System.out.println("====================================\n");
    }
}
