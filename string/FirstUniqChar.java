public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] count = new int[26]; // frequency array for 'a'-'z'

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar sol = new FirstUniqChar();
        System.out.println(sol.firstUniqChar("leetcode"));       
        System.out.println(sol.firstUniqChar("loveleetcode"));   
        System.out.println(sol.firstUniqChar("aabb"));           
    }
}
