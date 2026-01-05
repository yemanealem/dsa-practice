import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;          
        int j = n - 1;          
        int k = m + n - 1;     

        System.out.println("Initial nums1: " + Arrays.toString(nums1));
        System.out.println("nums2:         " + Arrays.toString(nums2));
        System.out.println("----------------------------------");

        while (i >= 0 && j >= 0) {
            System.out.println(
                "Comparing nums1[" + i + "]=" + nums1[i] +
                " and nums2[" + j + "]=" + nums2[j]
            );

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                System.out.println("→ Place " + nums1[i] + " at index " + k);
                i--;
            } else {
                nums1[k] = nums2[j];
                System.out.println("→ Place " + nums2[j] + " at index " + k);
                j--;
            }
            k--;

            System.out.println("Current nums1: " + Arrays.toString(nums1));
            System.out.println("----------------------------------");
        }

        // Copy remaining elements from nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            System.out.println(
                "Copy remaining nums2[" + j + "]=" + nums2[j] +
                " to nums1[" + k + "]"
            );
            j--;
            k--;
            System.out.println("Current nums1: " + Arrays.toString(nums1));
        }

        System.out.println("Final merged nums1: " + Arrays.toString(nums1));
    }

   
    public static void main(String[] args) {
        MergeSortedArray merger = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        merger.merge(nums1, m, nums2, n);
    }
}
