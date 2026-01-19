public class RemoveOuterParentheses {

    // Method to remove outermost parentheses
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int depth = 0; // Tracks current nesting depth
        
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (depth > 0) { // Not outermost
                    result.append(c);
                }
                depth++; // Increase depth
            } else { // c == ')'
                depth--; // Decrease depth
                if (depth > 0) { // Not outermost
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }

    // Main method to test
    public static void main(String[] args) {
        RemoveOuterParentheses solution = new RemoveOuterParentheses();
        String input = "(()())(())";
        String output = solution.removeOuterParentheses(input);
        System.out.println(output); // Expected Output: "()()()"
    }
}
