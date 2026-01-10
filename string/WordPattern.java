import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(w)) return false;
            } else {
                if (used.contains(w)) return false; 
                map.put(c, w);
                used.add(w);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();

        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println(wp.wordPattern(pattern1, s1)); 

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println(wp.wordPattern(pattern2, s2)); 

        String pattern3 = "aaaa";
        String s3 = "dog dog dog dog";
        System.out.println(wp.wordPattern(pattern3, s3)); 

        String pattern4 = "abba";
        String s4 = "dog dog dog dog";
        System.out.println(wp.wordPattern(pattern4, s4)); 
    }
}
