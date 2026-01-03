import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Before: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("After:  " + Arrays.toString(nums));
    }
}


/*
              
How Java handles arrays

In Java:

Arrays are objects

When you pass an array to a method, Java passes a copy of the reference

Both the caller and the method point to the same array in memory

So when we modify nums[i], we modify the original array.


*/


