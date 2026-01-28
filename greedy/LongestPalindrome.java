/**
 * LeetCode 409 – Longest Palindrome
 *
 * QUESTION:
 * Given a string s, return the length of the longest palindrome that can be built
 * using the letters of s. Letters are case-sensitive and can be rearranged.
 *
 * GREEDY IDEA:
 * - A palindrome uses character pairs symmetrically.
 * - All even counts can be fully used.
 * - From odd counts, we can use (count - 1) to make them even.
 * - Only ONE odd character is allowed in the center.
 *
 * STEP-BY-STEP TRACE (Example: "abccccdd"):
 * 1) Count frequencies:
 *    a = 1, b = 1, c = 4, d = 2
 *
 * 2) Process counts:
 *    c = 4 → use all → length = 4
 *    d = 2 → use all → length = 6
 *    a = 1 → use 0, mark odd exists
 *    b = 1 → use 0, mark odd exists
 *
 * 3) Since an odd count exists, add 1 center character
 *    Final length = 6 + 1 = 7
 *
 * RUNNING TIME:
 * - Counting characters: O(n), where n is the length of the string
 * - Iterating over fixed ASCII array (128): O(1)
 * - Total Time Complexity: O(n)
 *
 * SPACE COMPLEXITY:
 * - Frequency array of size 128 → O(1)
 *
 * WHY GREEDY WORKS:
 * - Pairs always increase palindrome length
 * - More than one odd character cannot be used
 * - Taking maximum pairs first guarantees the longest palindrome
 */

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        int[] freq = new int[128];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        // Greedily use counts
        for (int count : freq) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                hasOdd = true;
            }
        }

        // Add one odd character in the center
        if (hasOdd) {
            length += 1;
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd")); // 7
        System.out.println(longestPalindrome("a"));        // 1
        System.out.println(longestPalindrome("Aa"));       // 1
    }
}
