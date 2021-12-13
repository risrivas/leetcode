package easy.arrays;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] result = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        Arrays.stream(result).forEach(System.out::println);

        int[] result1 = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Arrays.stream(result1).forEach(System.out::println);
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        if (nums1.length == 1 && nums2.length == 1 && nums1[0] == nums2[0]) return nums1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.merge(num, 1, Integer::sum);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && (map.get(num) > 0)) {
                resultList.add(num);
                map.merge(num, -1, Integer::sum);
            }
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }

}
