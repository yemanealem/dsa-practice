import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = 0; 

        System.out.println("Initial array: " + Arrays.toString(nums));
        System.out.println("Value to remove: " + val);
        System.out.println("----------------------------------");

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Checking nums[" + i + "] = " + nums[i]);

            if (nums[i] != val) {
                nums[k] = nums[i];
                System.out.println(
                    "→ Keep " + nums[i] + ", place at index " + k
                );
                k++;
            } else {
                System.out.println("→ Remove " + nums[i]);
            }

            System.out.println("Current array: " + Arrays.toString(nums));
            System.out.println("----------------------------------");
        }

        System.out.println("Final array (first " + k + " elements are valid): "
                + Arrays.toString(Arrays.copyOf(nums, k)));

        return k;
    }

    public static void main(String[] args) {
        RemoveElement remover = new RemoveElement();

        int[] nums = {3, 2, 2, 3, 4, 3};
        int val = 3;

        int newLength = remover.removeElement(nums, val);

        System.out.println("Returned length: " + newLength);
    }
}
/*
Key Idea (Before Steps)

i → scans every element

k → points to where the next valid element should go

Elements before k are always valid


*/
