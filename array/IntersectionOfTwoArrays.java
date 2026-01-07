import java.util.*;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        int[] output = new int[result.size()];
        int index = 0;
        for (int num : result) {
            output[index++] = num;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.println("Intersection of the two arrays:");
        System.out.println(Arrays.toString(result));
    }
}


/*

import java.util.*;

public class IntersectionSorted {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> result = new HashSet<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}











*/
