class Solution {
    public int calculate(String s) {
           if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int result = 0;       // Total result
        int lastNumber = 0;   // Last number to handle * and /
        int currentNumber = 0;
        char operator = '+';  // Previous operator

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            // If it's an operator or last char, compute
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                switch (operator) {
                    case '+':
                        result += lastNumber;   // add previous number
                        lastNumber = currentNumber;
                        break;
                    case '-':
                        result += lastNumber;
                        lastNumber = -currentNumber;
                        break;
                    case '*':
                        lastNumber *= currentNumber;
                        break;
                    case '/':
                        lastNumber /= currentNumber;
                        break;
                }
                operator = c;
                currentNumber = 0;
            }
        }

        // Add the last number
        result += lastNumber;
        return result;
    }
}