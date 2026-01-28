/**
 * LeetCode 2600 – K Items With the Maximum Sum
 *
 * QUESTION:
 * You are given three integers:
 *   - numOnes  → count of 1s
 *   - numZeros → count of 0s
 *   - numNegOnes → count of -1s
 *
 * You must pick exactly k items such that their sum is maximized.
 *
 * GREEDY IDEA:
 * - Always pick the largest value first.
 * - Priority order: 1 → 0 → -1
 * - Take as many 1s as possible, then 0s, then -1s only if needed.
 *
 * STEP-BY-STEP TRACE:
 * Example:
 * numOnes = 3, numZeros = 2, numNegOnes = 1, k = 4
 *
 * Pick 1 → sum = 1
 * Pick 1 → sum = 2
 * Pick 1 → sum = 3
 * Pick 0 → sum = 3
 *
 * RESULT = 3
 *
 * RUNNING TIME:
 * - Constant operations only → O(1)
 *
 * SPACE COMPLEXITY:
 * - No extra space → O(1)
 *
 * WHY GREEDY WORKS:
 * - Choosing the largest available value always increases or preserves sum
 * - Any other choice gives a smaller or equal sum
 */

public class KItemsWithMaximumSum {

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;

        // Take as many 1s as possible
        int takeOnes = Math.min(numOnes, k);
        sum += takeOnes;
        k -= takeOnes;

        // Take zeros (does not change sum)
        int takeZeros = Math.min(numZeros, k);
        k -= takeZeros;

        // Take -1s if still need items
        sum -= Math.min(numNegOnes, k);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(3, 2, 1, 4)); // 3
        System.out.println(kItemsWithMaximumSum(3, 2, 1, 6)); // 2
        System.out.println(kItemsWithMaximumSum(1, 0, 3, 3)); // -1
    }
}
