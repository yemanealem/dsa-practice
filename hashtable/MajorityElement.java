
public class MajorityElement {

    // Method to find the majority element
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // Initial candidate
        int count = 0;           // Counter for the candidate

        for (int num : nums) {
            if (count == 0) {
                // Pick a new candidate if count drops to 0
                candidate = num;
            }
            // Increment or decrement count based on match
            count += (candidate == num) ? 1 : -1;
        }

        // Candidate is guaranteed to be the majority element
        return candidate;
    }

    // Main method for testing
    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = {1, 1, 1, 2, 3, 1};

        System.out.println("Majority of nums1: " + solution.majorityElement(nums1)); // 3
        System.out.println("Majority of nums2: " + solution.majorityElement(nums2)); // 2
        System.out.println("Majority of nums3: " + solution.majorityElement(nums3)); // 1
    }
}
