public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) return true; // all caps
        if (word.equals(word.toLowerCase())) return true; // all lowercase
        if (Character.isUpperCase(word.charAt(0)) && 
            word.substring(1).equals(word.substring(1).toLowerCase())) return true; // first capital
        return false;
    }

    public static void main(String[] args) {
        String word1 = "USA";
        String word2 = "FlaG";
        String word3 = "Google";

        System.out.println(detectCapitalUse(word1)); // true
        System.out.println(detectCapitalUse(word2)); // false
        System.out.println(detectCapitalUse(word3)); // true
    }
}
