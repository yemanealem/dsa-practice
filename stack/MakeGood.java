class Solution {
    public String makeGood(String s) {
        char[] stack = new char[s.length()]; // manual stack
        int top = -1; // stack pointer, -1 means empty

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (top >= 0 && Math.abs(stack[top] - c) == 32) {
                // top and current form a bad pair (same letter different case)
                top--; // pop
            } else {
                stack[++top] = c; // push
            }
        }

        // Build resulting string from stack
        return new String(stack, 0, top + 1);
    }
}
