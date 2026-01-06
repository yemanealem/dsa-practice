public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;  
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(obj.singleNumber(nums)); 
    }
}

/* 

 Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int key : map.keySet()) {
        if (map.get(key) == 1) {
            return key;
        }
    }
    return -1;


*/
