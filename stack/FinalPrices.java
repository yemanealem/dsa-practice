import java.util.Arrays;

public class FinalPrices {

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && prices[stack[top]] >= prices[i]) {
                prices[stack[top--]] -= prices[i];
            }
            stack[++top] = i;
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        int[] result = finalPrices(prices);

        System.out.println(Arrays.toString(result));
    }
}
