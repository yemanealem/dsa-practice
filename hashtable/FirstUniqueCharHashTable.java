public class FirstUniqueCharHashTable {

    // Method to find the index of the first unique character
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] count = new int[26]; // array to count 'a' to 'z'

        // Count frequency of each character
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Find the first character with frequency 1
        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; // no unique character
    }

    // Main method to test
    public static void main(String[] args) {
        FirstUniqueCharHashTable sol = new FirstUniqueCharHashTable();

        String test1 = "leetcode";
        System.out.println("Test 1: " + sol.firstUniqChar(test1)); 

        String test2 = "loveleetcode";
        System.out.println("Test 2: " + sol.firstUniqChar(test2)); 

        String test3 = "aabbcc";
        System.out.println("Test 3: " + sol.firstUniqChar(test3)); 

        String test4 = "z";
        System.out.println("Test 4: " + sol.firstUniqChar(test4)); 

        String test5 = "aabbccddeef";
        System.out.println("Test 5: " + sol.firstUniqChar(test5)); 
    }
}
