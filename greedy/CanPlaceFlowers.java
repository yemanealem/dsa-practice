/**
 * LeetCode 605 – Can Place Flowers
 *
 * QUESTION:
 * You are given an integer array flowerbed where:
 *   - 0 means empty plot
 *   - 1 means a flower is already planted
 *
 * You are also given an integer n, the number of new flowers to plant.
 * Flowers cannot be planted in adjacent plots.
 *
 * Return true if n new flowers can be planted without violating the rule,
 * otherwise return false.
 *
 * GREEDY IDEA:
 * - Traverse the flowerbed from left to right.
 * - Whenever we find an empty plot (0), check:
 *     1) Left neighbor is empty or does not exist
 *     2) Right neighbor is empty or does not exist
 * - If both conditions are satisfied, plant a flower there (set it to 1)
 *   and decrease n.
 * - Stop early if n becomes 0.
 *
 * STEP-BY-STEP TRACE:
 * Example:
 * flowerbed = [1,0,0,0,1], n = 1
 *
 * Index 0 → already 1 → skip
 * Index 1 → 0 but left = 1 → cannot plant
 * Index 2 → 0, left = 0, right = 0 → plant flower
 *            flowerbed becomes [1,0,1,0,1], n = 0
 *
 * Since n == 0 → return true
 *
 * ANOTHER EXAMPLE:
 * flowerbed = [1,0,0,0,1], n = 2
 * Only one valid place exists → cannot plant 2 flowers → return false
 *
 * RUNNING TIME:
 * - We scan the array once → O(n), where n is the length of flowerbed
 *
 * SPACE COMPLEXITY:
 * - No extra space used (in-place modification) → O(1)
 *
 * WHY GREEDY WORKS:
 * - Planting a flower as soon as it is safe maximizes remaining space
 * - Delaying placement gives no advantage
 * - Local optimal choice leads to global optimal result
 */

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {

                boolean leftEmpty = (i == 0) || flowerbed[i - 1] == 0;
                boolean rightEmpty = (i == len - 1) || flowerbed[i + 1] == 0;

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1; // plant flower
                    n--;

                    if (n == 0) {
                        return true;
                    }
                }
            }
        }

        return n <= 0;
    }

    public static void main(String[] args) {
        int[] bed1 = {1, 0, 0, 0, 1};
        int[] bed2 = {1, 0, 0, 0, 1};
        int[] bed3 = {0, 0, 0, 0, 0};

        System.out.println(canPlaceFlowers(bed1, 1)); // true
        System.out.println(canPlaceFlowers(bed2, 2)); // false
        System.out.println(canPlaceFlowers(bed3, 2)); // true
    }
}
