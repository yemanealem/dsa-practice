public class HappyNumber {

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquares(slow);          
            fast = sumOfSquares(sumOfSquares(fast)); 
        } while (slow != fast);

        return slow == 1;
    }

    // Helper: sum of squares of digits
    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] testNumbers = {19, 2, 7, 20, 1, 100};

        for (int num : testNumbers) {
            System.out.println(num + " is happy? " + isHappy(num));
        }
    }
}
