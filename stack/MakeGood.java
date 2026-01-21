class MakeGood {
    public String makeGood(String s) {
        char[] stack = new char[s.length()]; // manual stack
        int top = -1; // stack pointer

        for (char c : s.toCharArray()) {
            if (top >= 0 && isBadPair(stack[top], c)) {
                top--; // pop the bad pair
            } else {
                stack[++top] = c; // push current character
            }
        }

        return new String(stack, 0, top + 1);
    }

    // Helper method to check if two characters form a bad pair
    private boolean isBadPair(char a, char b) {
        return Math.abs(a - b) == 32; // same letter, different case
    }

    // Main method for testing
    public static void main(String[] args) {
        MakeGood sol = new MakeGood();

        String s1 = "leEeetcode";
        String s2 = "abBAcC";
        String s3 = "s";
        String s4 = "aAbBcCdD";

        System.out.println("Input: " + s1 + " -> Output: " + sol.makeGood(s1)); // leetcode
        System.out.println("Input: " + s2 + " -> Output: " + sol.makeGood(s2)); // ""
        System.out.println("Input: " + s3 + " -> Output: " + sol.makeGood(s3)); // s
        System.out.println("Input: " + s4 + " -> Output: " + sol.makeGood(s4)); // ""
    }
}
