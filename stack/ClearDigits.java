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



/*
With out using stack
public class ClearDigitsNoStack {

    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        while (i < sb.length()) {
            char ch = sb.charAt(i);

            if (Character.isDigit(ch)) {
                // Find closest non-digit to the left
                int left = i - 1;
                while (left >= 0 && Character.isDigit(sb.charAt(left))) {
                    left--; // skip any digits
                }
                // Remove the non-digit if it exists
                if (left >= 0) sb.deleteCharAt(left);

                // Remove current digit (shifted if left was removed)
                sb.deleteCharAt(left >= 0 ? i - 1 : i);

                // Reset index to max(left,0) to check from new position
                i = Math.max(left, 0);
            } else {
                i++; // move to next character
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ClearDigitsNoStack solution = new ClearDigitsNoStack();

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

The deleteCharAt inside a StringBuilder shifts all characters right of the index, which is why it becomes O(n²) in worst case.

Using a manual stack array (as in your first implementation) is O(n) time, which is more efficient for large strings.


*/


/*

With two pointer

public class ClearDigitsTwoPointer {

    public String clearDigits(String s) {
        char[] arr = s.toCharArray();
        int write = 0; // pointer to write the next valid char

        for (int read = 0; read < arr.length; read++) {
            char ch = arr[read];

            if (Character.isDigit(ch)) {
                // Remove closest non-digit to the left
                int temp = write - 1;
                while (temp >= 0 && Character.isDigit(arr[temp])) {
                    temp--; // skip consecutive digits
                }
                if (temp >= 0) write = temp; // remove closest non-digit
                // Skip current digit
            } else {
                arr[write++] = ch; // keep non-digit
            }
        }

        return new String(arr, 0, write);
    }

    public static void main(String[] args) {
        ClearDigitsTwoPointer solution = new ClearDigitsTwoPointer();

        String[] testCases = {
            "a1b2c3",       // ""
            "x9y8z7",       // ""
            "ab12cd34ef",   // "ef"
            "1a2b3c",       // ""
            "abc123def"     // "def"
        };

        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + solution.clearDigits(test));
            System.out.println("----------------------");
        }
    }
}


*/


/*

/*
How it works (Two-Pointer Approach):

1. Iterate over the string from left to right using a read pointer.
2. Maintain a write pointer to build the result in-place.
3. If a character is a digit:
   - Move the write pointer back to remove the closest non-digit to its left.
   - Skip adding the current digit.
4. If a character is not a digit:
   - Write it at the current write pointer position.
   - Increment the write pointer.
5. After processing all characters, the first 'write' characters in the array contain the remaining string.
6. Convert the array from index 0 to write-1 into a string and return it.

Example Trace (input: "ab12cd34ef"):

Step | Read Char | Action                          | Array (0..write-1)
-----|-----------|---------------------------------|------------------
1    | 'a'       | Non-digit → write               | [a]
2    | 'b'       | Non-digit → write               | [a, b]
3    | '1'       | Digit → remove closest non-digit| [a]    (removed 'b')
4    | '2'       | Digit → remove closest non-digit| []     (removed 'a')
5    | 'c'       | Non-digit → write               | [c]
6    | 'd'       | Non-digit → write               | [c, d]
7    | '3'       | Digit → remove closest non-digit| [c]    (removed 'd')
8    | '4'       | Digit → remove closest non-digit| []     (removed 'c')
9    | 'e'       | Non-digit → write               | [e]
10   | 'f'       | Non-digit → write               | [e, f]

Resulting string: "ef"

Time Complexity:
- O(n), where n is the length of the input string.
- Each character is processed exactly once.

Space Complexity:
- O(n) for the character array used to build the result in-place.
*/





*/