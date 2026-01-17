import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {

    // Method to find Next Greater Element
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] stack = new int[n]; // manual stack
        int top = -1; // stack pointer
        Map<Integer, Integer> nextGreater = new HashMap<>();

        // Build next greater map for nums2
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && stack[top] <= nums2[i]) {
                top--; // pop smaller or equal elements
            }
            // If stack empty → no next greater, else top element
            nextGreater.put(nums2[i], (top == -1) ? -1 : stack[top]);
            stack[++top] = nums2[i]; // push current element
        }

        // Build result for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = solution.nextGreaterElement(nums1, nums2);

        for (int val : result) {
            System.out.print(val + " "); // Output: -1 3 -1
        }
    }
}
