public class MajorityElement {

    // Main function to test the code
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        MajorityElement me = new MajorityElement();
        int result = me.majorityElement(nums);
        System.out.println("Majority Element is: " + result);
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
}
