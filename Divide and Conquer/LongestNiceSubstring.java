public class LongestNiceSubstring {

    public static void main(String[] args) {
        LongestNiceSubstring solver = new LongestNiceSubstring();
        String s = "YazaAay";
        String result = solver.longestNiceSubstring(s);
        System.out.println("Longest Nice Substring: " + result);
    }

    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return ""; // Base case: string too short to be nice

        // Build a set of characters in the current string
        java.util.Set<Character> set = new java.util.HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // Check each character: if it breaks the nice property, split
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                continue; // OK
            }
            // Split at this character and solve recursively
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));
            return left.length() >= right.length() ? left : right;
        }

        // All characters are nice
        return s;
    }
}
