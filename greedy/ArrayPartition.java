/**
 * LeetCode 561 – Array Partition
 *
 * QUESTION:
 * Given an integer array nums of size 2n, divide the array into n pairs
 * such that the sum of the minimum of each pair is maximized.
 *
 * Return the maximum possible sum.
 *
 * GREEDY IDEA:
 * - Sort the array in ascending order.
 * - Pair adjacent elements after sorting.
 * - Add the first element of each pair to the sum.
 *
 * WHY THIS WORKS:
 * - After sorting, pairing small numbers together prevents a small value
 *   from being wasted by pairing it with a very large number.
 * - The smaller element in each sorted pair is guaranteed to be the minimum.
 * - This greedy local choice leads to the global maximum sum.
 *
 * STEP-BY-STEP TRACE:
 * Example:
 * nums = [1,4,3,2]
 *
 * 1) Sort array → [1,2,3,4]
 * 2) Form pairs:
 *    (1,2) → min = 1
 *    (3,4) → min = 3
 * 3) Sum = 1 + 3 = 4
 *
 * RUNNING TIME:
 * - Sorting the array → O(n log n)
 * - Single pass to sum elements → O(n)
 * - Total Time Complexity: O(n log n)
 *
 * SPACE COMPLEXITY:
 * - Sorting uses O(1) extra space (for in-place sort)
 *
 * EDGE CASES:
 * - Negative numbers work correctly
 * - Order of input does not matter
 */

import java.util.Arrays;

public class ArrayPartition {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;

        // Add every first element of each pair
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
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
