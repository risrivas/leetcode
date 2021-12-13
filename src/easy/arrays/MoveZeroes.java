package easy.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        // int[] nums = new int[]{2, 1};
        moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int nonzero_idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, nonzero_idx, i);
                nonzero_idx++;
            }
        }

        if (nonzero_idx < nums.length) {
            for (int i = nonzero_idx; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
