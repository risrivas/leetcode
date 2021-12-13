package easy.arrays;

import java.util.Arrays;

public class RotateArrays {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        Arrays.stream(nums).forEach(n -> System.out.printf("%s ", n));
    }

    /**
     * 1) Rotate the whole array
     * 2) Rotate first k elements
     * 3) Rotate last k+1 to n elements
     *
     * @param nums
     * @param k
     */
    static void rotate(int[] nums, int k) {
        k %= nums.length;
        if (nums.length == 1 || k == 0) return;

        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length - 1);
    }

    private static void rotate(int[] nums, int start, int last) {
        while (start < last) {
            int tmp = nums[start];
            nums[start] = nums[last];
            nums[last] = tmp;
            start++;
            last--;
        }
    }
}
