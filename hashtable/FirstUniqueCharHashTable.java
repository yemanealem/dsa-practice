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


/*


How It Works (Step by Step)

Create frequency array

int[] count = new int[26] tracks the number of times each lowercase letter appears.

'a' → index 0, 'b' → index 1, … 'z' → index 25.

Count all characters

Loop through the string once.

Example: "leetcode" → 'l':1, 'e':3, 't':1, 'c':1, 'o':1, 'd':1.

Find first unique character

Loop through the string again.

Check count[s.charAt(i) - 'a'] == 1.

The first character with count 1 is the answer.

Return result

If no character has count 1 → return -1



*/