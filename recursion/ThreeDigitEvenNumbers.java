import java.util.*;

public class ThreeDigitEvenNumbers {

    /**
     * Find all unique 3-digit even numbers that can be formed from the given digits.
     */
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];

        // Count how many times each digit is available
        for (int x : digits) {
            cnt[x]++;
        }

        List<Integer> ans = new ArrayList<>();

        // Iterate through all 3-digit even numbers (100 to 998)
        for (int x = 100; x < 1000; x += 2) {  // only even numbers
            int[] cnt1 = new int[10];
            int temp = x;

            // Count digits of the current number
            while (temp > 0) {
                cnt1[temp % 10]++;
                temp /= 10;
            }

            // Check if we have enough digits in the input to form this number
            boolean ok = true;
            for (int i = 0; i < 10; i++) {
                if (cnt1[i] > cnt[i]) {  // input doesn't have enough of digit i
                    ok = false;
                    break;
                }
            }

            if (ok) {
                ans.add(x);
            }
        }

        // Convert List<Integer> to int[]
        return ans.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        ThreeDigitEvenNumbers solution = new ThreeDigitEvenNumbers();

        int[] digits = {2, 1, 3, 0};
        int[] result = solution.findEvenNumbers(digits);

        System.out.println(Arrays.toString(result));
    }
}
