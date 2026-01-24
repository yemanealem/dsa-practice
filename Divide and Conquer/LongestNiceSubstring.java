public class LongestNiceSubstring {

    public static void main(String[] args) {
        LongestNiceSubstring solver = new LongestNiceSubstring();
        String s = "YazaAay";
        System.out.println("Longest Nice Substring: " + solver.longestNiceSubstring(s));
    }

    public String longestNiceSubstring(String s) {
        int[] res = helper(s, 0, s.length());
        return s.substring(res[0], res[0] + res[1]);
    }

    // Returns {startIndex, length} of longest nice substring in s[left..right-1]
    private int[] helper(String s, int left, int right) {
        if (right - left < 2) return new int[]{left, 0}; // too short to be nice

        // Count presence of each character in this substring
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) lower[c - 'a'] = true;
            else upper[c - 'A'] = true;
        }

        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c) && !upper[c - 'a'] || Character.isUpperCase(c) && !lower[c - 'A']) {
                // split around this character
                int[] leftRes = helper(s, left, i);
                int[] rightRes = helper(s, i + 1, right);
                return leftRes[1] >= rightRes[1] ? leftRes : rightRes;
            }
        }

        // All characters are nice
        return new int[]{left, right - left};
    }
}
