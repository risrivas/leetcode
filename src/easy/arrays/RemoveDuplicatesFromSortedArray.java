package easy.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int nums[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        // System.out.println(removeDuplicates(new int[]{1, 1, 2}));

        Arrays.stream(nums).forEach(System.out::println);
    }

    /**
     * Two pointers approach:
     * first pointer to iterate through the numbers
     * second pointer to move only when found unique element
     *
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int uniqueIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[uniqueIdx] != nums[i]) {
                nums[++uniqueIdx] = nums[i];
            }
        }

        return ++uniqueIdx;
    }

}
