import java.util.PriorityQueue;

/**
 * LeetCode 703: Kth Largest Element in a Stream
 *
 * Example:
 * k = 3, nums = [4,5,8,2]
 * add(3) -> returns 4
 * add(5) -> returns 5
 * add(10) -> returns 5
 * add(9) -> returns 8
 * add(4) -> returns 8
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

        /*
         Initial Heap (k=3):
              4
             / \
            5   8
         k-th largest = 4 (root of min-heap)
        */
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

        /*
         Step by Step Heap Visualization:

         After add(3):
             Heap: [4,5,8] (3 < 4, ignored)
             k-th largest = 4

         After add(5):
             Heap before: [4,5,8]
             Add 5 -> remove 4 -> Heap: [5,5,8]
             k-th largest = 5

         After add(10):
             Heap before: [5,5,8]
             Add 10 -> remove 5 -> Heap: [5,10,8]
             k-th largest = 5

         After add(9):
             Heap before: [5,10,8]
             Add 9 -> remove 5 -> Heap: [8,10,9]
             k-th largest = 8

         After add(4):
             Heap before: [8,10,9]
             4 < 8 -> ignored
             k-th largest = 8
        */

        return minHeap.peek(); // Root of min-heap is the k-th largest element
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println("Add 3 -> k-th largest: " + kthLargest.add(3));
        System.out.println("Add 5 -> k-th largest: " + kthLargest.add(5));
        System.out.println("Add 10 -> k-th largest: " + kthLargest.add(10));
        System.out.println("Add 9 -> k-th largest: " + kthLargest.add(9));
        System.out.println("Add 4 -> k-th largest: " + kthLargest.add(4));
    }
}
