public class MissingNumber {
    public static int missingNumberXOR(int[] nums) {
        int missing = nums.length; 
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i]; 
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {0, 1};
        int[] nums3 = {9,6,4,2,3,5,7,0,1};

        System.out.println("Missing number in nums1: " + missingNumberXOR(nums1)); 
        System.out.println("Missing number in nums2: " + missingNumberXOR(nums2)); 
        System.out.println("Missing number in nums3: " + missingNumberXOR(nums3)); 
    }
}
