import java.util.*;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();

        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                resultList.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersect(nums1, nums2);

        System.out.println("Intersection of Two Arrays II:");
        System.out.println(Arrays.toString(result));
    }
}

/*



import java.util.*;

public class IntersectionOfTwoArraysII_TwoPointers {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> resultList = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert List to int[]
        int[] result = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            result[k] = resultList.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] result = intersect(nums1, nums2);

        System.out.println("Intersection of Two Arrays II (Two Pointers):");
        System.out.println(Arrays.toString(result));
    }
}









*/
