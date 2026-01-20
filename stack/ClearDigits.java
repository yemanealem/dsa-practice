public class ClearDigits {

    // Method: repeatedly remove first digit and closest non-digit to its left
    public String clearDigits(String s) {
        // Manual stack using char array
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Remove closest non-digit to the left
                while (top >= 0 && Character.isDigit(stack[top])) {
                    top--; // remove previous digits if any
                }
                if (top >= 0) top--; // remove closest non-digit
                // Skip adding this digit
            } else {
                // push non-digit
                stack[++top] = ch;
            }
        }

        // Build final string
        return new String(stack, 0, top + 1);
    }

    // Main method to test
    public static void main(String[] args) {
        ClearDigits solution = new ClearDigits();

        // Test cases
        String[] testCases = {
            "a1b2c3",       // should return ""
            "x9y8z7",       // should return ""
            "ab12cd34ef",   // should return "ef"
            "1a2b3c",       // should return ""
            "abc123def"     // should return "def"
        };

        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + solution.clearDigits(test));
            System.out.println("----------------------");
        }
    }
}
