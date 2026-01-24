/**
 * LeetCode Problem: Majority Element
 * 
 * Question:
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * Example:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Approach:
 * We solve this problem using Divide and Conquer (similar to Merge Sort).
 * 1. Divide the array into two halves recursively.
 * 2. Find the majority element in the left half and the right half.
 * 3. Merge step: if both halves agree on the majority, return it.
 *    Otherwise, count occurrences of both candidates in the current range
 *    and return the one with higher count.
 * 
 * This works because if an element is the majority overall, it must
 * be the majority in at least one of the halves.
 */

public class MajorityElement {

    // Main function to test the code
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        MajorityElement me = new MajorityElement();
        int result = me.majorityElement(nums);
        System.out.println("Majority Element is: " + result);

        // Step-by-step trace for nums = [2,2,1,1,1,2,2]
        System.out.println("\nTrace of Divide & Conquer:");
        me.trace(nums, 0, nums.length - 1, 0);
    }

    // Public method to call divide and conquer
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    // Divide and Conquer recursive function
    private int majorityElementRec(int[] nums, int left, int right) {
        // Base case: only one element
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftMajor = majorityElementRec(nums, left, mid);
        int rightMajor = majorityElementRec(nums, mid + 1, right);

        // If both halves agree on the majority element, return it
        if (leftMajor == rightMajor) {
            return leftMajor;
        }

        // Otherwise, count each element and return the one with higher frequency
        int leftCount = countInRange(nums, leftMajor, left, right);
        int rightCount = countInRange(nums, rightMajor, left, right);

        return leftCount > rightCount ? leftMajor : rightMajor;
    }

    // Helper method to count occurrences of num in nums[left...right]
    private int countInRange(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    // Extra: Trace function to show steps of divide and conquer
    private int trace(int[] nums, int left, int right, int depth) {
        // Indentation for visualizing recursion depth
        String indent = "  ".repeat(depth);

        if (left == right) {
            System.out.println(indent + "Base case: nums[" + left + "] = " + nums[left]);
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        System.out.println(indent + "Divide: nums[" + left + ".." + mid + "] and nums[" + (mid + 1) + ".." + right + "]");

        int leftMajor = trace(nums, left, mid, depth + 1);
        int rightMajor = trace(nums, mid + 1, right, depth + 1);

        System.out.println(indent + "Conquer: leftMajor = " + leftMajor + ", rightMajor = " + rightMajor);

        if (leftMajor == rightMajor) {
            System.out.println(indent + "Both halves agree. Majority = " + leftMajor);
            return leftMajor;
        }

        int leftCount = countInRange(nums, leftMajor, left, right);
        int rightCount = countInRange(nums, rightMajor, left, right);
        int majority = leftCount > rightCount ? leftMajor : rightMajor;

        System.out.println(indent + "Counts in range [" + left + ".." + right + "]: "
                + leftMajor + "=" + leftCount + ", " + rightMajor + "=" + rightCount
                + " => Majority = " + majority);

        return majority;
    }
}

/*

✅ How the trace works (for [2,2,1,1,1,2,2]):

Divide array into [2,2,1,1] and [1,2,2]

Further divide [2,2,1,1] → [2,2] and [1,1]

Base cases: [2], [2], [1], [1] → return the element

Conquer left halves: [2,2] → leftMajor=2, rightMajor=2 → Majority=2

Conquer right halves: [1,1] → leftMajor=1, rightMajor=1 → Majority=1

Merge [2,2] and [1,1] → leftMajor=2, rightMajor=1 → count occurrences → Majority=2

Right half [1,2,2] similarly resolves → Majority=2

Merge final left and right halves → counts → Majority=2

This trace prints each divide and conquer step, so you can see exactly how the algorithm works.



*/