/**
 * LeetCode 561 – Array Partition (Optimized Greedy)
 *
 * QUESTION:
 * Given an integer array nums of size 2n, divide the array into n pairs
 * such that the sum of the minimum of each pair is maximized.
 *
 * OPTIMIZED GREEDY IDEA:
 * - Instead of sorting (O(n log n)), use counting sort.
 * - Constraints: -10000 <= nums[i] <= 10000
 * - Count occurrences of each number.
 * - Traverse counts in increasing order.
 * - Greedily pick every second number as the minimum of a pair.
 *
 * WHY THIS IS GREEDY:
 * - We always take the smallest available numbers first.
 * - Pairing smaller numbers together maximizes the sum of minimums.
 * - Skipping every alternate value simulates sorted pairing.
 *
 * STEP-BY-STEP TRACE:
 * nums = [1,4,3,2]
 *
 * Counts after frequency array:
 * 1 → 1
 * 2 → 1
 * 3 → 1
 * 4 → 1
 *
 * Traverse in order:
 * take 1 → sum = 1
 * skip 2
 * take 3 → sum = 4
 * skip 4
 *
 * RESULT = 4
 *
 * RUNNING TIME:
 * - Counting elements → O(n)
 * - Traversing fixed range (20001) → O(1)
 * - Total Time Complexity: O(n)
 *
 * SPACE COMPLEXITY:
 * - Frequency array of fixed size (20001) → O(1)
 *
 * WHY THIS BEATS SORTING:
 * - Avoids comparison-based sorting
 * - Linear scan only
 * - Very fast for large inputs
 */

public class ArrayPartition {

    public static int arrayPairSum(int[] nums) {
        int[] count = new int[20001]; // range [-10000, 10000]
        int offset = 10000;

        // Count frequency
        for (int num : nums) {
            count[num + offset]++;
        }

        int sum = 0;
        boolean take = true;

        // Traverse counts in ascending order
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (take) {
                    sum += (i - offset);
                }
                take = !take; // alternate take/skip
                count[i]--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 3, 2};
        int[] nums2 = {6, 2, 6, 5, 1, 2};

        System.out.println(arrayPairSum(nums1)); // 4
        System.out.println(arrayPairSum(nums2)); // 9
    }
}
