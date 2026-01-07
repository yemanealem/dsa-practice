import java.util.*;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count frequency of nums1
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();

        // Find intersection
        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                resultList.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        // Convert List to int[]
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
