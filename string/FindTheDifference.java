public class FindTheDifference {

    public static char findTheDifference(String s, String t) {
        int[] count = new int[26]; 

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return c; 
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        System.out.println("Extra character: " + findTheDifference(s, t));
    }
}
