/**
 * LeetCode Problem: Arrange Coins
 * 
 * Question:
 * You have n coins and want to build a staircase.
 * The first row has 1 coin, the second row has 2 coins, the third row has 3 coins, and so on.
 * Find the total number of full staircase rows you can build with n coins.
 * 
 * Example:
 * Input: n = 8
 * Output: 3
 * Explanation:
 * Row 1 -> 1 coin
 * Row 2 -> 2 coins
 * Row 3 -> 3 coins
 * Row 4 -> 4 coins (cannot build, only 2 coins left)
 * Total full rows = 3
 * 
 * Approach: Binary Search
 * -----------------------
 * 1. The total coins needed for k rows = k*(k+1)/2.
 * 2. We want the largest k such that k*(k+1)/2 <= n.
 * 3. Use binary search:
 *    - Initialize left = 0, right = n
 *    - While left <= right:
 *        - mid = left + (right - left)/2
 *        - coinsNeeded = mid*(mid+1)/2
 *        - If coinsNeeded == n -> return mid (exact match)
 *        - If coinsNeeded < n -> left = mid + 1 (try more rows)
 *        - If coinsNeeded > n -> right = mid - 1 (too many coins)
 * 4. Return right, which is the last full row that fits.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class ArrangeCoins {
    public int arrangeCoins(int n) {
        long left = 0, right = n; // use long to avoid overflow
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coinsNeeded = mid * (mid + 1) / 2;
            
            if (coinsNeeded == n) {
                return (int) mid; // exact match
            } else if (coinsNeeded < n) {
                left = mid + 1; // can try more rows
            } else {
                right = mid - 1; // too many coins, reduce rows
            }
        }
        
        return (int) right; // right will be the last full row
    }

    // Main to test
    public static void main(String[] args) {
        ArrangeCoins sol = new ArrangeCoins();
        int n = 8;
        System.out.println("Full rows: " + sol.arrangeCoins(n)); // Output: 3
    }
}
