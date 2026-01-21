/*
Problem: Make The String Great
--------------------------------

Question:
Given a string `s` of lowercase and uppercase English letters, a "bad pair" is defined as two adjacent letters where one is lowercase and the other is uppercase of the same letter (e.g., 'a' and 'A'). 

The task is to repeatedly remove all such adjacent "bad pairs" until no such pairs remain and return the resulting "great" string.

Example:
- Input: "leEeetcode" -> Output: "leetcode"
- Input: "abBAcC" -> Output: ""
- Input: "s" -> Output: "s"

Description:
This solution uses a manual stack implemented with a character array. 
- Iterate through the string character by character.
- If the current character and the top of the stack form a "bad pair" (same letter, different case), pop the stack.
- Otherwise, push the character onto the stack.
- At the end, the stack contains the final "great" string, which we convert back to a string.

How it works (Step-by-Step):

1. Initialize an empty character array `stack` of length n (string length) and a pointer `top = -1`.
2. Iterate through each character `c` in the string:
   - If `top >= 0` and `stack[top]` forms a bad pair with `c`:
       - Pop the stack by decrementing `top`.
   - Else:
       - Push `c` onto the stack by incrementing `top` and assigning `stack[top] = c`.
3. After processing all characters, the stack contains the "great" string from index 0 to `top`.
4. Convert the stack slice `stack[0..top]` into a string and return it.

Example Trace (input: "leEeetcode"):

Step | Read Char | Action                   | Stack (0..top)
-----|-----------|-------------------------|----------------
1    | 'l'       | Push                     | [l]
2    | 'e'       | Push                     | [l, e]
3    | 'E'       | Pop (bad pair e/E)       | [l]
4    | 'e'       | Push                     | [l, e]
5    | 'e'       | Push                     | [l, e, e]
6    | 't'       | Push                     | [l, e, e, t]
7    | 'c'       | Push                     | [l, e, e, t, c]
8    | 'o'       | Push                     | [l, e, e, t, c, o]
9    | 'd'       | Push                     | [l, e, e, t, c, o, d]
10   | 'e'       | Push                     | [l, e, e, t, c, o, d, e]

Resulting string: "leetcode"

Time Complexity:
- O(n), each character is processed at most once.

Space Complexity:
- O(n), for the manual stack array.
*/


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
