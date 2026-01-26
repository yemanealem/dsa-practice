import java.util.PriorityQueue;

/**
 * LeetCode 703: Kth Largest Element in a Stream
 *
 * Design a class to find the k-th largest element in a stream.
 * Implement the KthLargest class:
 *  - KthLargest(int k, int[] nums) initializes the object with the integer k and the stream of integers nums.
 *  - int add(int val) appends the integer val to the stream and returns the element representing
 *    the k-th largest element in the stream.
 *
 * Example:
 * Input:
 *   k = 3, nums = [4, 5, 8, 2]
 *   add(3) -> returns 4
 *   add(5) -> returns 5
 *   add(10) -> returns 5
 *   add(9) -> returns 8
 *   add(4) -> returns 8
 */

class KthLargest {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int kValue;

    public KthLargest(int k, int[] nums) {
        kValue = k;

        // Initialize heap with the k largest elements from nums
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() == k) {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            } else {
                minHeap.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (minHeap.size() >= kValue) {
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }
        } else {
            minHeap.add(val);
        }
        return minHeap.peek(); // Root of min-heap is the k-th largest element
    }

    public static void main(String[] args) {
        // Initialize KthLargest with k = 3 and nums = [4,5,8,2]
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        // Add elements one by one and trace the k-th largest
        System.out.println("Add 3 -> k-th largest: " + kthLargest.add(3));
        System.out.println("Add 5 -> k-th largest: " + kthLargest.add(5));
        System.out.println("Add 10 -> k-th largest: " + kthLargest.add(10));
        System.out.println("Add 9 -> k-th largest: " + kthLargest.add(9));
        System.out.println("Add 4 -> k-th largest: " + kthLargest.add(4));
    }
}
