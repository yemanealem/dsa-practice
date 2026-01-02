import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> dic = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (dic.containsKey(complement)) {
                return new int[]{dic.get(complement), i};
            }

            dic.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = ts.solve(nums, target);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}
