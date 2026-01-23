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
        System.out.println("Full rows: " + sol.arrangeCoins(n)); 
    }
}
