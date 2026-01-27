import java.util.*;

public class ThreeDigitEvenNumbers {

    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];

        // Count available digits
        for (int x : digits) {
            cnt[x]++;
        }

        List<Integer> ans = new ArrayList<>();

        // Iterate through all 3-digit even numbers
        for (int x = 100; x < 1000; x += 2) {
            int[] cnt1 = new int[10];
            int temp = x;

            // Count digits of current number
            while (temp > 0) {
                cnt1[temp % 10]++;
                temp /= 10;
            }

            boolean ok = true;
            for (int i = 0; i < 10; i++) {
                if (cnt1[i] > cnt[i]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                ans.add(x);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    // Main method for testing
    public static void main(String[] args) {
        ThreeDigitEvenNumbers solution = new ThreeDigitEvenNumbers();

        int[] digits = {2, 1, 3, 0};
        int[] result = solution.findEvenNumbers(digits);

        System.out.println(Arrays.toString(result));
    }
}
