public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        IsPowerOfTwo checker = new IsPowerOfTwo();

        int[] testCases = {1, 2, 3, 4, 16, 18, 0, -2};

        for (int n : testCases) {
            System.out.println("n = " + n + " -> " + checker.isPowerOfTwo(n));
        }
    }
}
