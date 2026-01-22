/*
LeetCode #1385 – Find the Distance Value Between Two Arrays

Approach:
1. Sort arr2.
2. For each element x in arr1:
   - Use binary search to find the closest element to x in arr2.
   - If the minimum absolute difference > d, count it.
3. Return the count.

Time Complexity:
- Sorting: O(m log m)
- Binary Search for each element in arr1: O(n log m)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int x : arr1) {
            if (isValid(x, arr2, d)) {
                count++;
            }
        }
        return count;
    }

    // Binary search to check if x has any value within distance d in arr2
    private boolean isValid(int x, int[] arr2, int d) {
        int left = 0, right = arr2.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Math.abs(arr2[mid] - x) <= d) {
                return false; // violates distance condition
            }

            if (arr2[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;

        System.out.println(solution.findTheDistanceValue(arr1, arr2, d)); // Output: 2
    }
}
