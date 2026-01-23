// Mocking the LeetCode GuessGame class
class GuessGame {
    private int picked;

    public GuessGame(int pickedNumber) {
        this.picked = pickedNumber;
    }

    // This simulates the LeetCode guess API
    public int guess(int num) {
        if (num == picked) return 0;
        return num < picked ? 1 : -1;
    }
}

// Your solution class
public class Solution extends GuessGame {

    public Solution(int pickedNumber) {
        super(pickedNumber);
    }

    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid; // Found the number
            } else if (res < 0) {
                right = mid - 1; // Go lower
            } else {
                left = mid + 1; // Go higher
            }
        }

        return -1; // Should never reach here
    }

    // Main method to test the code
    public static void main(String[] args) {
        int n = 10;       // Range 1..n
        int picked = 6;   // Picked number

        Solution solution = new Solution(picked);
        int result = solution.guessNumber(n);

        System.out.println("Picked number is: " + result); // Should print 6
    }
}
