public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // left is the correct insertion position
        return left;
    }

    public static void main(String[] args) {
        SearchInsert solution = new SearchInsert();

        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println(solution.searchInsert(nums1, target1)); // Output: 2

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println(solution.searchInsert(nums2, target2)); // Output: 1

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println(solution.searchInsert(nums3, target3)); // Output: 4

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println(solution.searchInsert(nums4, target4)); // Output: 0
    }
}


/*
LeetCode #35 – Search Insert Position

Problem:
You are given a sorted array of distinct integers and a target value.
If the target is found in the array, return its index.
If not, return the index where it should be inserted to maintain the sorted order.

Example:
Input: nums = [1, 3, 5, 6], target = 2
Output: 1

Approach (Binary Search):

1. Since the array is sorted, we can use binary search to achieve O(log n) time complexity.
2. Initialize two pointers:
   - left = 0 (start of array)
   - right = nums.length - 1 (end of array)
3. While left <= right:
   a. Calculate mid index.
   b. If nums[mid] == target → return mid (target found).
   c. If nums[mid] < target → move left pointer to mid + 1.
   d. If nums[mid] > target → move right pointer to mid - 1.
4. If the loop ends without finding the target, the left pointer will point to
   the correct position where the target should be inserted.
5. Return left.

Time Complexity: O(log n)
Space Complexity: O(1)
*/