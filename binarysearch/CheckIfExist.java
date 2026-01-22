/*
LeetCode #1346 – Check If N and Its Double Exist

Problem:
Given an array of integers arr, check if there exist two distinct indices i and j
such that:
    arr[i] == 2 * arr[j]   OR   arr[j] == 2 * arr[i]

Return true if such a pair exists, otherwise return false.

Example 1:
Input: arr = [10, 2, 5, 3]
Output: true
Explanation: 10 is double of 5.

Example 2:
Input: arr = [3, 1, 7, 11]
Output: false

Approach (Using HashSet):

1. Create a HashSet to store numbers we have already seen.
2. For each number n in the array:
   a. Check if 2 * n exists in the set.
   b. Check if n is even and n / 2 exists in the set.
3. If either condition is true, return true.
4. If no such pair is found after iterating through the array, return false.

Why this works:
- HashSet allows O(1) average lookup time.
- We ensure indices are different by checking only previously seen elements.

Time Complexity: O(n)
Space Complexity: O(n)
*/

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
