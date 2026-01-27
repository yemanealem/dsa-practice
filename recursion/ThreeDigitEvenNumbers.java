public class ThreeDigitEvenNumbers {

    public static void findEven(int n) {
        // Base case: stop when number exceeds 999
        if (n > 999) {
            return;
        }

        // Check if number is even
        if (n % 2 == 0) {
            System.out.print(n + " ");
        }

        // Recursive call
        findEven(n + 1);
    }

    public static void main(String[] args) {
        findEven(100);
    }
}
