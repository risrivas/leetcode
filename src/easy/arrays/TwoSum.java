package easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 11, 10, 7, 15}, 9);
        Arrays.stream(result).forEach(System.out::println);
    }


    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 1) return new int[]{0};
        if (nums.length == 2) return new int[]{0, 1};

        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(key, i);
            }
        }

        return result;
    }
}
