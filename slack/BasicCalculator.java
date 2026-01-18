class BasicCalculator {
    public int calculate(String s) {
        int n = s.length();
        int result = 0;         // total result
        int lastNumber = 0;     // last processed number to handle * / precedence
        int currentNumber = 0;
        char operator = '+';    // previous operator

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Build current number
            if (c >= '0' && c <= '9') {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            // If operator or end of string
            if ((c < '0' && c != ' ') || i == n - 1) {
                switch (operator) {
                    case '+': lastNumber = currentNumber; break;
                    case '-': lastNumber = -currentNumber; break;
                    case '*': lastNumber *= currentNumber; break;
                    case '/': lastNumber /= currentNumber; break;
                }

                // If next operator is + or - or end, accumulate to result
                if (c == '+' || c == '-' || i == n - 1) {
                    result += lastNumber;
                    lastNumber = 0; // reset lastNumber for next computation
                }

                operator = c;
                currentNumber = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculator sol = new BasicCalculator();
        System.out.println(sol.calculate("3+2*2"));      // 7
        System.out.println(sol.calculate(" 3/2 "));      // 1
        System.out.println(sol.calculate(" 3+5 / 2 "));  // 5
        System.out.println(sol.calculate("14-3/2"));     // 13
        System.out.println(sol.calculate("100+200*3/2")); // 400
    }
}


