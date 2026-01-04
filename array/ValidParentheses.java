import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) { 
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (mapping.get(c) != topElement) {
                    return false; 
                }
            } else {
                stack.push(c); 
            }
        }

        return stack.isEmpty(); 
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));        
        System.out.println(isValid("()[]{}"));    
        System.out.println(isValid("(]"));       
        System.out.println(isValid("([{}])"));   
        System.out.println(isValid("([)]"));      
    }
}
