import java.util.HashSet;
import java.util.Set;

public class CheckIfExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int n : arr) {

            // Check if double exists
            if (seen.contains(2 * n)) {
                return true;
            }

            // Check if half exists (only if n is even)
            if (n % 2 == 0 && seen.contains(n / 2)) {
                return true;
            }

            // Add current number to set
            seen.add(n);
        }

        return false;
    }

    public static void main(String[] args) {
        CheckIfExist solution = new CheckIfExist();

        int[] arr1 = {10, 2, 5, 3};
        System.out.println(solution.checkIfExist(arr1)); // true

        int[] arr2 = {3, 1, 7, 11};
        System.out.println(solution.checkIfExist(arr2)); // false

        int[] arr3 = {0, 0};
        System.out.println(solution.checkIfExist(arr3)); // true
    }
}
