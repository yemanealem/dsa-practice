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


/*
How it works:

1. Iterate over the string from left to right.
2. Maintain a manual stack of characters using an array.
3. If a character is a digit:
   - Remove any digits at the top of the stack (to handle consecutive digits).
   - Remove the closest non-digit to the left from the stack.
   - Skip adding the current digit.
4. If a character is not a digit, push it onto the stack.
5. After processing all characters, the stack contains the remaining string.
6. Convert the stack back to a string and return it.

Example Trace (input: "ab12cd34ef"):

Step | Character | Action                          | Stack
-----|-----------|---------------------------------|------
1    | 'a'       | Non-digit → push               | [a]
2    | 'b'       | Non-digit → push               | [a, b]
3    | '1'       | Digit → pop closest non-digit  | [a]    (removed 'b')
4    | '2'       | Digit → pop closest non-digit  | []     (removed 'a')
5    | 'c'       | Non-digit → push               | [c]
6    | 'd'       | Non-digit → push               | [c, d]
7    | '3'       | Digit → pop closest non-digit  | [c]    (removed 'd')
8    | '4'       | Digit → pop closest non-digit  | []     (removed 'c')
9    | 'e'       | Non-digit → push               | [e]
10   | 'f'       | Non-digit → push               | [e, f]

Resulting string: "ef"

Time Complexity:
- O(n), where n is the length of the input string.
- Each character is processed at most once and stack operations are O(1).

Space Complexity:
- O(n) for the stack array, where n is the length of the input string.
*/
