/*
LeetCode #1385 – Find the Distance Value Between Two Arrays

Optimal Approach:
- Sort arr2.
- For each element x in arr1, find the closest element in arr2 using binary search.
- If the minimum distance > d, count x.
- Return the total count.
*/

import java.util.Arrays;

public class DistanceValueSolution {

    // Main method for testing
    public static void main(String[] args) {
        DistanceValueSolution solution = new DistanceValueSolution();

        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        System.out.println(solution.findTheDistanceValue(arr1, arr2, d)); // Output: 2

        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 5, 6};
        int d2 = 1;
        System.out.println(solution.findTheDistanceValue(arr3, arr4, d2)); // Output: 3

        int[] arr5 = {5};
        int[] arr6 = {1, 3, 5, 7, 9};
        int d3 = 0;
        System.out.println(solution.findTheDistanceValue(arr5, arr6, d3)); // Output: 0
    }

    // Function to find the distance value
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2); // Sort arr2 for binary search
        int count = 0;

        for (int x : arr1) {
            if (isValid(x, arr2, d)) {
                count++;
            }
        }

        return count;
    }

    // Binary search to check if x is valid
    private boolean isValid(int x, int[] arr2, int d) {
        int left = 0;
        int right = arr2.length - 1;
        int minDistance = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int dist = Math.abs(x - arr2[mid]);
            minDistance = Math.min(minDistance, dist);

            if (arr2[mid] == x) {
                // Closest distance = 0, cannot count x
                return false;
            } else if (arr2[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return minDistance > d; // Only count if min distance > d
    }
}
