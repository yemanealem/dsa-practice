class FactorialPrintStructure {

    static int factorial(int n) {
        System.out.println("Entering factorial(" + n + ")");

        if (n != 0) {
            int result = n * factorial(n - 1); 
            System.out.println("Returning " + result + " from factorial(" + n + ")");
            return result;
        } else {
            System.out.println("Base case reached at factorial(" + n + "), returning 1");
            return 1;
        }
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println(number + " factorial = " + result);
    }
}
