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

//O(n) time
//O(n) space

/*
🔍 How the Algorithm Works

We want to give each item a discount equal to the first cheaper (or equal) item to its right.

To do this efficiently, we use a manual stack that stores indices of items that are still waiting for a discount.

🧠 Key Idea (Monotonic Stack)

The stack keeps indices of prices in increasing order

When we see a smaller or equal price, it becomes the discount for previous items

🪜 Step-by-Step Walkthrough
Example
prices = [8, 4, 6, 2, 3]

Variables

stack[] → stores indices

top → points to the top of the stack

1️⃣ i = 0 → price = 8

Stack is empty → push index 0

stack = [0]

2️⃣ i = 1 → price = 4

8 ≥ 4 → discount found for index 0

Update: 8 - 4 = 4

Pop index 0

Push index 1

prices = [4, 4, 6, 2, 3]
stack = [1]

3️⃣ i = 2 → price = 6

4 < 6 → no discount

Push index 2

stack = [1, 2]

4️⃣ i = 3 → price = 2

6 ≥ 2 → discount → 6 - 2 = 4

4 ≥ 2 → discount → 4 - 2 = 2

Push index 3

prices = [4, 2, 4, 2, 3]
stack = [3]

5️⃣ i = 4 → price = 3

2 < 3 → no discount

Push index 4

stack = [3, 4]

✅ Final Result
[4, 2, 4, 2, 3]


Items left in the stack never found a cheaper item, so their prices stay the same.

⚡ Why This Is Efficient

Each index is pushed once

Each index is popped once

Total operations = O(n)

No nested loops, no built-in stack, no extra arrays.
*/