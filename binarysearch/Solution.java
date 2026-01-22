class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2); // Sort arr2 for binary search
        int result = 0;

        for (int x : arr1) {
            int idx = lowerBound(arr2, x);

            // Left neighbor
            int left = (idx - 1 >= 0) ? arr2[idx - 1] : Integer.MIN_VALUE;
            // Right neighbor (or exact position)
            int right = (idx < arr2.length) ? arr2[idx] : Integer.MAX_VALUE;

            if (x - left > d && right - x > d) {
                result++;
            }
        }

        return result;
    }

    // Lower-bound binary search: first index where arr[idx] >= target
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int firstTrueIndex = arr.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                firstTrueIndex = mid; // record feasible index
                right = mid - 1;      // look for earlier index
            } else {
                left = mid + 1;
            }
        }

        return firstTrueIndex;
    }
}