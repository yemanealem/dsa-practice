import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharHashTable {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character found
    }

    // Main method to test
    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println("Test 1: " + firstUniqChar(s1)); // 0

        String s2 = "loveleetcode";
        System.out.println("Test 2: " + firstUniqChar(s2)); // 2

        String s3 = "aabbcc";
        System.out.println("Test 3: " + firstUniqChar(s3)); // -1
    }
}
