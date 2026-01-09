public class ValidAnagram  {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26]; 

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int count : alphabet) {
            if (count != 0) return false;
        }

        return true; 
    }

    // Test
    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram")); 
        System.out.println(sol.isAnagram("rat", "car"));        
    }
}
