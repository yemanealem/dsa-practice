import java.util.HashSet;

public class ContainsDuplicate {

    // Method to check if array contains duplicates
    public boolean containsDuplicate(int[] nums) {
        // Pre-size the HashSet to avoid resizing (load factor 0.75)
        int initialCapacity = (int) (nums.length / 0.75f) + 1;
        HashSet<Integer> dups = new HashSet<>(initialCapacity);

        for (int n : nums) {
            // add() returns false if element already exists
            if (!dups.add(n)) {
                return true; // duplicate found
            }
        }
        return false; // no duplicates
    }

    // Main method for testing
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 2};

        System.out.println("Test case 1: " + solution.containsDuplicate(nums1)); // false
        System.out.println("Test case 2: " + solution.containsDuplicate(nums2)); // true
    }
}

/*
 int initialCapacity = (int) (nums.length / 0.75f) + 1;

HashSet in Java resizes automatically when it exceeds 75% of its capacity.

To avoid resizing (which is slow), we pre-calculate the initial capacity.

Formula: capacity = expectedSize / loadFactor + 1

nums.length / 0.75 → ensures enough space for all numbers.

Example: if nums.length = 5, then 5 / 0.75 ≈ 6.66 → 7.

. HashSet<Integer> dups = new HashSet<>(initialCapacity);

Creates a HashSet called dups to store numbers we have seen so far.

Pre-sizing it improves performance because no resizing occurs.



*/