import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer prevIndex = lastSeen.get(nums[i]);

            if (prevIndex != null && i - prevIndex <= k) {
                return true;
            }

            // Always update to latest index
            lastSeen.put(nums[i], i);
        }
        return false;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println("Test 1: " + containsNearbyDuplicate(nums1, k1)); // true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println("Test 2: " + containsNearbyDuplicate(nums2, k2)); // true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println("Test 3: " + containsNearbyDuplicate(nums3, k3)); // false
    }
}


/*

I used a HashMap to remember the last index where each number appeared.

For each number:

If it’s in the map and the distance to the current index ≤ k, we return true.

Otherwise, we update the number’s last index.

If we finish the array without finding such a pair, we return false.


*/