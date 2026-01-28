public class LongestPalindrome {

    // Greedy method to find longest palindrome length
    public static int longestPalindrome(String s) {
        int[] freq = new int[128]; // ASCII characters

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        // Step 2: Greedily use character counts
        for (int count : freq) {
            if (count % 2 == 0) {
                // Use all even counts
                length += count;
            } else {
                // Use count - 1 to make it even
                length += count - 1;
                hasOdd = true;
            }
        }

        // Step 3: Add one odd character in the center if exists
        if (hasOdd) {
            length += 1;
        }

        return length;
    }

    // Main method
    public static void main(String[] args) {
        String s1 = "abccccdd";
        String s2 = "a";
        String s3 = "Aa";

        System.out.println(longestPalindrome(s1)); // 7
        System.out.println(longestPalindrome(s2)); // 1
        System.out.println(longestPalindrome(s3)); // 1
    }
}
