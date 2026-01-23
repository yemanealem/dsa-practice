class Solution {
  private int[] segTree;
    private int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;

        // Segment tree (4 * n is safe size)
        segTree = new int[4 * n];
        build(baskets, 0, n - 1, 1);

        int unplaced = 0;

        for (int fruit : fruits) {
            // Try to place fruit
            if (findAndUse(fruit, 0, n - 1, 1) == -1) {
                unplaced++;
            }
        }

        return unplaced;
    }

    // Build max segment tree
    private void build(int[] baskets, int low, int high, int idx) {
        if (low == high) {
            segTree[idx] = baskets[low];
            return;
        }

        int mid = low + (high - low) / 2;
        build(baskets, low, mid, idx * 2);
        build(baskets, mid + 1, high, idx * 2 + 1);
        segTree[idx] = Math.max(segTree[idx * 2], segTree[idx * 2 + 1]);
    }

    // Find leftmost basket with capacity >= fruit and mark it used
    private int findAndUse(int fruit, int low, int high, int idx) {
        // No basket in this segment can hold the fruit
        if (segTree[idx] < fruit) {
            return -1;
        }

        // Leaf node → use this basket
        if (low == high) {
            segTree[idx] = -1;
            return low;
        }

        int mid = low + (high - low) / 2;
        int result;

        // Always try LEFT child first (leftmost rule)
        if (segTree[idx * 2] >= fruit) {
            result = findAndUse(fruit, low, mid, idx * 2);
        } else {
            result = findAndUse(fruit, mid + 1, high, idx * 2 + 1);
        }

        // Update current node after change
        segTree[idx] = Math.max(segTree[idx * 2], segTree[idx * 2 + 1]);

        return result;
    }
}