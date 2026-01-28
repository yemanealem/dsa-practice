

public class KItemsWithMaximumSum {

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;

        // Take as many 1s as possible
        int takeOnes = Math.min(numOnes, k);
        sum += takeOnes;
        k -= takeOnes;

        // Take zeros (does not change sum)
        int takeZeros = Math.min(numZeros, k);
        k -= takeZeros;

        // Take -1s if still need items
        sum -= Math.min(numNegOnes, k);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(3, 2, 1, 4)); // 3
        System.out.println(kItemsWithMaximumSum(3, 2, 1, 6)); // 2
        System.out.println(kItemsWithMaximumSum(1, 0, 3, 3)); // -1
    }
}
