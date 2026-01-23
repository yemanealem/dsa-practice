/*
LeetCode: Fruit Into Baskets II

QUESTION:
You are given two integer arrays:
- fruits[i] represents the size of the i-th fruit.
- baskets[j] represents the capacity of the j-th basket.

Rules:
1. Each fruit must be placed into the LEFTMOST available basket
   whose capacity is >= the fruit size.
2. Each basket can be used at most once.
3. If a fruit cannot be placed into any basket, it is counted as unplaced.

Return the number of unplaced fruits.

--------------------------------------------------

HOW IT WORKS (Segment Tree Approach):

1. We build a MAX segment tree over the baskets array.
   - Each node stores the maximum basket capacity in its range.

2. For each fruit:
   - Start from the root of the segment tree.
   - If the maximum value in a range is < fruit size,
     no basket in that range can hold the fruit.
   - Otherwise:
       a) Always check the LEFT child first to satisfy the
          "leftmost basket" rule.
       b) When we reach a leaf node, we mark that basket as used
          by setting its value to -1.
       c) Update the segment tree on the way back up.

3. If no valid basket is found, increment the unplaced counter.

--------------------------------------------------

TIME COMPLEXITY:
- Building segment tree: O(n)
- Each fruit placement: O(log n)
- Total: O((n + m) log n)

SPACE COMPLEXITY:
- Segment tree: O(n)
*/

class FruitIntoBasketsII {

    private int[] segTree;
    private int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;

        // Segment tree (4 * n is a safe size)
        segTree = new int[4 * n];
        build(baskets, 0, n - 1, 1);

        int unplaced = 0;

        for (int fruit : fruits) {
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
        if (segTree[idx] < fruit) {
            return -1;
        }

        if (low == high) {
            segTree[idx] = -1; // mark basket as used
            return low;
        }

        int mid = low + (high - low) / 2;

        int result;
        if (segTree[idx * 2] >= fruit) {
            result = findAndUse(fruit, low, mid, idx * 2);
        } else {
            result = findAndUse(fruit, mid + 1, high, idx * 2 + 1);
        }

        segTree[idx] = Math.max(segTree[idx * 2], segTree[idx * 2 + 1]);
        return result;
    }

    // Main method to test locally
    public static void main(String[] args) {
        FruitIntoBasketsII sol = new FruitIntoBasketsII();

        int[] fruits = {4, 2, 5};
        int[] baskets = {3, 5, 4};

        System.out.println(sol.numOfUnplacedFruits(fruits, baskets));
        // Expected output: 1
    }
}
