package codingsignals.arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicate {

    public static void main(String[] args) {
        System.out.println(firstDuplicate(new int[]{2, 1, 3, 5, 4, 2, 3, 2}));
        System.out.println(firstDuplicate(new int[]{1, 1, 2, 2, 1}));
    }

    private static int firstDuplicate(int[] a) {
        Map<Integer, Integer> dup_idx = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (dup_idx.containsKey(a[i])) {
//                if (dup_idx.get(a[i]) == a.length + 1)
//                    dup_idx.put(a[i], i);
                return a[i];
            } else {
                dup_idx.put(a[i], a.length + 1);
            }
        }

        return -1;

        /*int minIdx = dup_idx.values().stream().reduce(Integer::min).orElse(-1);

        if (minIdx == -1 || minIdx >= a.length) return -1;
        else return a[minIdx];*/
    }
}
