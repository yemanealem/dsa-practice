class Solution {
    public int[] finalPrices(int[] prices) {
         int n = prices.length;
        int[] result = prices.clone();

        int[] stack = new int[n]; // manual stack for indices
        int top = -1;

        for (int i = 0; i < n; i++) {
            // Apply discounts while current price is smaller or equal
            while (top >= 0 && prices[stack[top]] >= prices[i]) {
                int idx = stack[top--];
                result[idx] = prices[idx] - prices[i];
            }
            // Push current index
            stack[++top] = i;
        }
        return result; 
    }
}