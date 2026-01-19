import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone();   // copy original prices
        Deque<Integer> stack = new ArrayDeque<>(); // stack of indices

        for (int i = 0; i < n; i++) {
            // Apply discount to previous items
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                result[idx] = prices[idx] - prices[i];
            }
            // Push current index
            stack.push(i);
        }
        return result;
    }
}
