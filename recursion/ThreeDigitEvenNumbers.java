import java.util.*;

public class ThreeDigitEvenNumbers {

    /*
    ============================================================================
    LeetCode Problem: Finding 3-Digit Even Numbers
    ============================================================================

    Problem:
    Given an array of digits (0–9), find all unique 3-digit even numbers
    that can be formed using these digits. Each digit can be used at most once.

    Rules:
    1. Each number must be exactly 3 digits.
    2. Hundreds digit cannot be 0.
    3. Last digit must be even.
    4. Return the answer sorted in ascending order.

    Example:
    Input: digits = [2, 1, 3, 0]
    Output: [102, 120, 130, 132, 210, 230, 302, 310, 312, 320]

    ---------------------------------------------------------------------------
    Approach: Optimized Counting
    ---------------------------------------------------------------------------

    1. Count how many times each digit appears in the input array:
       cnt[i] = frequency of digit i
       Example: digits = [2,1,3,0] → cnt = [1,1,1,1,0,0,0,0,0,0]

    2. Iterate over all 3-digit even numbers (100 to 998):
       - Step by 2 to consider only even numbers.
       - Example numbers: 100, 102, 104, ..., 998

    3. For each number, count how many times each digit is used:
       - cnt1[i] = count of digit i in current number
       - Example: number = 102 → cnt1 = [1,1,1,0,0,...]

    4. Compare cnt1 with cnt to check if the number can be formed:
       - For all digits i: cnt[i] >= cnt1[i]
       - If true, the number can be formed → add to result.

    5. Return the result sorted as int[].

    ---------------------------------------------------------------------------
    Step-by-step Trace Example for digits = [2,1,3,0]
    ---------------------------------------------------------------------------

    Input count: cnt = [1,1,1,1,0,0,0,0,0,0]

    Iterating 3-digit even numbers:

    102: cnt1 = [1,1,1,0,...] → cnt1 <= cnt → OK → add 102
    104: cnt1 = [1,0,1,0,1,...] → cnt1[4] > cnt[4] → skip
    120: cnt1 = [0,1,1,0,0,0,0,0,0,0] → cnt1 <= cnt → OK → add 120
    130: cnt1 = [0,1,0,1,0,...] → OK → add 130
    132: cnt1 = [0,1,1,1,...] → OK → add 132
    210: cnt1 = [1,1,1,...] → OK → add 210
    230: cnt1 = [1,0,1,1,...] → OK → add 230
    302: cnt1 = [0,1,1,1,...] → OK → add 302
    310: cnt1 = [1,1,0,1,...] → OK → add 310
    312: cnt1 = [0,1,1,1,...] → OK → add 312
    320: cnt1 = [1,0,1,1,...] → OK → add 320

    Output: [102, 120, 130, 132, 210, 230, 302, 310, 312, 320]

    ---------------------------------------------------------------------------
    Time Complexity: O(450 × 10) ≈ O(1)
    Space Complexity: O(10) for counting arrays + O(result) for output
    ============================================================================
    */

    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];

        // Count available digits
        for (int x : digits) {
            cnt[x]++;
        }

        List<Integer> ans = new ArrayList<>();

        // Iterate through all 3-digit even numbers
        for (int x = 100; x < 1000; x += 2) {  // only even numbers
            int[] cnt1 = new int[10];
            int temp = x;

            // Count digits of current number
            while (temp > 0) {
                cnt1[temp % 10]++;
                temp /= 10;
            }

            // Check if input digits are enough to form this number
            boolean ok = true;
            for (int i = 0; i < 10; i++) {
                if (cnt1[i] > cnt[i]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                ans.add(x);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    // Main method for testing
    public static void main(String[] args) {
        ThreeDigitEvenNumbers solution = new ThreeDigitEvenNumbers();

        int[] digits = {2, 1, 3, 0};
        int[] result = solution.findEvenNumbers(digits);

        System.out.println(Arrays.toString(result));
    }
}
