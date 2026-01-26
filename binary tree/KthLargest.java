import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add initial numbers to the heap, keeping only k largest
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);           // Add new value
        if (minHeap.size() > k) {     // Remove smallest if heap size exceeds k
            minHeap.poll();
        }
        return minHeap.peek();        // Root of min-heap is k-th largest
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
